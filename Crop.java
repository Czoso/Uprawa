package com.company;

public class Crop implements Cloneable {
    private String name;
    private int age;
    private int price;
    private int harvestAge;
    private int seedId;
    private int water;

    public Crop(String name, int age, int price, int harvestAge, int seedId, int water){
        this.name=name;
        this.age=age;
        this.price=price;
        this.harvestAge=harvestAge;
        this.seedId=seedId;
        this.water=water;
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
    public void setHarvestAge(int harvestAge){
            this.harvestAge=harvestAge;
    }
    public int getSeedId(){
        return seedId;
    }
    public void setWater(int water){
        this.water=water;
    }
    public int getWater(){
        return water;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
