package com.company;

import java.util.Scanner;

public class Human {
    private String name;
    private int cash;

    public Human(String name, int cash){
        this.name=name;
        this.cash=cash;

    }

    public void setCash(int cash){
        this.cash=cash;
    }

    public int getCash()
    {
        return cash;
    }

    public String getName()
    {
        return name;
    }

}
