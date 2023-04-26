package org.example;
import java.util.Arrays;
import java.util.List;

public class ProductName {
    public final String name;
    public static final List<String> catalog = Arrays.asList("Book", "Music CD", "Chocolate Bar", "Perfume", "Advil");
    ProductName(String name) {
        if(!catalog.contains(name)) {
            throw new IllegalArgumentException("Name not in catalog");
        }
        this.name = name;
    }
}