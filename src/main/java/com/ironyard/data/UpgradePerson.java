package com.ironyard.data;

/**
 * Created by jasonskipper on 1/24/17.
 */
public class UpgradePerson {
    private String name;
    private int age;
    private Address homeAddress;
    private Address workAddress;

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {
        this.workAddress = workAddress;
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

    public String toString(){
        return String.format("(name: %s, age: %d, homeAddress: %s, workAddress: %s )", getName(), getAge(), getHomeAddress(), getWorkAddress());
    }
}
