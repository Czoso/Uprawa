package com.company;

public class Animal {
    private String name;
    private int age;
    private int matureAge;
    private int price;
    private boolean illness;
    private int hunger;

    public Animal (String name, int age, int matureAge, int price, boolean illness, int hunger){
        this.name=name;
        this.age=age;
        this.matureAge=matureAge;
        this.price=price;
        this.illness=illness;
        this.hunger=hunger;
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
    public void setAge(int age){
        this.age=age;
    }
    public boolean getIllness(){
        return illness;
    }
    public void setIllness(boolean illness){
        this.illness=illness;
    }
    public int getHunger(){
        return hunger;
    }
    public void setHunger(){

    }
    public int getMatureAge(){
        return matureAge;
    }

}
