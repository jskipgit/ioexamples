package com.ironyard.data;

/**
 * Created by jasonskipper on 1/24/17.
 */
public class Person {
    private String name;
    private String city;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return String.format("(name: %s, age: %d, city: %s))", getName(), getAge(), getCity());
    }
}
