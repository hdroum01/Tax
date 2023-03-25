package org.example;
import com.opencsv.*;
import java.io.*;
import java.util.*;
import java.lang.reflect.Array;

public class Backend {

    private List<String> exemptCategories = new ArrayList<>(List.of("Books", "Food", "Medication"));
    private List<Object[]> data = new ArrayList<Object[]>();
    private List<String> itemNames = new ArrayList<String>();
    private Hashtable<String, Integer[]> soldItems = new Hashtable<String, Integer[]>();
    public void loadCSV (String pathname, boolean header) {
        try {
            FileReader fileReader = new FileReader(pathname);
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(header ? 1 : 0).build();
            Object[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                String name = (String) Array.get(nextRecord, 0);
                String category = (String) Array.get(nextRecord, 3);
                boolean imported = Boolean.parseBoolean((String) Array.get(nextRecord, 4));
                int price = (int) (Double.parseDouble((String) Array.get(nextRecord, 2)) * 100);
                double taxRate = exemptCategories.contains(category) ? 0 : .1;
                taxRate += imported ? .05 : 0;
                int taxTotal = (int) (price * taxRate);
                if(taxTotal % 5 != 0) {
                    taxTotal += 5 - (taxTotal % 5);
                }
                data.add(new Object[] {name, Integer.parseInt((String) Array.get(nextRecord, 1)), price, category, imported, taxTotal});
                itemNames.add(name);
            }
            fileReader.close();
            csvReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void individualAdd(String[] item) {
        String name = (String) Array.get(item, 0);
        String category = (String) Array.get(item, 3);
        boolean imported = (boolean) Array.get(item, 4);
        int price = (int) ((double) Array.get(item, 2) * 100);
        double taxRate = exemptCategories.contains(category) ? 0 : .1;
        taxRate += imported ? .05 : 0;
        int taxTotal = (int) (price * taxRate);
        if(taxTotal % 5 != 0) {
            taxTotal += 5 - (taxTotal % 5);
        }
        data.add(new Object[] {name, (int) Array.get(item, 1), price, category, imported, taxTotal});
        itemNames.add(name);
    }

    public void displayItems() {
        System.out.println("Your items in stock are: ");
        for (String item : itemNames) {
            System.out.print(item + "\t");
        }
    }

    public void printSales() {
        displayItems();
        Scanner sc = new Scanner(System.in);
        String input = "";
        int quantity = 0;
        while(!input.equals("exit")){
            System.out.println("Please select the items you would like to sell by typing the full name of the item.");
            System.out.println("Type 'exit' if you are done");
            input = sc.nextLine().strip();
            System.out.println("input");
            try {
                int index = itemNames.indexOf(input);
                Object[] item = data.get(index);
                System.out.println("How many of this item are you selling?");
                quantity = Integer.parseInt(sc.nextLine());
                if ((int) item[1] >= quantity) {
                    soldItems.put((String) item[0], new Integer[]{(Integer) item[2], (Integer) quantity, (Integer) item[5]});
                    item[1] = (int) item[1] - quantity;
                } else{
                    System.out.println("You do not have enough of this item to sell");
                }
            } catch (Exception e) {
                System.out.println("This is not a valid item, please try again");
            }
        }

        System.out.println("Sold Items:");

        Double taxTotal = 0.;
        Double finalPrice = 0.;
        for (String item : soldItems.keySet()) {
            Double itemPrice = (double) (soldItems.get(item)[0] * soldItems.get(item)[1]);
            System.out.println(soldItems.get(item)[1] + " " + item + ": " + String.format("%.2f",itemPrice / 100));
            taxTotal += soldItems.get(item)[2];
            finalPrice += itemPrice + soldItems.get(item)[2];
        }
        System.out.println("Tax total: " + String.format("%.2f",taxTotal / 100));
        System.out.println("Total: " + String.format("%.2f",finalPrice / 100));


        soldItems.clear();
    }
}
