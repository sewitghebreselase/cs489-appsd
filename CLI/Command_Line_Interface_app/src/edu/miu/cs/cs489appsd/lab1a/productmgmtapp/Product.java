
package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;


class Product {
    private long productId;
    private String name;
    private String dateSupplied;
    private int quantityInStock;
    private double unitPrice;

    public Product(long productId, String name, String dateSupplied, int quantityInStock, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    // Getters for the properties
    public long getProductId() { return productId; }
    public String getName() { return name; }
    public String getDateSupplied() { return dateSupplied; }
    public int getQuantityInStock() { return quantityInStock; }
    public double getUnitPrice() { return unitPrice; }

    // This method will be used for CSV output
    @Override
    public String toString() {
        return productId + ", " + name + ", " + dateSupplied + ", " + quantityInStock + ", " + unitPrice;
    }
}


