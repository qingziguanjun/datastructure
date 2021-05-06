package com.train20210423.composite;

/**
 * @author songyi
 * @date 2021-04-30 15:00
 * @Description:
 */
public class ButtonComponents extends Components{
    public ButtonComponents(String name) {
        super(name);
    }

    @Override
    void print() {
        System.out.println("myname" + this.name);
    }
}
