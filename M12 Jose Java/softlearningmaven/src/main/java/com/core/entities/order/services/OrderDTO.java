package com.core.entities.order.services;

import com.core.entities.order.model.Order;
import com.core.entities.order.model.OrderStatus;

public class OrderDTO {
    private final int reference;
    private final String description;
    private final String initDate;
    private final String finishDate;
    private final String receiverAddress;
    private final String phoneContacts;
    private final String idClient;
    private final String receiverPerson;
    private final String paymentDate;
    private final String deliveryDate;
    private final double height;
    private final double width;
    private final double depth;
    private final double weight;
    private final boolean fragile;
    private final double length;
    private final String shopCart;
    private final OrderStatus status; // Nuevo campo
    private final double totalPrice;

    public OrderDTO(int reference, String description, String initDate, String finishDate, String receiverAddress,
                    String phoneContacts, String idClient, String receiverPerson, String paymentDate,
                    String deliveryDate, double height, double width, double depth, double weight, boolean fragile,
                    double length, String shopCart) {
        this.reference = reference;
        this.description = description;
        this.initDate = initDate;
        this.finishDate = finishDate;
        this.receiverAddress = receiverAddress;
        this.phoneContacts = phoneContacts;
        this.idClient = idClient;
        this.receiverPerson = receiverPerson;
        this.paymentDate = paymentDate;
        this.deliveryDate = deliveryDate;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
        this.fragile = fragile;
        this.length = length;
        this.shopCart = shopCart;
        this.status = status;
        this.totalPrice = totalPrice;
        
    }

    // Getters
    public int getReference() {
        return reference;
    }

    public String getDescription() {
        return description;
    }

    public String getInitDate() {
        return initDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public String getPhoneContacts() {
        return phoneContacts;
    }

    public String getIdClient() {
        return idClient;
    }

    public String getReceiverPerson() {
        return receiverPerson;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isFragile() {
        return fragile;
    }

    public double getLength() {
        return length;
    }

    public String getShopCart() {
        return shopCart;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }






}