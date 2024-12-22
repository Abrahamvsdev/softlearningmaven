package com.core.appservices.serializers;

import java.util.TreeMap;

import com.core.entities.book.services.EspanolBookDTO;
import com.core.entities.book.services.JapaneseBookDTO;
import com.core.entities.client.services.EspanolClientDTO;
import com.core.entities.client.services.JapaneseClientDTO;
import com.core.entities.order.services.JapaneseOrderDTO;

public class SerializersCatalog {

    private static TreeMap<Serializers, Serializer > catalog = new TreeMap<>();

    private static void loadCatalog(){
        //AL CREAR UNA INSTANCIA DE CADA SERIALIZADOR, SE AÑADE AL CATALOGO

        // JapaneseClient
        catalog.put(Serializers.JSON_CLIENT,new JacksonSerializer<JapaneseClientDTO>());
        catalog.put(Serializers.XML_CLIENT,new JacksonXmlSerializer<JapaneseClientDTO>());

        // EspañolClient
        catalog.put(Serializers.JSON_CAST_CLIENT,new JacksonSerializer<EspanolClientDTO>());        
        catalog.put(Serializers.XML_CAST_CLIENT,new JacksonXmlSerializer<EspanolClientDTO>());

        // JapaneseBook
        catalog.put(Serializers.JSON_BOOK,new JacksonSerializer<JapaneseBookDTO>());
        catalog.put(Serializers.XML_BOOK,new JacksonXmlSerializer<JapaneseBookDTO>());

        // EspañolBook
        catalog.put(Serializers.JSON_CAST_BOOK,new JacksonSerializer<EspanolBookDTO>());
        catalog.put(Serializers.XML_CAST_BOOK,new JacksonXmlSerializer<EspanolBookDTO>());

        // JapaneseOrder
        catalog.put(Serializers.JSON_ORDER,new JacksonSerializer<JapaneseOrderDTO>());
        catalog.put(Serializers.XML_ORDER,new JacksonXmlSerializer<JapaneseOrderDTO>());

        // EspañolOrder
        catalog.put(Serializers.JSON_CAST_ORDER,new JacksonSerializer<JapaneseBookDTO>());
        catalog.put(Serializers.XML_CAST_ORDER,new JacksonXmlSerializer<JapaneseBookDTO>());

        // JapaneseCourseDTO
        // catalog.put(Serializers.JSON_COURSES,new JacksonSerializer<JapaneseCoursesDTO>());
        // catalog.put(Serializers.XML_COURSES,new JacksonXmlSerializer<JapaneseCoursesDTO>());

        // // EspañolCourseDTO
        // catalog.put(Serializers.JSON_CAST_COURSES, new JacksonSerializer<EspanolCoursesDTO>());
        // catalog.put(Serializers.XML_CAST_COURSES, new JacksonXmlSerializer<EspanolCoursesDTO>());

        // // EspañolEmployeeDTO
        // catalog.put(Serializers.JSON_EMPLOYEE,new JacksonSerializer<JapaneseEmployeeDTO>());
        // catalog.put(Serializers.XML_EMPLOYEE, new JacksonXmlSerializer<JapaneseEmployeeDTO>());

        // // EspñaolEmployeeDTO
        // catalog.put(Serializers.JSON_CAST_EMPLOYEE, new JacksonSerializer<EspanolaEmployeeDTO>());
        // catalog.put(Serializers.XML_CAST_EMPLOYEE, new JacksonXmlSerializer<EspanolEmployeeDTO>());
    }
    public static Serializer getInstace(Serializers type){
        if(catalog.isEmpty()){
            loadCatalog();
        }
        return catalog.get(type);
    }
}
