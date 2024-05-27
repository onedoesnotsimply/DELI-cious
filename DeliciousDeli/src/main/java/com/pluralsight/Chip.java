package com.pluralsight;

public class Chip {
    private String type;
    private double price;

    Chip(String type){
        this.type=type;
        this.price=1.5;
    }

    @Override
    public String toString() {
        return "type : " + type + '\n' +
                "price : $" + price;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
