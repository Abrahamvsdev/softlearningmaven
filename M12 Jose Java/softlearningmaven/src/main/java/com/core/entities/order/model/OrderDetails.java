package com.core.entities.order.model;

public class OrderDetails {

    protected String idOrderDetails;
    protected double amount;
    protected String ref;
    protected String description;
    protected double discount;
    protected double subtotal;

    // Constructor vacío
    protected OrderDetails() {
    }

    // Constructor parametrizado
    public OrderDetails(String idOrderDetails, double amount, String ref, String description, double discount, double subtotal) {
        
    }

    // getters
    public String getIdOrderDetails() {
        return idOrderDetails;
    }

    public void setIdOrderDetails(String idOrderDetails) {
        this.idOrderDetails = idOrderDetails;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRef() {
        return ref;
    }






    // setters
    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}