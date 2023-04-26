package org.example;

public enum ProductCategory {
    Book{
        public double getVATRate() {return 0;}
    }, Medication{
        public double getVATRate() {return 0;}
    }, Food{
        public double getVATRate() {return 0;}
    }, Other;
        public double getVATRate() {return 0.1;};
}
