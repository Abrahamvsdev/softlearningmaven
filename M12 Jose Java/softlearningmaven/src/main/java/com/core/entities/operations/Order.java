package com.core.entities.operations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.core.entities.order.model.OrderDetails;
import com.core.entities.order.model.OrderStatus;
import com.core.entities.shared.dimensions.Dimensions;
import com.core.entities.shared.storable.Storable;

//import jdk.vm.ci.meta.Local;

public class Order extends Operation implements Storable{
    
    protected int idOrder; // ID, no el dni, un numero de compra 
    protected String receiverAddres, receiverPerson;
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

    public static Order getInstance(String idOrder, String receiverAddres, String receiverPerson, String paymentDate, String deliveryDate, String idClient, Set<String> phoneContact, OrderStatus status) throws Exception {
        Order order = new Order();
        StringBuilder errors = new StringBuilder();
        int errorCode;

        try {
            order.operation(paymentDate, deliveryDate, "Compra", 0);
        } catch (Exception e) {
            throw new Exception("Error en la operacion: " + e.getMessage());
        }

        if ((errorCode = order.setIdOrder(idOrder)) != 0) {
            errors.append(errorCode).append("\n");
        }

        if ((errorCode = order.setReceiverAddres(receiverAddres)) != 0) {
            errors.append(errorCode).append("\n");
        }

        if ((errorCode = order.setReceiverPerson(receiverPerson)) != 0) {
            errors.append(errorCode).append("\n");
        }

        if ((errorCode = order.setIdClient(idClient)) != 0) {
            errors.append(errorCode).append("\n");
        }

        if ((errorCode = order.setPhoneContact(phoneContact)) != 0) {
            errors.append(errorCode).append("\n");
        }

        if ((errorCode = order.setStatus(status)) != 0) {
            errors.append(errorCode).append("\n");
        }

        if (errors.length() > 0) {
            throw new Exception("No es posible crear la compra: \n" + errors.toString());
        }

        return order;
    }

    //getter
    











    @Override
    public double volume() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'volume'");
    }

    public String getIdOrder() {
        return idOrder;
    }

    public String getReceiverAddres() {
        return receiverAddres;
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



}
