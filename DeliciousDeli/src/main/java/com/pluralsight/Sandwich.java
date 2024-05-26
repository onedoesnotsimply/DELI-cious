package com.pluralsight;

import java.util.ArrayList;

public class Sandwich {
    private String meat;
    private String cheese;
    private boolean extraMeat;
    private boolean extraCheese;
    private String size;
    private String bread;
    private ArrayList<String> sauces;
    private ArrayList<String> toppings;
    private boolean isToasted;
    private double price;

    public Sandwich(String size, String meat, String cheese, boolean extraMeat, boolean extraCheese, String bread, boolean isToasted) {
        this.size = size;
        this.meat = meat;
        this.cheese = cheese;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
        this.bread = bread;
        this.isToasted = isToasted;
        this.sauces = new ArrayList<>();
        this.toppings = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "meat='" + meat + '\'' +
                ", cheese='" + cheese + '\'' +
                ", extraMeat=" + extraMeat +
                ", extraCheese=" + extraCheese +
                ", size='" + size + '\'' +
                ", bread='" + bread + '\'' +
                ", sauces=" + sauces +
                ", toppings=" + toppings +
                ", isToasted=" + isToasted +
                ", price=" + price +
                '}';
    }

    // Getters and setters
    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public ArrayList<String> getSauces() {
        return sauces;
    }

    public void setSauces(ArrayList<String> sauces) {
        this.sauces = sauces;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
