package com.company;

public class Seed {
    private String name;
    private int quantity;
    private int price;
    public Seed(String name, int quantity, int price){
        this.name=name;
        this.quantity=quantity;
        this.price=price;

    }
    public String getName(){
        return name;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public int getQuantity(){
        return quantity;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }
}
