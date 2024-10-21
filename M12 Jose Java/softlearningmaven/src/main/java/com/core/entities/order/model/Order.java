package com.core.entities.order.model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.core.checks.Check;
import com.core.entities.shared.operations.Operation;
import com.core.entities.shared.dimensions.Dimensions;
import com.core.entities.shared.storable.Storable;



public class Order extends Operation implements Storable{
    
    
    protected String receiverAddress, receiverPerson;
    protected LocalDateTime paymentDate, deliveryDate; // Fecha de entrega
    protected String idClient; // ID del cliente
    protected Set<String> phoneContact; // Telefonos de contacto
    protected ArrayList<OrderDetails> shopCart;
    protected Dimensions orderPackage = null;
    protected OrderStatus status; // Estado de la compra
    

    protected Order() {
        this.phoneContact = new HashSet<String>();
        this.shopCart = new ArrayList<OrderDetails>();
        this.status = OrderStatus.CREATED;
    }

    //********* ORDER BUILDERS*********/

    public static Order getInstance(String receiverAddress, String receiverPerson, String paymentDate, String deliveryDate, String idClient, Set<String> phoneContact, OrderStatus status, 
    double weight, double height, double width, double length, 
    String initDate, String finishDate, String description, int ref) throws Exception {
        Order o = new Order();
        StringBuilder errors = new StringBuilder();
        int errorCode;

        try {
            o.operation(initDate, finishDate, description, ref);
        } catch (Exception e) {
            throw new Exception("Error en la operacion: " + e.getMessage());
        }
        
        try {
            o.orderPackage = Dimensions.getInstanceDimensions(weight, height, width, length);
        } catch (Exception e) {
            throw new Exception("Error en las dimensiones: " + e.getMessage());
        }

        if ((errorCode = o.setReceiverAddress(receiverAddress)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        if ((errorCode = o.setReceiverPerson(receiverPerson)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        if ((errorCode = o.setIdClient(idClient)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        if ((errorCode = o.setPhoneContact(phoneContact)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        if ((errorCode = o.setStatus(status)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        if (errors.length() > 0) {
            throw new Exception("No es posible crear la compra: \n" + errors.toString());
        }

        return o;
    }

    //getter
    
   // String packageDetails = "h:202.20,w:202.20,W:202.20,f:true,d:202.20";

    










    
    public ArrayList<OrderDetails> getShopCart() {
        return shopCart;// preguntar que se retorna aqui
    }

    public Dimensions getOrderPackage() { //el get seria que retorne string
        return orderPackage;
    }

    
    
    public String getReceiverAddres() {
        return this.receiverAddress;
    }
    
    public String getReceiverPerson() {
        return receiverPerson;
    }
    
    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }
    
    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }
    
    public String getIdClient() {
        return idClient;
    }
    
    public Set<String> getPhoneContact() {
        return phoneContact;
    }
    
    public OrderStatus getStatus() {
        return status;
    }
    
    
    
    //setter



    public int setReceiverAddress(String receiverAddress) {
        
        int errorReceiverAddress = Check.minMaxLength(receiverAddress);
        if (errorReceiverAddress == 0) {
            this.receiverAddress = receiverAddress;
        }
        return errorReceiverAddress;
    }

    public int setReceiverPerson(String receiverPerson) {
        int errorReceiverPerson = Check.minMaxLength(receiverPerson);
        if (errorReceiverPerson == 0) {
            this.receiverPerson = receiverPerson;
        }
        return errorReceiverPerson;
    }

    public int setPaymentDate(String paymentDate) {
        int errorPaymentDate = Check.isValidDateComplete(paymentDate);
        if (errorPaymentDate == 0) {
            this.paymentDate = LocalDateTime.parse(paymentDate, this.formatter);
        }
        return errorPaymentDate;
    }

    public int setDeliveryDate(String deliveryDate) {
        int errorDeliveryDate = Check.isValidDateComplete(deliveryDate);
        if (errorDeliveryDate == 0) {
            this.deliveryDate = LocalDateTime.parse(deliveryDate, this.formatter);
        }
        return errorDeliveryDate;
    }

    public int setIdClient(String idClient) {
        int errorIdClient = Check.minMaxLength(idClient);
        if (errorIdClient == 0) {
            this.idClient = idClient;
        }
        return errorIdClient;
    }

    public int setPhoneContact(Set<String> phoneContact) {
        this.phoneContact = phoneContact;
    }

    public int setShopCart(ArrayList<OrderDetails> shopCart) {
        this.shopCart = shopCart;
    }

    public int setOrderPackage(Dimensions orderPackage) {
        this.orderPackage = orderPackage;
    }

    public int setStatus(OrderStatus status) {
        this.status = status;
    }




    //implementaciones de storable

    @Override
    public boolean isFragile() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isFragile'");
    }

    @Override
    public boolean isHeavy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isHeavy'");
    }

    @Override
    public boolean isFlexible() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isFlexible'");
    }
    
    
    @Override
    public double volume() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'volume'");
    }

    
}
