
package com.core.entities.client.services;

import com.core.entities.client.model.Client;

public class ClientMapper {

    public static Client clientFromDTO(ClientDTO cdto) throws Exception{
        
        return Client.getInstance(cdto.getName(), 
                                    cdto.getSurname(), 
                                    cdto.getEmail(), 
                                    cdto.getAddress(), 
                                    cdto.getDni(), 
                                    cdto.getNumber(), 
                                    cdto.getAntiquity(), 
                                    cdto.getPaymentMode(), 
                                    cdto.getMembershipLevel(), 
                                    cdto.getRegistrationDate()
        );
    }    

    public static ClientDTO dtoFromClient(Client c){
        
        return new ClientDTO(
        
            c.getName(), 
            c.getSurname(), 
            c.getEmail(), 
            c.getAddress(), 
            c.getDni(), 
            c.getNumber(), 
            c.getAntiquity(), 
            c.getPaymentMode(), 
            c.getMembershipLevel(), 
            c.getRegistrationDate()
            );
    }
    
}