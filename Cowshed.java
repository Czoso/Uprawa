package com.company;

public class Cowshed {

    private int size;
    private String name;
    private int status;
    int price;

    public Cowshed (int size, String name, int status, int price){
        this.size=size;
        this.name=name;
        this.status=status;
        this.price=price;
    }
    public void setSize(int size){
        this.size=size;
    }
    public String getName(){
        return name;
    }
    public int getSize(){
        return size;
    }
    public void setStatus(int status){
        this.status=status;
    }
    public int getStatus(){
        return status;
    }
    public int getPrice(){
        return status;
    }
    public void setPrice(int status){
        this.status=status;
    }
}
