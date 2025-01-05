package com.core.entities.client;

import com.core.entities.client.model.Client;
import com.core.entities.client.services.ClientDTO;
import com.core.entities.client.services.ClientMapper;
import com.core.entities.exceptions.BuildException;

public class ClientTest {
    public static void main(String[]args) throws Exception{
        
        Client c;
        try{
            c=Client.getInstance(
            "Jose", 
            "Perez", 
            "email@gmail.com", 
            "Calle falsa 123", 
            "12345678A", 
            "123456789", 
            "Targeta", 
            12, 
            "asd", 
            "02-03-1990");
            //System.out.println(c.getDetails());

            //Mapper
            ClientDTO cdto = ClientMapper.dtoFromClient(c);
            System.out.println("Client number : " + cdto.getNumber());

            System.out.println("------------------------");

            Client ccopy = ClientMapper.clientFromDTO(cdto);
            System.out.println("Mapper Client: " + ccopy.getDetails());

        }catch(BuildException e){
            System.out.println(e.toString());
        }
    }
}

