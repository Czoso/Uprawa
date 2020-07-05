package com.company;

public class Seed {
    private String name;
    private int quantity;
    public Seed(String name, int quantity){
        this.name=name;
        this.quantity=quantity;

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
}
