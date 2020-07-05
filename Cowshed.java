package com.company;

public class Cowshed {

    private int size;
    private String name;

    public Cowshed (int size, String name){
        this.size=size;
        this.name=name;
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
}
