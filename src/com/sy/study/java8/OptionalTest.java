package com.sy.study.java8;

import java.util.Optional;

/**
 * @author songyi
 * @date 2021-02-02 19:54
 * @Description:
 */
public class OptionalTest {
    public static void main(String[] args) {
        String str = "12";
        String test = Optional.ofNullable(str).map(n -> n.toString()).orElse("false");
        System.out.println(test);
        //±¨NPE
        //String test2 = Optional.of(null).map(n -> n.toString()).orElse("false");
        String test3 = Optional.ofNullable(null).map(n -> n.toString()).orElse("false");
        System.out.println(test3);
    }
}
