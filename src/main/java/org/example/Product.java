package org.example;
import java.util.Arrays;

public class Product {
    private final String name, category;
    private double price, taxes;
    private int quantity;
    private final boolean imported;
    private final String[] taxFreeCategories = new String[]{"Books", "Medication", "Food"};

    Product(String name, String category, double price, int quantity, boolean imported) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.imported = imported;
        taxes = imported ? .05 : 0;
        taxes += Arrays.stream(taxFreeCategories).anyMatch(category::equals) ? 0 : .1;
        taxes *= price * 100;
        taxes = 5*Math.ceil(Math.abs(taxes / 5));
        taxes /= 100;

    }

    public void changeQuantity(int sellQuantity) {
        quantity -= sellQuantity;
    }

    public String returnName() {
        return name;
    }
    public double returnPrice() {
        return price;
    }

    public double returnTaxes() {
        return taxes;
    }

    public int returnQuantity() {
        return quantity;
    }

}
