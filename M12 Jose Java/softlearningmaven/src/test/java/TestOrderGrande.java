import com.core.entities.exceptions.BuildException;
import com.core.entities.exceptions.ServiceException;
import com.core.entities.order.model.Order;

public class TestOrderGrande {
    public static void main(String[] args) throws Exception, BuildException, ServiceException {

        // GETINSTANCE GRANDE
        // El getInstance "grande" nos permite ir añadiendo setter a setter todos y cada
        // uno de los parámetros que nos faltan. Realizando varias verificaciones sobre
        // acciones que nos deben retornar algun error
        try {
            Order order = Order.getInstance(
                
                1234,
                "description",
                "2023/11/02-10:00:10",
                "calle falsa 123",
                "Pedro Medario",
                "123456789",
                "ID1234",
                "2024/11/02-10:00:10",
                "2023/11/02-10:00:10",
                "2024/11/02-10:00:10",
                11.0,
                10.0,
                10.0,
                true,
                10.0,
                "amount:2,ref:REF001,price:10.0,discount:5.0;amount:1,ref:REF002,price:20.0,discount:0.0");
            System.out.println(order.getCompleteOrderDetails());
            
        } catch (BuildException | ServiceException e) {
            System.out.println(e.getMessage());
        }
    }
}
