package org.example;
import java.util.*;

public class Driver {
    Backend backend;
    Frontend frontend;
    Scanner sc;
    String input;

    public void runProgram(){
        backend = new Backend();
        frontend = new Frontend();
        sc = new Scanner(System.in);
        backend.loadCSV("src/main/resources/database.csv", true);
        backend.displayItems();

        while(true) {
            frontend.displayMenu();
            input = sc.nextLine().strip();
            if(input.equals("1")) {
                frontend.addInventory();
                input = sc.nextLine().strip();
                if(input.equals("Y")) {
                    String[] item = new String[6];
                    System.out.println("What is the name of your item?");
                    item[0] = sc.nextLine().strip();
                    System.out.println("How many of the item do you have?");
                    item[1] = sc.nextLine().strip();
                    System.out.println("What is the price of your item?");
                    item[2] = sc.nextLine().strip();
                    System.out.println("What is the category of your item?");
                    item[3] = sc.nextLine().strip();
                    System.out.println("Is your item imported? (Y/N)");
                    item[4] = sc.nextLine().strip().equals("Y") ? "true" : "false";
                    backend.individualAdd(item);
                } else if (input.equals("N")) {
                    System.out.println("What is the pathname for your csv:");
                    input = sc.nextLine().strip();
                    backend.loadCSV(input, true);
                }
            } else if(input.equals("2")) {
                frontend.sellItems();
                backend.printSales();
            } else if(input.equals("3")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("You did not input a valid response, please try again.");
            }
        }
    }
}
