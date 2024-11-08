package com.core.entities.order.model;

import com.core.checks.Check;
import com.core.entities.exceptions.BuildException;
import com.core.entities.shared.dimensions.Dimensions;
import com.core.entities.shared.operations.Operation;


public class OrderDetails {

    
    protected int amount;
    protected String detailRef;
    protected double price;
    protected double discount;


    protected double subtotal;

    // constructor vacio voy a porbar a comentarlo parece que no hace falta
    protected OrderDetails() {
    }

    //string ref, int amount, double price, double discount, asi los tiene jose

    public static OrderDetails getInstance( int amount, String detailRef,double price, double discount) throws BuildException { 
        

        OrderDetails od = new OrderDetails();
        StringBuilder errors = new StringBuilder();
        int errorCode;

        

        if((errorCode=od.setAmount(amount))!=0){
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        
        if((errorCode=od.setDetailRef(detailRef))!=0){
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        
        if((errorCode=od.setPrice(price))!=0){
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        
        if((errorCode=od.setDiscount(discount))!=0){
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        
        
        
        if(errors.length() > 0) {
            throw new BuildException(errors.toString());
        }
        return od;
    }


    
    // getters
    

    public int getAmount() {
        int errorAmount = Check.range(amount);
        if(errorAmount!=0){
            return -20;
        }
        return amount;
    }

    public int getDetailRef()throws BuildException{
        try {
            errorDetailRef= Check.minMaxLength(detailRef)
            if(errorDetailRef==0){
                return 0;
            }
        } catch (Exception e) {
            if(errorCode!=0){
                throw new BuildException 
            }
        } finally {
            if(errorDetailRef==0)
        }
    }
//retornaur un 21
    }

    public double getPrice(){
        return price;
    }

    public double getDiscount() {
        return discount;
    }









    
    
    // setters

    public int setAmount(int amount) {
        if()
        this.amount = amount;
    }

    public int setDetailRef(String detailRef) {
        this.detailRef = detailRef;
    }

    public int setPrice(double price) {
        this.price = price;
    }

    public int setDiscount(double discount) {
        this.discount = discount;
    }

}