package com.core.entities.operations;

import java.time.LocalDateTime;

import com.core.entities.shared.storable.Storable;

//import jdk.vm.ci.meta.Local;

public class Order extends Operation implements Storable{
    
    protected String idOrder; // ID, no el dni, un numero de compra
    protected String receiverAddres, receiverPerson;
    protected LocalDateTime paymentDate, deliveryDate; // Fecha de entrega
    protected String idClient; // ID del cliente
    protected Set<String> phoneContact; // Telefonos de contacto
    protected OrderStatus status; // Estado de la compra
    

    protected Order() {
    }//constructor vacio

    //********* ORDER BUILDERS*********/

    public













    @Override
    public double volume() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'volume'");
    }

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
