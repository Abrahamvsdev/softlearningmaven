package com.core.entities.order.services;

import com.core.entities.exceptions.BuildException;
import com.core.entities.exceptions.ServiceException;
import com.core.entities.order.model.Order;

public class OrderMapper {

    public static Order orderFromDTO(OrderDTO odto) throws BuildException, ServiceException {

        Order order = Order.getInstance(
            odto.getRef(),
            odto.getDescription(),
            odto.getInitDate(),
            odto.getReceiverAddress(),
            odto.getReceiverPerson(),
            odto.getPhoneContact(),
            odto.getIdClient(),
            odto.getPaymentDate(),
            odto.getDeliveryDate(),
            odto.getFinishDate(),
            odto.getHeight(),
            odto.getWeight(),
            odto.getWidth(),
            odto.isFragile(),
            odto.getLength(),
            odto.getShopCart()
            );
        return order;
    }

    public static OrderDTO dtoFromOrder(Order ofromdto) {

        return new OrderDTO(
                ofromdto.getRef(),
                ofromdto.getDescription(),
                ofromdto.getInitDate(),
                ofromdto.getReceiverAddress(),
                ofromdto.getPhoneContact(),
                ofromdto.getIdClient(),
                ofromdto.getReceiverPerson(),
                ofromdto.getPaymentDate().toString(),
                ofromdto.getDeliveryDate().toString(),
                ofromdto.getFinishDate(),
                ofromdto.getOrderPackage().getHeight(),
                ofromdto.getOrderPackage().getWidth(),
                ofromdto.getOrderPackage().getWeight(),
                ofromdto.getOrderPackage().getFragile(),
                ofromdto.getOrderPackage().getLength(),
                ofromdto.getShopCart()
                );
    }
}