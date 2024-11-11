package com.core.entities.order.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.core.checks.Check;
import com.core.entities.exceptions.BuildException;
import com.core.entities.shared.dimensions.Dimensions;
import com.core.entities.shared.operations.Operation;





public class Order extends Operation{
    
    
    protected String receiverAddress, receiverPerson;
    protected LocalDateTime paymentDate, deliveryDate; // Fecha de entrega
    protected String idClient; // ID del cliente
    protected Set<String> phoneContact; // Telefonos de contacto
    protected ArrayList<OrderDetails> shopCart;
    protected Dimensions orderPackage = null;
    protected OrderStatus status; // Estado de la compra
    StringBuilder errors = new StringBuilder();
    StringBuilder sb = new StringBuilder();
    
    
    
    protected Order() {
        this.phoneContact = new HashSet<>(); //Preguntar si un telefono lo comparte un matrimonio, ya seria repetido y perderia sentido 
        this.shopCart = new ArrayList<>();
        this.status = OrderStatus.CREATED;
    }

    //********* ORDER BUILDERS*********/ (quiere decir que hay mas) ademas, hay que setear bien el orden del enum
    //la ref del order es els codigo de factura y la ref del orderdetails es el isbn por ejemplo
    
    //el foreach de buscar el equals ref podemos hacerlo una funcion
    
    //jose tiene en el get instance pequeño (ref, clientid,startdate,description,addres,nombre,telefono)
    public static Order getInstance(String receiverAddress, String receiverPerson, String idClient, String phoneContact, 
    String initDate, String finishDate, String description, int ref, StringBuilder errors) throws BuildException {
        Order o = new Order();
    
        int errorCode;

        /*
         * private static <T> void validateAndSet(Dimensions d, T value, Function<T, Integer> setter, StringBuilder errors) {
    int errorCode;
    if ((errorCode = setter.apply(value)) != 0) {
        errors.append(Check.getErrorMessage(errorCode)).append("\n");
    }
        validateAndSet(d, length, d::setLength, errors);

        Probar con esto algunas lineas a ver como funciona para dejar de repetir codigo, esta concretamente es para las dimensions
         */

        try {
            o.operation(initDate, finishDate, description, ref);
        } catch (BuildException e) {
            throw new BuildException("Error en la operacion: " + e.getMessage());
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
            
            o = null;
            throw new BuildException("No es posible crear la compra: \n" + errors.toString());
        }
        return o;

    }



    
    //crear otro getinstance con todos los parametros que quedan por añadir, y que los sume a los que ya tengo en el getinstance si la bandera es true preparado para que lanze buildexception por el stado del enum (delivery y finish date)
    
    public static Order getCompleteInstance(String receiverAddress, String receiverPerson, String idClient, String phoneContact, 
    String initDate, String finishDate, String description, int ref, String paymentDate, String deliveryDate, String orderPackage)
    throws BuildException {

    StringBuilder errors = new StringBuilder();
    int errorCode;

    // Llamamos a getInstance pasando el StringBuilder errors
    if (o != null) {
        throw new BuildException("No se ha creado la operación");
    }else{
    try {
        o = getInstance(receiverAddress, receiverPerson, idClient, phoneContact, initDate, finishDate, description, ref, errors);
    } catch (BuildException e) {
        // Continuamos recopilando errores
    }

    // Validamos y establecemos paymentDate
    if ((errorCode = o.setPaymentDate(paymentDate)) != 0) {
        errors.append(Check.getErrorMessage(errorCode)).append("\n");
    }

    // Validamos y establecemos deliveryDate
    if ((errorCode = o.setDeliveryDate(deliveryDate)) != 0) {
        errors.append(Check.getErrorMessage(errorCode)).append("\n");
    }

    // Validamos y establecemos orderPackage
    if ((errorCode = o.setOrderPackage(orderPackage)) != 0) {
        errors.append(Check.getErrorMessage(errorCode)).append("\n");
    }

    // Si hubo errores, lanzamos una excepción
    if (errors.length() > 0) {
        throw new BuildException(errors.toString());
    }

    return o;
    }
    
}

    //getter

    // public ArrayList<OrderDetails> getShopCart() {
        //     return this.shopCart;
    // }
    
    
    
    public String getReceiverAddress() {
        return receiverAddress;
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

    public Dimensions getOrderPackage() {
        return this.orderPackage;
    }
    
    public OrderStatus getStatus() {
        return this.status; 
    }
    
    // metodo para obtener el num de detalles en el carrito de compras
    public int getNumDetails() {
        return this.shopCart.size();
    }

    public String getDetail(int pos) {
        if (pos >= 0 && pos < shopCart.size()) {
            return shopCart.get(pos).toString(); //como se devuelve esto?
        }
        return null;
    }
    





    //setter


    public int setReceiverAddress(String receiverAddress) {
        //aqui habra que preguntar primero si 
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
            this.status = OrderStatus.CONFIRMED;
        }
        return errorPaymentDate;
    }

    public int setDeliveryDate(String deliveryDate) {
        int errorDeliveryDate = Check.isValidDateComplete(deliveryDate);
        if (errorDeliveryDate == 0) {
            this.deliveryDate = LocalDateTime.parse(deliveryDate, this.formatter);
            this.status = OrderStatus.DELIVERED;
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
        int errorPhoneContact = Check.checkMobilePhone(p); // de momento solo checkeo si tiene 9 digitos, nada mas
        if (errorPhoneContact == 0) {
            phoneContact.add(p);// el propio metodo set los separa automaticamente, solo tengo que añadirlo
        }
        return errorPhoneContact;
    }



    // este es el setter de orderpackage 
    public int setOrderPackage(String oP) throws BuildException {
        
        //importante setear los datos a 0, para que se puedan crear 
        double weight = 0;
        double height = 0;
        double width = 0;
        boolean fragile = false;
        double length = 0;


        // ejemploString packageDetails = "h:202.20,w:202.20,W:202.20,f:true,d:202.20";

        // Dividimos el string por comas
        String[] details = oP.split(",");

        // dividimos cada parte del string por los puntos y usamos un switch para asignar con los setters, keyvalue[0] es la letra y keyvalue[1] son los numeros
        //el getinstace tiene que crear un order package
        for (String detail : details) {
            String[] keyValue = detail.split(":");

            switch (keyValue[0]) {
                case "h" -> height=(Double.parseDouble(keyValue[1])); //se setea así
                case "w" -> width=(Double.parseDouble(keyValue[1]));
                case "W" -> weight=(Double.parseDouble(keyValue[1]));
                case "f" -> fragile=(Boolean.parseBoolean(keyValue[1]));
                case "d" -> length=(Double.parseDouble(keyValue[1]));
                default -> {
                    throw new BuildException("Parametro desconocido: " + keyValue[0]);
                }
            }
            //se prueban las dimensions para ver si se pueden crear, si no, que pete
            try {
                this.orderPackage = Dimensions.getInstanceDimensions(weight, height, width, fragile, length);
            } catch (BuildException e) {
                throw new BuildException("Error en las dimensiones: " + e.getMessage());
                
            }
            if(this.status == OrderStatus.DELIVERED){ // tengo qeu quitar esto para reordenar, lo probe cuando hice el constructor con todo
                return 0;
            }else{
                this.status = OrderStatus.FORTHCOMMING;
            }
        }
        
        return 0;
        
    }

    // setters de la clase auxiliar OrderDetarils en el Order

    public int setDetail(int amount, String detailRef, double price, double discount) {
        OrderDetails detail = new OrderDetails();
        shopCart.add(detail);
        //aqui entran dobladitas
        //meter dentro del construc

    }

    // detalle por POSICION
public String getPosDetail(int pos) {
    if (pos >= 0 && pos < shopCart.size()) {
        return shopCart.get(pos).toString();
    }
    return "No existe el detalle en la posición " + pos;
}

// detalle por REFERENCIA
public String getRefDetail(String ref) { //cambiar nombre porque esto liará
    for (OrderDetails detail : shopCart) {
        if (detail.getDetailRef().equals(ref)) {
            return detail.toString();
        }
    }
    return "Detalle no encontrado";
}

//  cantidad por POSICION y meter dentro del constructor
public int updateDetail(int pos, int amount) {
    if (pos >= 0 && pos < shopCart.size()) {
        if(amount < 0){
            return 
        }
        shopCart.get(pos).setAmount(amount);
        return 
    }
    return ; 
}

//cantidad por REFERENCIA y meter dentro del constructor
public int updateDetail(String ref, int amount) {
    if(amount < 0){
        return 
    }
    for (OrderDetails detail : shopCart) {
        if (detail.getDetailRef().equals(ref)) {
            detail.setAmount(amount);
            return 
        }
    }
    return 
}


// detalle por posicion y meter dentro del constructor
public int deleteDetail(int pos) {
    if (pos >= 0 && pos < shopCart.size()) {
        shopCart.remove(pos);
        return 
    }
    return 
}


// detalle por referencia y meter dentro del constructor
public int deleteDetail(String ref) {
    for (OrderDetails detalle : shopCart) {
        if (detalle.getDetailRef().equals(ref)) {
            shopCart.remove(detalle);
            return 
        }
    }
    return 
}


// precio total
public double getPrice() {
    double total = 0.0;
    for (OrderDetails detalle : shopCart) {
        total += detalle.getPrice() * detalle.getAmount();
    }
    return total;
}






    
    //preguntar jose si opcional en el caso del discount funcionariaen los parametros
    


    public String getOrderDetails() {
        
        sb.append("Order Details: \n");
        sb.append("Receiver Address: ").append(this.receiverAddress).append("\n");
        sb.append("Receiver Person: ").append(this.receiverPerson).append("\n");
        sb.append("Payment Date: ").append(this.paymentDate).append("\n");
        sb.append("Delivery Date: ").append(this.deliveryDate).append("\n");
        sb.append("ID Client: ").append(this.idClient).append("\n");
        sb.append("Phone Contact: ").append(this.phoneContact).append("\n");
        sb.append("Shop Cart: ").append(this.shopCart).append("\n");
        sb.append("Order Package: ").append(this.orderPackage.getVolumeDetails()).append("\n");
        sb.append("Status: ").append(this.status).append("\n");
        return sb.toString();
    }



}
    
    

    


    //implementaciones de storable
    //borradas las implementaciones de storable, ya que no se usan en ningun momento, ya dirá jose cuando usarlas


