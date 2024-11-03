package com.core.entities.order.model;

import com.core.checks.Check;
import com.core.entities.exceptions.BuildException;

public class OrderDetails {

    protected String idOrderDetails;
    protected int amount;
    protected String ref;
    protected String description;
    protected double discount;
    protected double subtotal;

    // constructor vacio
    protected OrderDetails() {
    }

    
    public static OrderDetails getInstance(String idOrderDetails, int amount, String ref, String description, double discount, double subtotal) throws BuildException { 
        

        OrderDetails od = new OrderDetails();
        StringBuilder errors = new StringBuilder();
        int errorCode;

        if((errorCode=od.setIdOrderDetails(idOrderDetails))!=0){
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        if((errorCode=od.setAmount(amount))!=0){
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        
        if((errorCode=od.setRef(ref))!=0){
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        
        if((errorCode=od.setDescription(description))!=0){
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        
        if((errorCode=od.setDiscount(discount))!=0){
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        
        if((errorCode=od.setSubtotal(subtotal))!=0){
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        
        if(errors.length() > 0) {
            throw new BuildException(errors.toString());
        }
        return od;
    }


    
    // getters
    public String getIdOrderDetails() {
        return idOrderDetails;
    }

    public int getAmount() {
        return amount;
    }

    public String getRef() {
        return ref;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscount() {
        return discount;
    }

    public double getSubtotal() {
        return subtotal;
    }








    
    
    // setters
    public int setIdOrderDetails(String idOrderDetails) {
        int errorIdOrderDetails = Check.(idOrderDetails);
        //aqui tendre que comprobar si el id ya existe con un getOrderId o algo y comprarlo si 
        this.idOrderDetails = idOrderDetails;
    }

    public int setAmount(int amount) {
        this.amount = amount;
    }

    public int setRef(String ref) {
        this.ref = ref;
    }

    public int setDescription(String description) {
        this.description = description;
    }

    public int setDiscount(double discount) {
        this.discount = discount;
    }

    public int setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    







    
