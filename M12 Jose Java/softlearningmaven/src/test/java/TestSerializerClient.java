
import com.core.appservices.serializers.Serializer;
import com.core.appservices.serializers.Serializers;
import com.core.appservices.serializers.SerializersCatalog;
import com.core.entities.client.services.JapaneseClientDTO;





public class TestSerializerClient {
    public static void main(String[] args) {
                    
        JapaneseClientDTO japaneseClientTest = new JapaneseClientDTO(
            "Pedro", 
            "surname", 
            "email@email.com", 
            "address", 
            "123456789", 
            "123456789", 
            12, //TODO voy por aqui, me he equedado cambiendo este corta y pega para adaptarlo al client
            , 
            membershipLevel, 
            registrationDate);
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
