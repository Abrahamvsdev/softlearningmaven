package com.core.entities.order.model;



import java.awt.Dimension;
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
        this.phoneContact = new HashSet<>(); //esto si se puede porque es propio de java
        this.shopCart = new ArrayList<>();
        this.status = OrderStatus.CREATED;
    }

    //********* ORDER BUILDERS*********/

    public static Order getInstance(String receiverAddress, String receiverPerson, String paymentDate, String deliveryDate, String idClient, String phoneContact, OrderStatus status, 
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

        if (errors.length() > 0) {
            throw new Exception("No es posible crear la compra: \n" + errors.toString());
        }

        return o;
    }

    //getter
    


    










    
    public ArrayList<OrderDetails> getShopCart() {
        return this.shopCart;// preguntar que se retorna aqui, como va esot en general ESTO ESTA PENDIENTE
    }
    public Dimensions getOrderPackage() { //el get seria que retorne string. con la funcion .strcat añadir a una variable cositas
        return this.orderPackage;
    }

    
    
    public String getReceiverAddres() {
        return this.receiverAddress;
    }
    
    public String getReceiverPerson() {
        return this.receiverPerson;
    }
    
    public LocalDateTime getPaymentDate() {
        return this.paymentDate;
    }
    
    public LocalDateTime getDeliveryDate() {
        return this.deliveryDate;
    }
    
    public String getIdClient() {
        return this.idClient;
    }
    
    public Set<String> getPhoneContact() {

        return this.phoneContact;// mirar como se añade cosas al set
    }
    
    private OrderStatus getStatus() {
        return this.status; //lo pongo provado, luego ya veremos
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

    public int setPhoneContact(String p) {
        int errorPhoneContact = Check.checkMobilePhone(p);
        if (errorPhoneContact == 0) {
            phoneContact.add(p);// el propio metodo set los separa automaticamente
        }
        return errorPhoneContact;
    }

    

    public void setOrderPackage(String orderPackage) {

    double weight;
    double height;
    double width;
    double length;
    boolean fragile;

       //SI ES UN OBJETO, PERO ESTA DENTRO DE DIMENSION
        String packageDetails = "h:202.20,w:202.20,W:202.20,f:true,d:202.20";
        // Dividimos el string por comas
        String[] details = packageDetails.split(",");

        // Recorremos cada parte del string y usamos un switch para asignar con los setters
        //el getinstace tiene que crear un order package
        for (String detail : details) {
            String[] keyValue = detail.split(":");

            switch (keyValue[0]) {
                case "h":
                height=(Double.parseDouble(keyValue[1])); //se setea así
                    break;
                case "w":
                this.orderPackage.set(Double.parseDouble(keyValue[1]));
                    break;
                case "W":
                orderPackage.setBigW(Double.parseDouble(keyValue[1]));
                    break;
                case "f":
                orderPackage.setF(Boolean.parseBoolean(keyValue[1]));
                    break;
                case "d":
                orderPackage.setD(Double.parseDouble(keyValue[1]));
                    break;
                default:
                    //System.out.println("Llave desconocida: " + keyValue[0]);
            }
            this.orderPackage = Dimensions.getInstanceDimensions(weight, height, width, length);
        }//acabar de implementar


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
