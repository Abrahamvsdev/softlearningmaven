package com.core.entities.shared.operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.core.checks.Check;
import com.core.entities.exceptions.BuildException;

public abstract class Operation {

    protected LocalDateTime initDate, finishDate; // Fecha de la operacion
    protected String description; // Descripcion de la operacion, no de la compra
    protected int reference; // Referencia de la operacion, Un numero que clasifique la operacion
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");

    protected Operation() {
    };// Constructor vacio;

    public void operation(
        int reference,
        String description, 
        String initDate, 
        String finishDate
        ) throws BuildException {
        StringBuilder errors = new StringBuilder();
        int errorCode;

        if ((errorCode = this.setRef(reference)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        
        this.setDescription(description);// No se valida porque no tiene restricciones, hacer cositas con los insultos y
                                         // palabras malsonantes
        
        
            if ((errorCode = this.setInitDate(initDate)) != 0) {
                errors.append(Check.getErrorMessage(errorCode)).append("\n");
            }
        

        if (finishDate != null) {
            if ((errorCode = this.setFinishDate(finishDate)) != 0) {
                errors.append(Check.getErrorMessage(errorCode)).append("\n");
            }
        }



        if (errors.length() > 0) {
            throw new BuildException("No es posible crear la operaciónORDERDENTRO: \n" + errors.toString());
        }

    }

    // getter
    public String getInitDate() {
        if(this.initDate != null){
            return this.initDate.format(formatter);
        }
        return "";
    }

    public String getFinishDate() {
        if(this.finishDate !=null){
            return this.finishDate.format(formatter);
        }
        return "";
    }

    public String getDescription() {
        return description;
    }

    public int getRef() {
        return reference;
    }

    // setter

    public int setInitDate(String initDate) {
        if (initDate != null) {
            int errorCode = Check.isValidDateComplete(initDate);
            if (errorCode == 0) {
                this.initDate = LocalDateTime.parse(initDate, formatter);
            }
            return errorCode;
        }
        return 15;
    }

    public int setFinishDate(String finishDate) throws BuildException {
        if (finishDate != null) {
            int errorCode = Check.isValidDateComplete(finishDate);
            if (errorCode == 0) {
                this.finishDate = LocalDateTime.parse(finishDate, formatter);
                }
            return errorCode;
        }
        return -15;
    }

    public int setDescription(String description) {
        this.description = description; // preguntar si aqui puedo hacer un optional potrque esta es opcional, lo mismo
                                        // hay lo mismo no
        return 0;
    }

    public int setRef(int ref) {
        if (ref < 1000) {
            return -15;
        }
        if (ref > 1000 && ref < 10000) {
            this.reference = ref;
        }
        return 0;
    }

}
