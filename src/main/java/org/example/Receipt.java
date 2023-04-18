package org.example;
import java.util.HashMap;

public class Receipt {
    HashMap<String, Double[]> soldItems = new HashMap<String, Double[]>();
    double taxTotal;
    double receiptTotal;

    public void printReceipt() {
        soldItems.forEach((k, v) -> System.out.printf(v[1].intValue() + " " + k + " : %.2f" + "\n", v[0]));
        System.out.printf("Tax total: %.2f \n", taxTotal);
        System.out.printf("Total: %.2f \n", receiptTotal);
    }

    public void addItem(Product product, int sellQuantity) {
        if(product.returnQuantity() < sellQuantity) {
            System.out.println("You only have " + product.returnQuantity() + " of this item, you cannot sell " + sellQuantity + "of this item");
        } else {
            product.changeQuantity(sellQuantity);
            soldItems.put(product.returnName(), new Double[] {sellQuantity * (product.returnPrice() + product.returnTaxes()), (double)sellQuantity});
            taxTotal += sellQuantity * product.returnTaxes();
            receiptTotal += sellQuantity * (product.returnPrice() + product.returnTaxes());
        }
    }
}
