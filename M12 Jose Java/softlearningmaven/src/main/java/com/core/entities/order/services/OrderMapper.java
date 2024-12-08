package com.core.entities.order.services;

import com.core.entities.exceptions.BuildException;
import com.core.entities.exceptions.ServiceException;
import com.core.entities.order.model.Order;

public class OrderMapper {

    public static Order orderFromDTO(OrderDTO odto) throws BuildException, ServiceException {

        Order order = Order.getInstance(
            odto.getReceiverAddress(),
            odto.getReceiverPerson(),
            odto.getIdClient(),
            odto.getPhoneContact(),
            odto.getInitDate(),
            odto.getDescription(),
            odto.getRef(),
            odto.getShopCart(),
            odto.getPaymentDate(),
            odto.getWeight(),
            odto.getHeight(),
            odto.getWidth(),
            odto.isFragile(),
            odto.getLength(),
            odto.getDeliveryDate(),
            odto.getFinishDate()
            );
            

        return order;
    }

    public static OrderDTO dtoFromOrder(Order ofromdto) {

        return new OrderDTO(
                ofromdto.getRef(),
                ofromdto.getDescription(),
                ofromdto.getInitDate().toString(),
                ofromdto.getFinishDate().toString(),
                ofromdto.getReceiverAddress(),
                ofromdto.getPhoneContact(),
                ofromdto.getIdClient(),
                ofromdto.getReceiverPerson(),
                ofromdto.getPaymentDate().toString(),
                ofromdto.getDeliveryDate().toString(),
                ofromdto.getOrderPackage().getHeight(),
                ofromdto.getOrderPackage().getWidth(),
                ofromdto.getOrderPackage().getWeight(),
                ofromdto.getOrderPackage().getFragile(),
                ofromdto.getOrderPackage().getLength(),
                ofromdto.getOrderPackage().toString(),
                ofromdto.getPrice());
    }
}