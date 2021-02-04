package com.rpc.serial;

import java.io.Serializable;


public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String age;

    public User(String age, String name){
        this.age = age;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
