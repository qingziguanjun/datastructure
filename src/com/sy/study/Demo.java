package com.sy.study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author songyi
 * @date 2020-11-02 11:16
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> iterator = list.iterator();
        Integer next = iterator.next();
        iterator.remove();
        System.out.println(list);   
        iterator.remove();
    }
}
