package com.sy.study;

/**
 * @author songyi
 * @date 2020-05-12 16:15
 * @Description:
 */
public class TestPatern {
    public static void main(String[] args) {
        String pa= "^[0-9]*$";
        String a = "dddddddddd";
        boolean matches = a.matches(pa);
        System.out.println(matches);


    }
}
