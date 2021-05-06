package com.train20210423.composite;

/**
 * @author songyi
 * @date 2021-04-30 14:52
 * @Description:
 */
public abstract class Components {

    protected String name;

    public Components(String name){
        this.name = name;
    }
    /**
     * ¥Ú”°
     */
    abstract void print();
}
