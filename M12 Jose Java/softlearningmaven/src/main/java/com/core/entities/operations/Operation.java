package com.core.entities.operations;
import com.core.checks.Check;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Operation {


    protected LocalDateTime initDate, finishDate;; // Fecha de la operacion
    protected String description; // Descripcion de la operacion, no de la compra
    protected String ref; // Referencia de la operacion, Un numero que clasifique la operacion
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    protected Operation(){};// Constructor vacio;

    public void operation( String initDate, String finishDate,String description, String ref) throws Exception {
        StringBuilder errors = new StringBuilder();
        int errorCode;

        if ((errorCode = this.setInitDate(initDate)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        
        if (errors.length() > 0) {
            throw new Exception("No es posible crear la operación: \n" + errors.toString());
        }

    }

    //getter
    public LocalDateTime getInitDate() {
        return initDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public String getDescription() {
        return description;
    }

    public String getRef() {
        return ref;
    }

    public int setInitDate(LocalDateTime initDate) {
        this.initDate = initDate;
    }

    public int setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public int setDescription(String description) {
        this.description = description;
    }

    public int setRef(String ref) {
        this.ref = ref;
    }

 
    //setter











    

}






