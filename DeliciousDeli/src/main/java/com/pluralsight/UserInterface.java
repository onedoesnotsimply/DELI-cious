package com.pluralsight;

import java.awt.*;
import java.util.*;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    static Order order = new Order();

    public UserInterface(){}

    public void homeScreen() {
        System.out.println("""
                Welcome to DELI-cious Deli!
                ---------------------------
                1) New Order
                0) Exit""");

        try{
            int choice = scanner.nextInt();

            if (choice == 1){
                orderScreen();
            } else if (choice==0) {
                System.exit(0);
            } else {
                System.out.println("Input out of range");
                homeScreen();
            }

        } catch (InputMismatchException e){
            System.out.println("\nERROR: input must be a number\n");
            scanner.nextLine();
            homeScreen();
        }
    }

    private void orderScreen() {
        System.out.println("""
                ---------------------------
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) Checkout
                0) Cancel Order""");

        try{
            int choice = scanner.nextInt();

            if (choice==1){
                sandwichScreen();
            } else if (choice==2) {
                drinkScreen();
            } else if (choice==3) {
                chipScreen();
            } else if (choice==4) {
                checkoutScreen();
            } else if (choice==0) {
                homeScreen();
            } else {
                System.out.println("Input out of range");
                orderScreen();
            }
        } catch (InputMismatchException e) {
            System.out.println("\nERROR: input must be a number\n");
            scanner.nextLine();
            orderScreen();
        }
    }

    private void sandwichScreen() {
        scanner.nextLine();
        System.out.println("---------------------------");
        System.out.println("Select a sandwich size");
        String size = sizeSelect();

        System.out.println("---------------------------");
        System.out.println("Select a bread");
        String bread = breadSelect();

        System.out.println("---------------------------");
        System.out.println("Select a meat");
        String meat = meatSelect();
        boolean extraMeat = extraTopping(meat);

        System.out.println("---------------------------");
        System.out.println("Select a cheese");
        String cheese = cheeseSelect();
        boolean extraCheese = extraTopping(cheese);

        // Add toppings and sauces
        System.out.println("---------------------------");
        System.out.println("Select toppings");
        ArrayList<String> toppings = toppingsSelect();

        System.out.println("---------------------------");
        System.out.println("Select sauces");
        

        //order.getSandwiches().add();
        //orderScreen();
    }

    private ArrayList<String> toppingsSelect() {
        ArrayList<String> toppings = new ArrayList<>();
        System.out.println("""
                1) Lettuce
                2) Peppers
                3) Onions
                4) Tomatoes
                5) Jalapenos
                6) Cucumbers
                7) Pickles
                8) Guacamole
                9) Mushrooms
                0) None
                """);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                toppings.add("Lettuce");
                if (extraTopping("Lettuce")){
                    toppings.add("Extra Lettuce");
                }
                break;
            case 2:
                toppings.add("Peppers");
                if (extraTopping("Peppers")){
                    toppings.add("Extra Peppers");
                }
                break;
            case 3:
                toppings.add("Onions");
                if (extraTopping("Onions")){
                    toppings.add("Extra Onions");
                }
                break;
            case 4:
                toppings.add("Tomatoes");
                if (extraTopping("Tomatoes")){
                    toppings.add("Extra Tomatoes");
                }
                break;
            case 5:
                toppings.add("Jalapenos");
                if (extraTopping("Jalapenos")){
                    toppings.add("Extra Jalapenos");
                }
                break;
            case 6:
                toppings.add("Cucumbers");
                if (extraTopping("Cucumbers")){
                    toppings.add("Extra Cucumbers");
                }
                break;
            case 7:
                toppings.add("Pickles");
                if(extraTopping("Pickles")){
                    toppings.add("Extra Pickles");
                }
                break;
            case 8:
                toppings.add("Guacamole");
                if (extraTopping("Guacamole")){
                    toppings.add("Extra Guacamole");
                }
            case 9:
                toppings.add("Mushrooms");
                if (extraTopping("Mushrooms")){
                    toppings.add("Extra Mushrooms");
                }
            case 0:
                break;
            default:
                System.out.println("Not an available option");
                toppingsSelect();
        }

        System.out.println("""
                1) Add another topping
                2) Done
                """);
        choice = scanner.nextInt();
        if (choice==1){
            toppingsSelect();
        } else if (choice==2){
            return toppings;
        } else {
            System.out.println("index out of range");
        }
        return toppings;
    }

    private boolean extraTopping(String topping) {
        if (!topping.isEmpty()) {
            System.out.printf("Would you like extra %s? (Y/N)\n", topping);
            scanner.nextLine();
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")){
                return true;
            }
        }
        return false;
    }

    // Select a cheese option
    private String cheeseSelect() {
        System.out.println("""
                1) American
                2) Provolone
                3) Cheddar
                4) Swiss
                0) None
                """);
        int choice = scanner.nextInt();

        String cheese = "";
        switch (choice) {
            case 1:
                cheese="American";
                break;
            case 2:
                cheese="Provolone";
                break;
            case 3:
                cheese="Cheddar";
                break;
            case 4:
                cheese="Swiss";
                break;
            case 0:
                break;
            default:
                System.out.println("Not an available option");
                cheeseSelect();
        }
        return cheese;
    }

    // Select a meat option
    private String meatSelect() {
        System.out.println("""
                1) Steak
                2) Ham
                3) Salami
                4) Roast Beef
                5) Chicken
                6) Bacon
                0) None
                """);
        int choice = scanner.nextInt();

        String meat = "";
        switch (choice) {
            case 1:
                meat="Steak";
                break;
            case 2:
                meat="Ham";
                break;
            case 3:
                meat="Salami";
                break;
            case 4:
                meat="Roast Beef";
                break;
            case 5:
                meat="Chicken";
                break;
            case 6:
                meat="Bacon";
                break;
            case 0:
                break;
            default:
                System.out.println("Not an available option");
                meatSelect();
        }
        return meat;
    }

    // Select a bread option
    private String breadSelect(){
        System.out.println("""
                1) White
                2) Wheat
                3) Rye
                4) Wrap
                """);
        int choice = scanner.nextInt();

        String bread = "";
        switch (choice){
            case 1:
                bread = "White";
                break;
            case 2:
                bread = "Wheat";
                break;
            case 3:
                bread = "Rye";
                break;
            case 4:
                bread = "Wrap";
                break;
            default:
                System.out.println("Not an available option");
                breadSelect();
        }
        return bread;
    }

    private String sizeSelect() {
        System.out.println("""
                1) Small (4\")
                2) Medium (8\")
                3) Large (12\")
                """);

        int choice = scanner.nextInt();

        String size = "";
        switch (choice) {
            case 1:
                size = "s";
                break;
            case 2:
                size = "m";
                break;
            case 3:
                size = "l";
                break;
            default:
                System.out.println("Not an available option");
                sizeSelect();
        }
        return size;
    }

    private void drinkScreen(){
        //order.getDrinks().add();
    }

    private void chipScreen() {
        //order.getChips().add();
    }

    private void checkoutScreen() {

    }
}
