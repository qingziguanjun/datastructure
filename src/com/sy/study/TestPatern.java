package com.sy.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author songyi
 * @date 2020-05-12 16:15
 * @Description:
 */
public class TestPatern {
    private static ExecutorService executor = Executors.newFixedThreadPool(15);
    public static void main(String[] args) {
        String pa= "^[0-9]*$";
        String a = "dddddddddd";
        boolean matches = a.matches(pa);
        System.out.println(matches);
        String a1 = "/a/b/c";
        String[] split = a1.split("/");
        System.out.println(split[0]);
    }
}
