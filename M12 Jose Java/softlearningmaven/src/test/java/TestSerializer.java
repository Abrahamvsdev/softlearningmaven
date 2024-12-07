import com.core.entities.exceptions.BuildException;
import com.core.entities.exceptions.ServiceException;

public class TestSerializer {
    public static void main(String[] args) throws Exception, BuildException, ServiceException {
        //ejemplo de serializacion
        System.out.println("Hello world!");
        BookDTO b = new BookDTO("Sapiens", "Yuval Harari", 300);
        ObjectMapper mapper = new ObjectMapper();
    	String jsonBook;
        try {
            jsonBook = mapper.writeValueAsString(b);
            System.out.println(jsonBook);
            BookDTO bImported = new ObjectMapper().readValue(jsonBook, BookDTO.class);
	        System.out.println(bImported);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        // GETINSTANCE GRANDE
        // El getInstance "grande" nos permite ir añadiendo setter a setter todos y cada
        // uno de los parámetros que nos faltan. Realizando varias verificaciones sobre
        // acciones que nos deben retornar algun error
        // try {
        //     Order order = Order.getInstance(
        //         "calle falsa 123",
        //         "Pedro Medario",
        //         "ID1234",
        //         "123456789",
        //         "2023/11/02-10:00:10",
        //         "description",
        //         1234,
        //         "amount:2,ref:REF001,price:10.0,discount:5.0;amount:1,ref:REF002,price:20.0,discount:0.0",
        //         "2023/11/02-10:00:10",
        //         "h:202.20,w:202.20,W:202.20,f:true,d:202.20",
        //         10.0,
        //         5.0,
        //         2.0,
        //         true,
        //         3.0,
        //         "2024/11/02-09:00:10",
        //         "2024/11/02-10:00:10");
        //     System.out.println(order.getCompleteOrderDetails());
            
        // } catch (BuildException | ServiceException e) {
        //     System.out.println(e.getMessage());
        // }



    }
}
