package com.javaSElearn;

public class data {
    private String name;
    private int age;
    private char sex;

    public data() {
        System.out.println("data的无参构造器启动");
    }

    public data(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        System.out.println("data的有参构造器启动了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "data{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
