import com.core.entities.exceptions.BuildException;
import com.core.entities.exceptions.ServiceException;
import com.core.entities.order.model.Order;

public class TestOrderGrande {
    public static void main(String[] args) throws Exception, BuildException, ServiceException {
    

    
    
        //GETINSTANCE GRANDE
        // El getInstance "grande" nos permite ir añadiendo setter a setter todos y cada uno de los parámetros que nos faltan. Realizando varias verificaciones sobre acciones que nos deben retornar algun error
        try {
            Order order = Order.getInstance(
                "123 Main St", // Address
                "John Doe", // Customer Name
                "client123", // Client ID
                "123456789", // Order ID
                "2023-01-01T10:00:00", // Order Date
                "Test Order", // Order Description
                1111, // Product ID
                null, // Product Name
                "", // Product Description
                "", // Product Category
                0.0, // Quantity
                0.0, // Price per Unit
                0.0, // Discount
                false, // Is Paid
                10.0, // Total Amount
                null, // Delivery Date
                null // Additional Notes
            );
            order.getCompleteOrderDetails();
        } catch (BuildException | ServiceException e) {
            throw new BuildException("Ha petado el getCompleteOrderDetails " + e.getMessage());
        }
    }

    
    
        // Use the order variable
        
    }
 