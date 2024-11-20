package com.core.entities.order.services;

import java.util.Set;

public class OrderDTO {
    private final String receiverAddress;
    private final String receiverPerson;
    private final String idClient;
    private final Set<String> phoneContact;
    private final String initDate;
    private final String finishDate;
    private final String description;
    private final int ref;
    private final String paymentDate;
    private final String deliveryDate;
    private final String orderPackage;

    public OrderDTO(String receiverAddress, String receiverPerson, String idClient, Set<String> phoneContact,
                    String initDate, String finishDate, String description, int ref,
                    String paymentDate, String deliveryDate, String orderPackage) {
        this.receiverAddress = receiverAddress;
        this.receiverPerson = receiverPerson;
        this.idClient = idClient;
        this.phoneContact = phoneContact;
        this.initDate = initDate;
        this.finishDate = finishDate;
        this.description = description;
        this.ref = ref;
        this.paymentDate = paymentDate;
        this.deliveryDate = deliveryDate;
        this.orderPackage = orderPackage;
    }

    
    public String getReceiverAddress() {
        return receiverAddress;
    }

    public String getReceiverPerson() {
        return receiverPerson;
    }

    public String getIdClient() {
        return idClient;
    }

    public Set<String> getPhoneContact() {
        return phoneContact;
    }

    public String getInitDate() {
        return initDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public String getDescription() {
        return description;
    }

    public int getRef() {
        return ref;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getOrderPackage() {
        return orderPackage;
    }
}