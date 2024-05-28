package com.pluralsight;

import java.util.ArrayList;

public class Order {
    private ArrayList<Sandwich> sandwiches;
    private ArrayList<Drink> drinks;
    private ArrayList<Chip> chips;
    //private double total;

    public Order(){
        this.sandwiches = new ArrayList<>();
        this.drinks=new ArrayList<>();
        this.chips=new ArrayList<>();
        //this.total = 0;
    }


    @Override
    public String toString() {
        return "Order\n" +
                "Sandwiches\n" + sandwiches +
                "\nDrinks\n" + drinks +
                "\nChips\n" + chips +
                "\nOrder Total : " + getTotal();
    }


    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Chip> getChips() {
        return chips;
    }

    /*public void setTotal(double total) {
        this.total = total;
    }

     */

    public double getTotal() {
        double total = 0.0;
        for (Sandwich sandwich:sandwiches){
            total+=sandwich.getPrice();
        }
        for (Drink drink:drinks){
            total+=drink.getPrice();
        }
        for (Chip chip:chips){
            total+= chip.getPrice();
        }
        return total;
    }
}
