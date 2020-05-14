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
       // System.out.println("调用getFromCache");
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
                //concurrentMap只有一个成功
                future = shopTaskMap.putIfAbsent(shopId, task);
                if (future == null) {
                   //todo  这里得看run的执行时间，如果run很快就结束了，就有并非的问题，支持10个并发
                    //todo 下文改成了 暂停5ms，可以支持100个，但是1000个也不行
                    //
                    future = task;
                    future.run();//确保本机只有一个线程命中DB
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
        //System.out.println("设置到缓存");

    }
    private ShopDto loadFromDB(int id){
        System.out.println("从数据库查");
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
