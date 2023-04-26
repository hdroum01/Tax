package org.example;

public class Product {
    public final ProductName name;
    public final Price price;
    public final boolean imported;
    public final ProductCategory productCategory;

    Product(ProductName name, ProductCategory productCategory, Price price, boolean imported) {
        this.name = name;
        this.productCategory = productCategory;
        this.price = price;
        this.imported = imported;
    }
}
