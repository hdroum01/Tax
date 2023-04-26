package org.example;

public class ReceiptTest {

    public static void test1() {
        Receipt receipt1 = new Receipt();
        receipt1.addItem(new Product(new ProductName("Book"), ProductCategory.Book, new Price(12.49), false));
        receipt1.addItem(new Product(new ProductName("Music CD"), ProductCategory.Other, new Price(14.99), false));
        receipt1.addItem(new Product(new ProductName("Chocolate Bar"), ProductCategory.Food, new Price(0.85), false));
        receipt1.printReceipt();
    }

//    public static void test2() {
//        Receipt receipt2 = new Receipt();
//        receipt2.addItem(new Product("Chocolate Bar", "Food", 10.00, 1, true));
//        receipt2.addItem(new Product("Perfume", "Other", 47.50, 4, true));
//        receipt2.printReceipt();
//    }
//
//    public static void test3() {
//        Receipt receipt3 = new Receipt();
//        receipt3.addItem(new Product("Perfume", "Other", 27.99, 1, true));
//        receipt3.addItem(new Product("Perfume", "Other", 18.99, 1, false));
//        receipt3.addItem(new Product("Advil", "Medication", 9.75, 1, false));
//        receipt3.addItem(new Product("Chocolate Bar", "Food", 11.25, 2, true));
//        receipt3.printReceipt();
//    }
}
