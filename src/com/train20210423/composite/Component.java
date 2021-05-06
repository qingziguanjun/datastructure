package com.train20210423.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songyi
 * @date 2021-04-28 17:45
 * @Description:
 */
public class Component {
    private String name;
    List<Component> content;
    private static String TAB = "    ";

    public Component(String name){
        this.name = name;
        content = new ArrayList<>();
    }

    public void addCentont(Component component){
        this.content.add(component);
    }

    public void print(String str){
        System.out.println(str + name);
        for(Component c : content){
            c.print(str + TAB);
        }
    }
}
