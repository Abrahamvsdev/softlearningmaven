import com.core.entities.book.services.BooksDTO;
import com.core.entities.exceptions.BuildException;
import com.core.entities.exceptions.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class TestSerializer {
    public static void main(String[] args) throws Exception, BuildException, ServiceException {
        //ejemplo de serializacion
        System.out.println("Hello world!");
        BooksDTO b = new BooksDTO(
            "1234",
            10.0,
            true,
            0.0,
            "type",
            "payMethod",
            "2023/11/02-10:00:10",
            "author",
            "isbn",
            "cover",
            10,
            "genre",
            "editorial",
            10.0,
            10.0,
            10.0,
            true,
            10.0, 0
        );
        ObjectMapper mapper = new ObjectMapper();
    	String jsonBook;
        try {
            jsonBook = mapper.writeValueAsString(b);
            System.out.println(jsonBook);
            BooksDTO bImported = new ObjectMapper().readValue(jsonBook, BooksDTO.class);
	        System.out.println(bImported);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
