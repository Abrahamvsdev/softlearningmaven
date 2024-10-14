package com.core.entities.operations;
import com.core.checks.Check;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Operation {


    protected LocalDateTime initDate, finishDate;; // Fecha de la operacion
    protected String description; // Descripcion de la operacion, no de la compra
    protected String ref;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    


    protected Operation(){};// Constructor vacio};

    public void operation( String initDate, String finishDate,String description, String ref) throws Exception {
        StringBuilder errors = new StringBuilder();
        int errorCode;

        if ((errorCode = this.setInitDate(initDate)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        
        if (errors.length() > 0) {
            throw new Exception("No es posible crear la operación: \n" + errors.toString());
        }

    }

    public LocalDateTime getInitDate() {
        return initDate;
    }
    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }
    public LocalDateTime getFinishDate() {
        return finishDate;
    }
    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }
    public String getIdClient() {
        return idClient;
    }
    public String getProductList() {
        return productList;
    }
    public String getIdOperation() {
        return idOperation;
    }
    public String getIdProduct() {
        return idProduct;
    }
    
    public void setInitDate(LocalDateTime initDate) {
        this.initDate = initDate;
    }
    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }
    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
    public void setProductList(String productList) {
        this.productList = productList;
    }
    public void setIdOperation(String idOperation) {
        this.idOperation = idOperation;
    }
    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }
    
    }
    
    //setter
    
    
    
    





}
