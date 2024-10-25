import com.core.entities.exceptions.BuildException;
import com.core.entities.order.model.Order;

public class TestOrder {
    public static void main(String[] args) throws Exception {
        // ArrayList <String> ciudades = new ArrayList<>();
        // ciudades.add("Madrid");
        // ciudades.add("Barcelona");
        // ciudades.add("Valencia");
        // ciudades.add("Sevilla");

        //testear la clase order getInstance
        
        Order o;
        try {
            o = Order.getInstance(receiverAddress, receiverPerson, paymentDate, deliveryDate, idClient, phoneContact, status, weight, height, width, fragile, length, initDate, finishDate, description, ref);
        } catch (Exception e) {
            System.out.println(e.toString());
            o=null;
        }


        




        
    }

    
}