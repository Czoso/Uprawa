package com.company;

import java.util.Scanner;

public class Human {
    private Scanner name;
    private int cash;

    public Human(Scanner name, int cash){
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

    public Scanner getName()
    {
        return name;
    }

}
