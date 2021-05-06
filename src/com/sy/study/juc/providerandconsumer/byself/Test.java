package com.sy.study.juc.providerandconsumer.byself;


import java.util.HashMap;
import java.util.Map;

/**
 * @author songyi
 * @date 2021-02-04 14:28
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
//        SyStorage syStorage = new SyStorage();
//        new Thread(new SyProducer(syStorage)).start();
//        new Thread(new SyProducer(syStorage)).start();
//        new Thread(new SyProducer(syStorage)).start();
//        new Thread(new SyConsumer(syStorage)).start();
//        new Thread(new SyConsumer(syStorage)).start();
//        new Thread(new SyConsumer(syStorage)).start();

        String str = "test";
        Map<String, String> map = new HashMap<>();
        System.out.println(map.get("test"));
        boolean test = str.equals(map.get("ddd"));
        System.out.println(test);
    }
}
