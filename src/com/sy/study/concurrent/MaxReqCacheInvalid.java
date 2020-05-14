package com.sy.study.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author songyi
 * @date 2020-05-14 17:37
 * @Description:
 */
public class MaxReqCacheInvalid {

    private ConcurrentHashMap<Integer, FutureTask<ShopDto>> shopTaskMap= new ConcurrentHashMap<>();
    private ShopDto getFromCache(int shopId){
       // System.out.println("����getFromCache");
        return null;
    }

    public ShopDto badLoadShop(int shopId) {
        ShopDto dto = getFromCache(shopId);
        if (dto == null) {
            try {
                dto = new ShopDBTask(shopId).call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dto;
    }


    public ShopDto loadShop(Integer shopId) {
        ShopDto dto = getFromCache(shopId);
        if (dto == null) {
            FutureTask<ShopDto> future = shopTaskMap.get(shopId);
            if (future == null) {
                FutureTask<ShopDto> task = new FutureTask<>(new ShopDBTask(shopId));
                //concurrentMapֻ��һ���ɹ�
                future = shopTaskMap.putIfAbsent(shopId, task);
                if (future == null) {
                   //todo  ����ÿ�run��ִ��ʱ�䣬���run�ܿ�ͽ����ˣ����в��ǵ����⣬֧��10������
                    //todo ���ĸĳ��� ��ͣ5ms������֧��100��������1000��Ҳ����
                    //
                    future = task;
                    future.run();//ȷ������ֻ��һ���߳�����DB
                }
                try {
                    dto = future.get(200, TimeUnit.MILLISECONDS);
                    //System.out.println(dto);
                } catch (Exception e) {
                    return null;
                } finally {
                    shopTaskMap.remove(shopId);
                }
            }
        }
        return dto;
    }
}
class ShopDBTask implements Callable<ShopDto> {
    private int shopId;
    public ShopDBTask(int shopId){ this.shopId= shopId; }
    @Override
    public ShopDto call() throws Exception{
        ShopDto dto= loadFromDB(shopId);
        if(dto == null){
            dto = new ShopDto();
        }
        setCache(shopId, dto);
        return dto;
    }
    private void setCache(int shopId, ShopDto shopDto){
        //System.out.println("���õ�����");

    }
    private ShopDto loadFromDB(int id){
        System.out.println("�����ݿ��");
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class ShopDto{
    private int shpoId;
}
