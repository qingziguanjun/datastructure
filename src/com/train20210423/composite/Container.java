package com.train20210423.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songyi
 * @date 2021-04-30 14:54
 * @Description:
 */
public class Container extends Components{
    private List<Components> children;

    public Container(String name) {
        super(name);
        children = new ArrayList<>();
    }

    public void addChild(Components components){
        children.add(components);
    }
    @Override
    void print() {
        for(Components components : children){
            components.print();
        }
    }
}
