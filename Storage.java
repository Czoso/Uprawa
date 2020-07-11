package com.company;

public class Storage {
    private String good;
    private int quantity;
    private int sellPrice;
    private int buyPrice;
    public Storage ( String good, int quantity, int sellPrice, int buyPrice){
        this.good=good;
        this.quantity=quantity;
        this.sellPrice=sellPrice;
        this.buyPrice=buyPrice;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public int getSellPrice(){return sellPrice;}
    public void setSellPrice(int sellPrice){ this.sellPrice=sellPrice;}
    public int getBuyPrice(){return buyPrice;}
    public void setBuyPrice(int buyPrice){ this.buyPrice=buyPrice;}


}
