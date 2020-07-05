package com.company;

public class Crop {
    private String name;
    private int age;
    private int price;
    private int harvestAge;
    private int id;

    public Crop(String name, int age, int price, int harvestAge, int id){
        this.name=name;
        this.age=age;
        this.price=price;
        this.harvestAge=harvestAge;
        this.id=id;
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
    public int getHarvestAge(){
        return harvestAge;
    }
    public int getId(){
        return id;
    }

}
