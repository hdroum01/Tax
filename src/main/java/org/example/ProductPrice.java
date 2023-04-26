package org.example;

public class ProductPrice {
    public final double value;

    ProductPrice(double value){
        String valueString = Double.toString(value);
        if(valueString.indexOf(".") < valueString.length() - 3) {
            throw new IllegalArgumentException("Too many decimal places");
        } else if (value > 1000.) {
            throw new IllegalArgumentException("Price is over 1000");
        } else if (value < .1) {
            throw new IllegalArgumentException("Price is under 10 cents");
        }
        this.value = value;
    }

    public double taxTotal(boolean imported, ProductCategory category) {
        double taxes = imported ? .05 : 0;
        taxes += category.getVATRate();
        taxes *= value * 100;
        taxes = 5*Math.ceil(Math.abs(taxes / 5));
        taxes /= 100;
        return taxes;
    }

}
