package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

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
        System.out.println("Choose a bread");
        //order.getSandwiches().add();
        //orderScreen();
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
