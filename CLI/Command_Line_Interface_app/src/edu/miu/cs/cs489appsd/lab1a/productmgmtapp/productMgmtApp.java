package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import java.util.Arrays;
import java.util.Comparator;

public class productMgmtApp {

    public static void main(String[] args) {
        Product[] products = {
                new Product(3128874119L, "Banana", "2023-01-24", 124, 0.55),
                new Product(2927458265L, "Apple", "2022-12-09", 18, 1.09),
                new Product(9189927460L, "Carrot", "2023-03-31", 89, 2.99)
        };

        Arrays.sort(products, Comparator.comparing(Product::getName));
        printProductsInJson(products);
        printProductsInXml(products);
        printProductsInCsv(products);
    }

    private static void printProductsInJson(Product[] products) {
        System.out.println("Printed in JSON Format");
        System.out.print("[\n");
        for (Product product : products) {
            System.out.printf("  { \"productId\": \"%d\", \"name\": \"%s\", \"dateSupplied\": \"%s\", \"quantityInStock\": %d, \"unitPrice\": %.2f },\n",
                    product.getProductId(), product.getName(), product.getDateSupplied(), product.getQuantityInStock(), product.getUnitPrice());
        }
        System.out.println("]\n----------------------------------");
    }

    private static void printProductsInXml(Product[] products) {
        System.out.println("Printed in XML Format");
        System.out.println("<xml version=\"1.0\"?>");
        System.out.println("<products>");
        for (Product product : products) {
            System.out.printf("  <product productId=\"%d\" name=\"%s\" dateSupplied=\"%s\" quantityInStock=\"%d\" unitPrice=\"%.2f\"/>\n",
                    product.getProductId(), product.getName(), product.getDateSupplied(), product.getQuantityInStock(), product.getUnitPrice());
        }
        System.out.println("</products>\n----------------------------------");
    }

    private static void printProductsInCsv(Product[] products) {
        System.out.println("Printed in Comma-Separated Value(CSV) Format");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("----------------------------------");
    }
}
