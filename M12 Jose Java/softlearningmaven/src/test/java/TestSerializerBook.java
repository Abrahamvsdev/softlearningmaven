
import com.core.appservices.serializers.Serializer;
import com.core.appservices.serializers.Serializers;
import com.core.appservices.serializers.SerializersCatalog;
import com.core.entities.book.services.JapaneseBookDTO;




public class TestSerializerBook {
    public static void main(String[] args) {
                    
        JapaneseBookDTO japaneseBookTest = new JapaneseBookDTO( 
            "ident", 
            50.0, 
            true, 
            0.0, 
            "type", 
            "payMethod", 
            "2023/11/02-10:00:01", 
            "author", 
            "isbn", 
            "cover", 
            1001, 
            "genre", 
            "editorial", 
            10.0,
            10.0, 
            10.0, 
            true, 
            10.0, 
            10.0);
        try {
            System.out.println("JapaneseBookDTO Serializer: \n");
            Serializer<JapaneseBookDTO> formatter = SerializersCatalog.getInstance(Serializers.JSON_BOOK);
            String json = formatter.serialize(japaneseBookTest);
            System.out.println(json);

            System.out.println("\n JapaneseBookDTO Deserializer: \n");
            JapaneseBookDTO japaneseBookDeserialized =(JapaneseBookDTO) formatter.deserialize(json, JapaneseBookDTO.class);
            System.out.println(japaneseBookDeserialized);
            System.out.println("------------------------\n");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    
    }
}
