import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.core.entities.exceptions.BuildException;
import com.core.entities.exceptions.ServiceException;
import com.core.entities.order.model.Order;
import com.core.entities.order.model.OrderDetails;

public class TestOrder {
    public static void main(String[] args) throws Exception, BuildException,ServiceException {
        /*
        // ArrayList <String> ciudades = new ArrayList<>();
        // ciudades.add("Madrid");
        // ciudades.add("Barcelona");
        // ciudades.add("Valencia");
        // ciudades.add("Sevilla");

        
        
        //Order o;
        //String orderPackage = "h:202.20,w:202.20,W:202.20,f:true,d:202.20";
        
            //o = Order.getInstance("calle 123", "receiverPerson", "2024/10/25-00:00:00", "2025/05/26-00:00:00", "123456789", "687687687", "kjasd", "2025/05/26-00:00:00", "2025/05/26-00:00:00", "description", 1111, "h:202.20,w:202.20,W:202.20,f:true,d:202.20");
            
            //o.setOrderPackage(orderPackage);
            //System.out.println(o.getOrderDetails());
            */

            //GETINSTANCE PEQUEÑO
        try {
        Set<String> phoneContacts = new HashSet<>();
        phoneContacts.add("123456789");
        phoneContacts.add("987654321");

        Order order = Order.getInstance(
                "Ejemplo 456",
                "P. Palotes",
                "ID5678",
                phoneContacts,
                "2023/11/01-10:00:00",
                "2023/11/10-18:00:00",
                "Descripción del pedido",
                2002
        );

        System.out.println(order.getOrderDetails());

        } catch (BuildException e) {
        System.out.println("Error al crear Order pequeño: " + e.getMessage());
        }


        
        //GETINSTANCE GRANDE
        try {
            // Configurar datos básicos
            Set<String> phoneContacts = new HashSet<>();
            phoneContacts.add("123456789");
            phoneContacts.add("987654321");

            // Crear lista de OrderDetails
            List<OrderDetails> shopCart = new ArrayList<>();
            OrderDetails.getInstance(2, "REF001", 10.0, 0.0);
            OrderDetails.getInstance(3, "REF002", 20.0, 0.0);
            //shopCart.set(1, OrderDetails.getInstance(2, "REF003", 10.0, 0.0)); para añadirlo en la posicion que yo quiera
             // Eliminar un producto usando el metodo deleteDetail de Order
            //shopCart.deleteDetail(1); // Eliminar un producto

            


            //shopCart.get(0).setAmount(3);  Modificar cantidad de un producto


            // Crear Order con getInstance grande
            Order order = Order.getInstance(
                "Ejemplo 456",
                "Pedro Medario",
                "ID5678",
                phoneContacts,
                "2023/11/01-10:00:00",
                "2023/11/10-18:00:00",
                "Descripción del pedido",
                2002,
                "2023/11/02-09:00:10", // paymentDate
                "2023/11/12-17:00:10", // deliveryDate
                "h:202.20,w:202.20,W:202.20,f:true,d:202.20", // Dimensions
                shopCart
            );

            System.out.println("Order creado exitosamente");
            System.out.println(order.getCompleteOrderDetails());

            } catch (BuildException e) {
                System.out.println("Error al crear Order grande: " + e.getMessage());
            } catch (ServiceException e) {
                System.out.println("Error de servicio: " + e.getMessage());
            }


            }

    
    

    
}