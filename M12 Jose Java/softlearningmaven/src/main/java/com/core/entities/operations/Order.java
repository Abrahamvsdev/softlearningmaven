package com.core.entities.operations;

import java.time.LocalDateTime;

import jdk.vm.ci.meta.Local;

public class Order extends Operation {
    
    protected String idOrder; // ID, no el dni, un numero de compra
    protected String receiverAddres, receiverPerson;
    protected LocalDateTime paymentDate, deliveryDate; // Fecha de entrega
    protected String idClient; // ID del cliente
    //aqui tiene sentido de informacion del transporte





}
