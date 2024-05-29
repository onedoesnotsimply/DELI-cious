package com.pluralsight;

import java.util.ArrayList;

public class BLT extends Sandwich{
    private ArrayList<String> sauces;
    private ArrayList<String> toppings;

    public BLT() {
        super("8\"", "Bacon", "Cheddar", false, false, "White", true);
        sauces = new ArrayList<>();
        toppings = new ArrayList<>();
        sauces.add("Ranch");
        toppings.add("Lettuce");
        toppings.add("Tomato");
        setSauces(sauces);
        setToppings(toppings);
    }
}
