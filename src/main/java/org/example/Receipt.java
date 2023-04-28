package org.example;

public class Receipt {
    SoldItems soldItems = new SoldItems();
    double taxTotal;
    double receiptTotal;

    public void printReceipt() {
        soldItems.printItems();
        System.out.printf("Tax total: %.2f \n", taxTotal);
        System.out.printf("Total: %.2f \n", receiptTotal);
    }

    public void addItem(Product product) {
        double taxValue = product.price.taxTotal(product.imported, product.productCategory);
        soldItems.insert(product);
        taxTotal += taxValue;
        receiptTotal += taxValue + product.price.value;
    }
}
