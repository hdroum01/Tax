package org.example;

public class SoldItems {

    Node head;

    static class Node {
        String name;
        double price;
        Node next;

        Node(Product product) {
            this.name = (product.imported ? "Imported " : "") + product.name.name;
            this.price = product.price.value + product.price.taxTotal(product.imported, product.productCategory);
        }
    }
    public void insert(Product product) {
        Node new_node = new Node(product);

        if(head == null) {
            head = new_node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
    }

    public void printItems() {
        Node currNode = head;

        while (currNode != null) {
            System.out.printf("1 " + currNode.name + ": %.2f \n", currNode.price);
            currNode = currNode.next;
        }
    }
}
