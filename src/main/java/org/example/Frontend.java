package org.example;
import java.util.*;

public class Frontend {
    private boolean validate(List<String> args, String input) { return args.contains(input) ? true : false; }

    public void displayMenu() {
        System.out.println("Here are the available actions:");
        System.out.println("1. Add Inventory");
        System.out.println("2. Sell Items");
        System.out.println("3. Exit Software");
        System.out.println("Please enter a number to select your action: ");
    }

    public void addInventory() {
        System.out.println("You have selected to add to your stock.");
        System.out.println("Will you be using a csv to make these updates (Y/N):");
    }

    public void updateChoice() {
        System.out.println("Would you like to use a csv for your updates (Y/N):");
    }

    public void restockItems() {
        System.out.println("");
    }

    public void sellItems() {
        System.out.println("Please insert which items are being sold, with each item seperated by a comma: ");
    }
}
