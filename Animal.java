package com.company;

public class Animal {
    private String name;
    private int age;
    private int price;

    public Animal (String name, int age, int price){
        this.name=name;
        this.age=age;
        this.price=price;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public int getAge(){
        return age;
    }

}
