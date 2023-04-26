package org.example;
import java.util.LinkedHashMap;

public class Receipt {
    LinkedHashMap<String, Double> soldItems = new LinkedHashMap<String, Double>();
    double taxTotal;
    double receiptTotal;

    public void printReceipt() {
        soldItems.forEach((k, v) -> System.out.printf("1 " + k + " : %.2f" + "\n", v));
        System.out.printf("Tax total: %.2f \n", taxTotal);
        System.out.printf("Total: %.2f \n", receiptTotal);
    }

    public void addItem(Product product) {
        double taxValue = product.price.taxTotal(product.imported, product.productCategory);
        soldItems.put(product.name.name, taxValue + product.price.value);
        taxTotal += taxValue;
        receiptTotal += taxValue + product.price.value;
    }
}
