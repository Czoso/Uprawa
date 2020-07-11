package com.company;

public class Animal implements Cloneable {
    private String name;
    private int age;
    private int matureAge;
    private int price;
    private boolean illness;
    private int hunger;
    private int mess;

    public Animal (String name, int age, int matureAge, int price, boolean illness, int hunger, int mess){
        this.name=name;
        this.age=age;
        this.matureAge=matureAge;
        this.price=price;
        this.illness=illness;
        this.hunger=hunger;
        this.mess=mess;
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
    public void setHunger(int hunger){
        this.hunger=hunger;

    }
    public int getMatureAge(){
        return matureAge;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public int getMess(){
        return mess;
    }
    public void setMess(int mess){
        this.mess=mess;
    }


}
