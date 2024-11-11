package com.core.entities.shared.operations;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.core.checks.Check;
import com.core.entities.exceptions.BuildException;

public abstract class Operation {

    
    protected LocalDateTime initDate, finishDate;; // Fecha de la operacion
    protected String description; // Descripcion de la operacion, no de la compra
    protected int ref; // Referencia de la operacion, Un numero que clasifique la operacion
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");
    
    protected Operation(){};// Constructor vacio;

    public void operation( String initDate, String finishDate,String description, int ref) throws BuildException {
        StringBuilder errors = new StringBuilder();
        int errorCode;

        if ((errorCode = this.setInitDate(initDate)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        if ((errorCode = this.setFinishDate(finishDate)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        this.setDescription(description);// No se valida porque no tiene restricciones, hacer cositas con los insultos y palabras malsonantes

        if ((errorCode = this.setRef(ref)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        
        if (errors.length() > 0) {
            throw new BuildException("No es posible crear la operación: \n" + errors.toString());
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
    
    public int getRef() {
        return ref;
    }





    //setter

    public int setInitDate(String initDate) {
        int errorCode = Check.isValidDateComplete(initDate);
        if(errorCode == 0){
            this.initDate = LocalDateTime.parse(initDate, formatter);
        }
        return errorCode;
    }

    public int setFinishDate(String finishDate) {
        int errorCode = Check.isValidDateComplete(finishDate);
        if(errorCode == 0){
            this.finishDate = LocalDateTime.parse(finishDate, formatter);
        }
        return errorCode;
    }

    public int setDescription(String description) {
        this.description = description; //preguntar si aqui puedo hacer un optional potrque esta es opcional, lo mismo hay lo mismo no
        return 0;
    }

    public int setRef(int ref) {
        if(ref<1000){
            return -15;
        }
        if(ref>1000 && ref<10000){
            this.ref = ref;
        }
        return 0;
    }



}






