package com.core.entities.order.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.core.checks.Check;
import com.core.entities.exceptions.BuildException;
import com.core.entities.exceptions.ServiceException;
import com.core.entities.shared.dimensions.Dimensions;
import com.core.entities.shared.operations.Operation;

public class Order extends Operation {

    protected String receiverAddress, receiverPerson;
    protected LocalDateTime paymentDate, deliveryDate; // Fecha de entrega
    protected String idClient; // ID del cliente
    protected Set<String> phoneContact; // Telefonos de contacto
    protected ArrayList<OrderDetails> shopCart =null;
    protected Dimensions orderPackage = null;
    protected OrderStatus status; // Estado de la compra
    StringBuilder sb = new StringBuilder();

    protected Order() {
        this.phoneContact = new HashSet<>();
        this.shopCart = new ArrayList<>();
        this.status = OrderStatus.CREATED;
    }

    // ********* ORDER BUILDERS*********/ (quiere decir que hay mas) ademas, hay que
    // setear bien el orden del enum
    // la ref del order(el declarado en operation) es el código de factura y la ref
    // del orderdetails es el isbn por ejemplo

    // jose tiene en el get instance pequeño (ref,
    // clientid,startdate,description,addres,nombre,telefono)
    // ESTE ES EL GET INSTANCE PEQUEÑO
    public static Order getInstance(
            String receiverAddress,
            String receiverPerson,
            String idClient,
            Set<String> phoneContact,
            String initDate,
            String finishDate,
            String description,
            int ref) throws BuildException {
        Order o = new Order();

        StringBuilder errors = new StringBuilder();
        int errorCode;

        /*
         * private static <T> void validateAndSet(Dimensions d, T value, Function<T,
         * Integer> setter, StringBuilder errors) {
         * int errorCode;
         * if ((errorCode = setter.apply(value)) != 0) {
         * errors.append(Check.getErrorMessage(errorCode)).append("\n");
         * }
         * validateAndSet(d, length, d::setLength, errors);
         * 
         * Probar con esto algunas lineas a ver como funciona para dejar de repetir
         * codigo, esta concretamente es para las dimensions
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

        for (String phone : phoneContact) {
            if ((errorCode = o.setPhoneContact(phone)) != 0) {
                errors.append(Check.getErrorMessage(errorCode)).append("\n");
            }
        }

        if (errors.length() > 0) {

            throw new BuildException("No es posible crear la compra en el pequeño: \n" + errors.toString());
        }

        return o;

    }

    // ESTE ES EL GET INSTANCE GRANDE
    // crear un getInstance con todos los parametros que me quedan, comrobando si o
    // es diferente a null,

    public static Order getInstance(
            // campos del pequeño
            String receiverAddress,
            String receiverPerson,
            String idClient,
            Set<String> phoneContact,
            String initDate,
            String finishDate,
            String description,
            int ref,
            // campos del grande dice jose que deberian ser mas de 3
            String paymentDate,
            String deliveryDate,
            String orderPackage,
            List<OrderDetails> shopCart) throws BuildException, ServiceException {
        StringBuilder errors = new StringBuilder();
        int errorCode;
        Order o = null;

        try {
            o = getInstance(receiverAddress, receiverPerson, idClient, phoneContact, initDate, finishDate, description,
                    ref);
            if (o != null) {

                // foreach del carrito si no es nulo
                if (shopCart == null) {
                    throw new BuildException("El carrito está vacío");
                }
                for (OrderDetails detail : shopCart) {
                    try {
                        o.setDetail(detail.getAmount(), detail.getDetailRef(), detail.getPrice(), detail.getDiscount());
                    } catch (ServiceException e) {
                        errors.append(e.getMessage()).append("\n");
                    }
                }

                // probar las dimensiones
                try {
                    o.setOrderPackage(orderPackage);
                } catch (BuildException e) {
                    throw new BuildException("Error en las dimensiones: " + e.getMessage());
                }

                // los otros campos que se validan aqui
                if ((errorCode = o.setPaymentDate(paymentDate)) != 0) {
                    errors.append(Check.getErrorMessage(errorCode)).append("\n");
                }

                if ((errorCode = o.setDeliveryDate(deliveryDate)) != 0) {
                    errors.append(Check.getErrorMessage(errorCode)).append("\n");
                }

                if ((errorCode = o.setOrderPackage(orderPackage)) != 0) {
                    errors.append(Check.getErrorMessage(errorCode)).append("\n");
                }

                if (errors.length() > 0) {
                    throw new BuildException("No es posible crear la compra en el grande: \n" + errors.toString());
                }

            }
        } catch (BuildException e) {
            errors.append(e.getMessage()).append("\n");
        }
        return o;

    }

    // getter

    public ArrayList<OrderDetails> getShopCart() {
        return this.shopCart;
    }

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

        return this.phoneContact;
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

    // setter

    public int setReceiverAddress(String receiverAddress) {
        // aqui habra que preguntar primero si
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

    public void shopCartCanceled()throws ServiceException {
        if(this.status == OrderStatus.CREATED) {
            this.status = OrderStatus.CANCELLED;
        }else{
            throw new ServiceException("No se puede cancelar una orden que ya ha sido pagada");
        }
    }

    public int setPaymentDate(String paymentDate) {
        int errorPaymentDate = Check.isValidDateComplete(paymentDate);
        if (errorPaymentDate == 0) {
            this.paymentDate = LocalDateTime.parse(paymentDate, this.formatter);
            this.status = OrderStatus.CONFIRMED;
        }
        return errorPaymentDate;
    }

    

    public int setIdClient(String idClient) {
        int errorIdClient = Check.minMaxLength(idClient);
        if (errorIdClient == 0) {
            this.idClient = idClient;
        }
        return errorIdClient;
    }

    public int setPhoneContact(String Phone) {
        int errorPhoneContact = Check.checkMobilePhone(Phone); // de momento solo checkeo si tiene 9 digitos, nada mas
        if (errorPhoneContact == 0) {
            phoneContact.add(Phone);// el propio metodo set los separa automaticamente, solo tengo que añadirlo en
                                    // los test
        }
        return errorPhoneContact;
    }

    // este es el setter de orderpackage
    public int setOrderPackage(String oP) throws BuildException {

        if (this.status == OrderStatus.CONFIRMED) {
            throw new BuildException("No se puede añadir un paquete a una orden no pagada");
        }
        // importante setear los parametros a 0, para que se puedan crear
        double weight = 0;
        double height = 0;
        double width = 0;
        boolean fragile = false;
        double length = 0;

        // ejemploString packageDetails = "h:202.20,w:202.20,W:202.20,f:true,d:202.20";

        // Dividimos el string por comas
        String[] details = oP.split(",");

        // dividimos cada parte del string por los puntos y usamos un switch para
        // asignar con los setters, keyvalue[0] es la letra y keyvalue[1] son los
        // numeros
        // el getinstace tiene que crear un order package
        for (String detail : details) {
            String[] keyValue = detail.split(":");

            switch (keyValue[0]) {
                case "h" -> height = (Double.parseDouble(keyValue[1])); // se setea así
                case "w" -> width = (Double.parseDouble(keyValue[1]));
                case "W" -> weight = (Double.parseDouble(keyValue[1]));
                case "f" -> fragile = (Boolean.parseBoolean(keyValue[1]));
                case "d" -> length = (Double.parseDouble(keyValue[1]));
                default -> {
                    throw new BuildException("Parametro desconocido: " + keyValue[0]);
                }
            }
            // se prueban las dimensions para ver si se pueden crear, si no, que pete
            try {
                this.orderPackage = Dimensions.getInstanceDimensions(weight, height, width, fragile, length);
            } catch (BuildException e) {
                throw new BuildException("Error en las dimensiones: " + e.getMessage());

            }
            this.orderPackage = Dimensions.getInstanceDimensions(weight, height, width, fragile, length);
            if (this.status == OrderStatus.CONFIRMED) {

                this.status = OrderStatus.FORTHCOMMING;
            }
        }

        return 0;

    }
    public int setDeliveryDate(String deliveryDate) {
        int errorDeliveryDate = Check.isValidDateComplete(deliveryDate);
        if (errorDeliveryDate == 0) {
            this.deliveryDate = LocalDateTime.parse(deliveryDate, this.formatter);
            this.status = OrderStatus.DELIVERED;
        }
        return errorDeliveryDate;
    }

    // setters de la clase auxiliar OrderDetarils en el Order
    // *************************************************************************
    // SET DETAIL
    // *************************************************************************

    public String setDetail(int amount, String detailRef, double price, double discount) throws ServiceException {

        try {
            OrderDetails detalle = OrderDetails.getInstance(amount, detailRef, price, discount);

            this.shopCart.add(detalle);

        } catch (ServiceException e) {
            throw new ServiceException("Error al crear el detalle: " + e.getMessage());
        }
        // Detalle añadido
        return "Detalle añadido al carrito";
    }

    // detalle por POSICION
    public String getPosDetail(int pos) {
        if (pos >= 0 && pos < shopCart.size()) {
            return this.shopCart.get(pos).toString();
        }
        return "No existe el detalle en la posición " + pos;
    }

    // detalle por REFERENCIA
    public String getRefDetail(String ref) { // cambiar nombre porque esto liará

        for (OrderDetails detail : shopCart) {
            if (detail.getDetailRef().equals(ref)) {
                return detail.toString();
            }
        }
        return "Detalle no encontrado";
    }

    // cantidad por POSICION y meter dentro del constructor
    public int updateDetail(int pos, int amount) throws ServiceException {
        // Validar posición
        if (pos < 0 || pos >= shopCart.size()) {
            throw new ServiceException("Error en pos: Posición inválida");
        }

        int errorCode = Check.range(amount);
        if (errorCode != 0) {
            throw new ServiceException("Error en amount: " + Check.getErrorMessage(errorCode));
        }

        this.shopCart.get(pos).setAmount(amount);
        return 0;
    }

    // cantidad por REFERENCIA y meter dentro del constructor
    public int updateDetail(String ref, int amount) throws ServiceException {

        int errorCode = Check.isNull(ref);
        if (errorCode != 0) {
            throw new ServiceException("Error en ref: " + Check.getErrorMessage(errorCode));
        }

        errorCode = Check.range(amount);
        if (errorCode != 0) {
            throw new ServiceException("Error en amount: " + Check.getErrorMessage(errorCode));
        }

        for (OrderDetails detail : shopCart) {

            if (detail.getDetailRef().equals(ref)) {
                detail.setAmount(amount);
                return 0;
            }
        }
        return errorCode;
    }

    // detalle por posicion
    public void deleteDetail(int pos) throws ServiceException {

        if (pos < 0 || pos >= shopCart.size()) {
            throw new ServiceException("Error en pos: Posición inválida");
        }

        this.shopCart.remove(pos);

    }

    // detalle por referencia y meter dentro del constructor
    public void deleteDetail(String ref) throws ServiceException {

        int errorCode = Check.isNull(ref);
        if (errorCode != 0) {
            throw new ServiceException("Error en ref: " + Check.getErrorMessage(errorCode));
        }

        for (OrderDetails detalle : shopCart) {
            if (detalle.getDetailRef().equals(ref)) {
                this.shopCart.remove(detalle);
            }
        }

    }

    // precio total
    public double getPrice() {
        double total = 0.0;
        for (OrderDetails detalle : shopCart) {
            total += detalle.getPrice() * detalle.getAmount();
        }
        return total;
    }

    // metodo para mostrar los detalles de la compra

    public String getOrderDetails() {

        sb.setLength(0); // sb a 0 para que no se repitan ordenes anteriores
        sb.append("Order Details: \n");
        sb.append("Receiver Address: ").append(this.receiverAddress).append("\n");
        sb.append("Receiver Person: ").append(this.receiverPerson).append("\n");
        sb.append("ID Client: ").append(this.idClient).append("\n");
        // los telefonos van aparte
        sb.append("Init Date: ").append(this.initDate).append("\n");
        sb.append("Finish Date: ").append(this.finishDate).append("\n");
        sb.append("Description: ").append(this.description).append("\n");
        sb.append("Reference: ").append(this.ref).append("\n");
        return sb.toString();
    }

    public String getCompleteOrderDetails() {

        sb.setLength(0); // sb a 0 para que no se repitan ordenes anteriores
        sb.append("Order Details: \n");
        sb.append("Receiver Address: ").append(this.receiverAddress).append("\n");
        sb.append("Receiver Person: ").append(this.receiverPerson).append("\n");
        sb.append("ID Client: ").append(this.idClient).append("\n");
        sb.append("Phone Contact: ").append(getPhoneContact()).append("\n");
        sb.append("Init Date: ").append(this.initDate).append("\n");
        sb.append("Finish Date: ").append(this.finishDate).append("\n");
        sb.append("Description: ").append(this.description).append("\n");
        sb.append("Reference: ").append(this.ref).append("\n");
        sb.append("Payment Date: ").append(this.paymentDate).append("\n");
        sb.append("Order Package: ").append(this.getOrderPackage()).append("\n");
        sb.append("Delivery Date: ").append(this.deliveryDate).append("\n");
        sb.append("Status: ").append(this.status).append("\n");
        sb.append("Shop Cart: \n");
        for (OrderDetails detail : shopCart) {
            sb.append(detail.toString()).append("\n");
        }
        sb.append("Total Price: ").append(getPrice()).append("\n");
        return sb.toString();
    }

}

// implementaciones de storable
// borradas las implementaciones de storable, no se usan en ningun momento, ya
// dirá jose cuando usarlas
