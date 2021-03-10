package com.example.demo.Model;

public class Product {
    private long productID;
    private String productName;
    private double productPrice;

    public Product(long productID, String productName, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Product(){

    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productID +
                ", name='" + productName + '\'' +
                ", price=" + productPrice +
                '}';
    }
}
