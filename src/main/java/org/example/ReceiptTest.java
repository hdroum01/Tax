package org.example;

public class ReceiptTest {

    public static void test1() {
        Receipt receipt1 = new Receipt();
        receipt1.addItem(new Product(new ProductName("Book"), ProductCategory.Book, new ProductPrice(12.49), false));
        receipt1.addItem(new Product(new ProductName("Music CD"), ProductCategory.Other, new ProductPrice(14.99), false));
        receipt1.addItem(new Product(new ProductName("Chocolate Bar"), ProductCategory.Food, new ProductPrice(0.85), false));
        receipt1.printReceipt();
    }

    public static void test2() {
        Receipt receipt2 = new Receipt();
        receipt2.addItem(new Product(new ProductName("Chocolate Bar"), ProductCategory.Food, new ProductPrice(10.00), true));
        receipt2.addItem(new Product(new ProductName("Perfume"), ProductCategory.Other, new ProductPrice(47.50), true));
        receipt2.printReceipt();
    }

    public static void test3() {
        Receipt receipt3 = new Receipt();
        receipt3.addItem(new Product(new ProductName("Perfume"), ProductCategory.Other, new ProductPrice(27.99), true));
        receipt3.addItem(new Product(new ProductName("Perfume"), ProductCategory.Other, new ProductPrice(18.99), false));
        receipt3.addItem(new Product(new ProductName("Advil"), ProductCategory.Medication, new ProductPrice(9.75), false));
        receipt3.addItem(new Product(new ProductName("Chocolate Bar"), ProductCategory.Food, new ProductPrice(11.25), true));
        receipt3.printReceipt();
    }
}
