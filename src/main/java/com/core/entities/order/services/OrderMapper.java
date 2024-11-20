package com.core.entities.order.services;

import com.core.entities.order.model.Order;
import com.core.entities.exceptions.BuildException;

import java.util.Set;

public class OrderMapper {

    public static Order orderFromDTO(OrderDTO odto) throws BuildException {
        
        Order order = Order.getInstance(
                odto.getReceiverAddress(),
                odto.getReceiverPerson(),
                odto.getIdClient(),
                odto.getPhoneContact(),
                odto.getInitDate(),
                odto.getFinishDate(),
                odto.getDescription(),
                odto.getRef()
        );


        Set<String> phoneContacts = odto.getPhoneContact();
        for (String phone : phoneContacts) {
            order.setPhoneContact(phone);
        }

        return order;
    }

    public static OrderDTO dtoFromOrder(Order order) {
        String initDate = null;
        if (order.getInitDate() != null) {
            initDate = order.getInitDate().toString();
        }

        String finishDate = null;
        if (order.getFinishDate() != null) {
            finishDate = order.getFinishDate().toString();
        }

        String paymentDate = null;
        if (order.getPaymentDate() != null) {
            paymentDate = order.getPaymentDate().toString();
        }

        String deliveryDate = null;
        if (order.getDeliveryDate() != null) {
            deliveryDate = order.getDeliveryDate().toString();
        }

        String orderPackage = null;
        if (order.getOrderPackage() != null) {
            orderPackage = order.getOrderPackage().toString();
        }

        return new OrderDTO(
                order.getReceiverAddress(),
                order.getReceiverPerson(),
                order.getIdClient(),
                order.getPhoneContact(),
                initDate,
                finishDate,
                order.getDescription(),
                order.getRef(),
                paymentDate,
                deliveryDate,
                orderPackage
        );
    }
}