package Model.Products;

import Model.Operations.Check;



public abstract class Product {
    protected String ident;
    protected Double price;


    

    // Constructor
    public Product(String ident, Double price) throws Exception {
        
        // Clase abstracta checkea sus parámetros
        String errors = "";
        int e;

        // Check del ident
        if((e = Check.minMaxLength(ident)) != 0){  // Pasar 'ident' en lugar de 's' coluciona cositas
            errors += Check.getErrorMessage(e);
        }else{
            this.ident = ident;
        }

        // Check del price
        if((e = Check.validate(price)) != 0){  
            // Llamar a validate para comprovar si es negativo o nulo(es Double con mayúsculas, esos si pueden ser nulos porue son clases)
            errors += Check.getErrorMessage(e);
        }else{
            this.price = price;
        }

        if(errors.length() > 0){
            throw new Exception(errors);  // Mantener la excepción si hay errores
        }

        //creo que jose dira en un futuro que quiere tener diferentes clases de trow exception
        // de momento dejar asi
        
    }

    public String getIdent() {
        return ident;
    }

    public Double getPrice() {
        return price;
    }

    




}
