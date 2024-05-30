package com.pluralsight;

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
                2) Signature Sandwiches
                3) Add Drink
                4) Add Chips
                5) Checkout
                0) Cancel Order""");

        try{
            int choice = scanner.nextInt();

            if (choice==1){
                sandwichScreen();
            } else if (choice==2) {
                sigSandwichScreen();
            } else if (choice==3) {
                drinkScreen();
            } else if (choice==4) {
                chipScreen();
            } else if (choice==5) {
                checkoutScreen();
            } else if (choice==0) {
                // Delete the order
                cancelOrder();
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

    private void sigSandwichScreen() {
        System.out.println("---------------------------");
        System.out.println("Select a signature sandwich");

        System.out.println("""
                1) BLT
                2) Philly Cheese Stake
                0) Back
                """);

        int choice = scanner.nextInt();

        if (choice==1){
            BLT blt = new BLT();
            customize(blt);
        } else if (choice==2) {
            PhillyCheeseSteak philly = new PhillyCheeseSteak();
            customize(philly);
        } else if (choice==0) {
            orderScreen();
        } else {
            System.out.println("Input out of range");
            sigSandwichScreen();
        }
    }

    private void customize(Sandwich sigSammy) {
        System.out.printf("""
                size        %s
                bread       %s
                meat        %s\n---- extra meat - %b
                cheese      %s\n---- extra cheese - %b
                toppings    %s
                sauces      %s
                
                1) Add toppings
                2) Remove toppings
                """,sigSammy.getSize(),sigSammy.getBread(),sigSammy.getMeat(), sigSammy.isExtraMeat(),
                 sigSammy.getCheese(),sigSammy.isExtraCheese(),sigSammy.getToppings(),sigSammy.getSauces());

        if (!sigSammy.isExtraMeat()) {
            System.out.println("3) Add extra meat");
        } else {
            System.out.println("3) Remove extra meat");
        }
        if (!sigSammy.isExtraCheese()) {
            System.out.println("4) Add extra cheese");
        } else {
            System.out.println("4) Remove extra cheese");
        }

        System.out.println("0) Complete customization");

        int choice = scanner.nextInt();

        if (choice==1){
            toppingsSelect(sigSammy.getToppings());
            //customize(sigSammy);
        } else if (choice==2) {
            removeToppings(sigSammy.getToppings());
            //customize(sigSammy);
        } else if (choice==3) {
            if (sigSammy.isExtraMeat()){
                sigSammy.setExtraMeat(false);
            } else {
                sigSammy.setExtraMeat(true);
            }
        } else if (choice==4) {
            if (sigSammy.isExtraCheese()){
                sigSammy.setExtraCheese(false);
            } else {
                sigSammy.setExtraCheese(true);
            }
        } else if (choice==0) {
            order.getSandwiches().add(sigSammy);
            orderScreen();
        } else {
            System.out.println("Input out of range");
        }
        customize(sigSammy);
    }

    private void removeToppings(ArrayList<String> toppings){
        for (int i = 0; i < toppings.size(); i++){
            System.out.printf("%d) %s\n",i+1, toppings.get(i));
        }
        System.out.println("Select topping to remove");

        int choice = scanner.nextInt();
        toppings.remove(toppings.get(choice-1));
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
        boolean extraMeat = false;
        if (!meat.equalsIgnoreCase("none")){
            extraMeat=extraTopping(meat);
        }

        System.out.println("---------------------------");
        System.out.println("Select a cheese");
        String cheese = cheeseSelect();
        boolean extraCheese = false;
        if (!cheese.equalsIgnoreCase("none")) {
            extraCheese = extraTopping(cheese);
        }


        // Add toppings and sauces
        System.out.println("---------------------------");
        System.out.println("Select toppings");
        ArrayList<String> toppings = new ArrayList<>();
        toppingsSelect(toppings);

        System.out.println("---------------------------");
        System.out.println("Select sauces");
        ArrayList<String> sauces = new ArrayList<>();
        saucesSelect(sauces);

        System.out.println("---------------------------");
        System.out.println("Would you like your sandwich toasted?\n1) Yes\n2) No");

        int toasted = scanner.nextInt();

        boolean isToasted = false;
        if (toasted==1) {
            isToasted = true;
        }

        // Create the sandwich and add it to the order
        Sandwich sandwich = new Sandwich(size, meat, cheese, extraMeat, extraCheese,bread,isToasted);
        sandwich.setSauces(sauces);
        sandwich.setToppings(toppings);
        order.getSandwiches().add(sandwich);
        // Send the user back to the order screen
        orderScreen();
    }

    private void saucesSelect(ArrayList<String> sauces) {
        System.out.println("""
                1) Mayo
                2) Mustard
                3) Ketchup
                4) Ranch
                5) Thousand Island
                6) Vinaigrette
                0) None
                """);
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                sauces.add("Mayo");
                break;
            case 2:
                sauces.add("Mustard");
                break;
            case 3:
                sauces.add("Ketchup");
                break;
            case 4:
                sauces.add("Ranch");
                break;
            case 5:
                sauces.add("Thousand Island");
                break;
            case 6:
                sauces.add("Vinaigrette");
                break;
            case 0:
                sauces.add("None");
                break;
            default:
                System.out.println("Not an available option");
                saucesSelect(sauces);
                break;
        }
        if (choice!=0){
            System.out.println("""
                1) Add another
                2) Done
                """);
            choice = scanner.nextInt();
            if (choice==1){
                saucesSelect(sauces);
            }
        }
    }

    private void toppingsSelect(ArrayList<String> toppings) {
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
                break;
            case 2:
                toppings.add("Peppers");
                break;
            case 3:
                toppings.add("Onions");
                break;
            case 4:
                toppings.add("Tomatoes");
                break;
            case 5:
                toppings.add("Jalapenos");
                break;
            case 6:
                toppings.add("Cucumbers");
                break;
            case 7:
                toppings.add("Pickles");
                break;
            case 8:
                toppings.add("Guacamole");
                break;
            case 9:
                toppings.add("Mushrooms");
                break;
            case 0:
                toppings.add("None");
                break;
            default:
                System.out.println("Not an available option");
                toppingsSelect(toppings);
                break;
        }

        if (choice!=0){
            System.out.println("""
                1) Add another topping
                2) Done
                """);
            choice = scanner.nextInt();
            if (choice==1){
                toppingsSelect(toppings);
            } else if (choice==2) {
                System.out.println("Toppings saved");
            } else {
                System.out.println("Input out of range");
            }
        }
    }

    private boolean extraTopping(String topping) {
        if (!topping.isEmpty()) {
            System.out.println("Add extra?\n1) Yes\n2) No\n");

            int choice = scanner.nextInt();
            if (choice==1){
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
                cheese="None";
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
                meat="None";
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
                1) 4"
                2) 8"
                3) 12"
                """);

        int choice = scanner.nextInt();

        String size = "";
        switch (choice) {
            case 1:
                size = "4\"";
                break;
            case 2:
                size = "8\"";
                break;
            case 3:
                size = "12\"";
                break;
            default:
                System.out.println("Not an available option");
                sizeSelect();
                break;
        }
        return size;
    }

    private void drinkScreen(){
        System.out.println("---------------------------");
        System.out.println("Select a drink size");
        String size = drinkSize();

        System.out.println("---------------------------");
        System.out.println("Select a drink flavor");
        String flavor = drinkFlavor();

        Drink drink = new Drink(size,flavor);
        order.getDrinks().add(drink);
        orderScreen();
    }

    private String drinkFlavor() {
        String flavor = "";
        System.out.println("""
                1) Coke
                2) Iced Tea
                3) Iced Tea - Unsweetened
                4) Lemonade
                """);

        int choice = scanner.nextInt();
        if (choice==1){
            flavor="Coke";
        } else if (choice==2) {
            flavor="Iced Tea";
        } else if (choice==3) {
            flavor="Iced Tea - Unsweetened";
        } else if (choice==4) {
            flavor="Lemonade";
        } else {
            System.out.println("Not an available option");
            drinkFlavor();
        }
        return flavor;
    }

    private String drinkSize() {
        String size= "";
        System.out.println("""
                1) Small
                2) Medium
                3) Large
                """);

        int choice = scanner.nextInt();
        if (choice==1){
            size="Small";
        } else if (choice==2) {
            size="Medium";
        } else if (choice==3) {
            size="Large";
        } else {
            System.out.println("Not an available option");
            drinkSize();
        }
        return size;
    }

    private void chipScreen() {
        String type = "";
        System.out.println("---------------------------");
        System.out.println("Select a chip type");
        System.out.println("""
                1) Original
                2) Nacho Cheese
                3) Cool Ranch
                4) Sour Cream & Onion
                5) Salt & Vinegar
                """);

        int choice = scanner.nextInt();
        if (choice == 1) {
            type = "Original";
        } else if (choice==2) {
            type="Nacho Cheese";
        } else if (choice==3) {
            type="Cool Ranch";
        } else if (choice==4) {
            type="Sour Cream & Onion";
        } else if (choice==5) {
            type="Salt & Vinegar";
        } else {
            System.out.println("Not an available option");
            chipScreen();
        }

        Chip chip = new Chip(type);
        order.getChips().add(chip);
        orderScreen();
    }

    private void checkoutScreen() {
        System.out.println("---------------------------");
        System.out.println("----Order details----");

        // Print order
        if (!order.getSandwiches().isEmpty()){
            System.out.println("----Sandwiches----");
            displayOrder(order.getSandwiches());
        }

        if (!order.getDrinks().isEmpty()){
            System.out.println("----Drinks----");
            displayOrder(order.getDrinks());
        }

        if (!order.getChips().isEmpty()){
            System.out.println("----Chips----");
            displayOrder(order.getChips());
        }

        // Print out the total of the order
        System.out.println("---------------------------");
        System.out.printf("Order total : $%.2f\n\n", order.getTotal());

        System.out.println("""
                1) Confirm
                2) Cancel
                """);
        int choice = scanner.nextInt();
        if (choice==1){
            // Save receipt to file
            ReceiptFileManager receiptFileManager = new ReceiptFileManager(order);
            receiptFileManager.saveReceipt();
            cancelOrder();
        } else if (choice==2){
            cancelOrder();
        }
    }

    private <T> void displayOrder(ArrayList<T> items){
        for (T item : items){
            System.out.println(item);
        }
    }

    private void cancelOrder() {
        order.getSandwiches().clear();
        order.getChips().clear();
        order.getDrinks().clear();
        homeScreen();
    }
}
