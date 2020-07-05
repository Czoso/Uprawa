package com.company;

public class Field {
    private int size = 10;
    private String name;

    public Field (int size, String name){
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
