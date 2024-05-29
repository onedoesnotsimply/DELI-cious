package com.pluralsight;

import java.util.ArrayList;

public class PhillyCheeseSteak extends Sandwich {
    private ArrayList<String> sauces;
    private ArrayList<String> toppings;

    public PhillyCheeseSteak() {
        super("8\"","Steak","American",false, false, "White", true);
        sauces = new ArrayList<>();
        toppings = new ArrayList<>();
        sauces.add("Mayo");
        toppings.add("Peppers");
        setSauces(sauces);
        setToppings(toppings);
    }
}
