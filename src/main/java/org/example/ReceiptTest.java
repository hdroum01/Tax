package org.example;

public class ReceiptTest {

    public static void test1() {
        Receipt receipt1 = new Receipt();
        receipt1.addItem(new Product("Harry Potter", "Books", 12.49, 2, false), 1);
        receipt1.addItem(new Product("RED Album", "Music CD", 14.99, 1, false), 1);
        receipt1.addItem(new Product("Dark Chocolate", "Food", 0.85, 1, false), 1);
        receipt1.printReceipt();
    }

    public static void test2() {
        Receipt receipt2 = new Receipt();
        receipt2.addItem(new Product("Dark Chocolate", "Food", 10.00, 1, true), 1);
        receipt2.addItem(new Product("Eau de Parfum", "Perfume", 47.50, 4, true), 1);
        receipt2.printReceipt();
    }

    public static void test3() {
        Receipt receipt3 = new Receipt();
        receipt3.addItem(new Product("Eau de Parfum", "Perfume", 27.99, 1, true), 1);
        receipt3.addItem(new Product("Dior Sauvage", "Perfume", 18.99, 1, false), 1);
        receipt3.addItem(new Product("Advil", "Medication", 9.75, 1, false), 1);
        receipt3.addItem(new Product("Dark Chocolate", "Food", 11.25, 2, true), 2);
        receipt3.printReceipt();
    }
}
