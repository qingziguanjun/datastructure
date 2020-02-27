package com.sy.study.lamda;

public class Person {

    public void printPerson() {
        System.out.println("¥Ú”°¡À£∫" + getName());
    }

    public enum Sex {
        MALE, FEMALE
    }

    public Person(int age, String name, Sex gender, String emailAddress) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;
    String name;
    Sex gender;
    String emailAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}