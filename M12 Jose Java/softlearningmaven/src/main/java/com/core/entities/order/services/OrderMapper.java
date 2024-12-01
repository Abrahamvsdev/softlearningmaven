package com.core.entities.order.services;

import com.core.entities.order.model.Order;
import com.core.entities.exceptions.BuildException;

import com.core.entities.exceptions.ServiceException;

public class OrderMapper {

    public static Order orderFromDTO(OrderDTO odto) throws BuildException, ServiceException {

        Order order = Order.getInstance(
                odto.getReceiverAddress(),
                odto.getReceiverPerson(),
                odto.getIdClient(),
                odto.getPhoneContact(),
                odto.getInitDate(),
                odto.getFinishDate(),
                0,
                odto.getDescription(),
                null,
                null,
                odto.getRef(),
                0,
                0,
                false,
                0,
                null,
                null);

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
                order.getRef(),
                order.getDescription(),
                initDate,
                finishDate,
                order.getReceiverAddress(),
                PhoneContact,
                order.getIdClient(),
                order.getReceiverPerson(),
                paymentDate,
                deliveryDate,
                0,
                0,
                0,
                0,
                false,
                0,
                orderPackage,
                order.getStatus(),
                0.0);
    }
}