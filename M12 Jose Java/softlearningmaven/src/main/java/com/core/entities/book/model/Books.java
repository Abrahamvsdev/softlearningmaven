package com.core.entities.book.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.core.checks.Check;
import com.core.entities.shared.dimensions.Dimensions;
import com.core.entities.shared.products.Product;
import com.core.entities.shared.storable.Storable;


public class Books extends Product implements Storable {
    
    protected LocalDate date;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    protected String author;
    protected String isbn;
    protected String cover;
    protected int page;
    protected String genre;
    protected String editorial;
    protected Dimensions dim;
    protected boolean fragile;
    
    protected Books(){
    
    }
    
    public static Books getInstance(
        String ident, 
        double price,
        boolean delayPay, 
        double discount, 
        String type, 
        String payMethod, 
        String date, 
        String author, 
        String isbn, 
        String cover, 
        int page, 
        String genre, 
        String editorial, 
        double weight, 
        double height, 
        double width, 
        boolean fragile, 
        double length) throws Exception {
        
        StringBuilder errors = new StringBuilder();
        int errorCode;
        Books libro1 = new Books();
        try {
            libro1.dim = Dimensions.getInstanceDimensions(weight, height, width, fragile, length); 
        } catch (Exception e) {
            throw new Exception("Error en las dimensiones: " + e.getMessage()); 
        }
        
        try {
            libro1.product(ident, price, delayPay, discount, type, payMethod);
            
        } catch (Exception ex) {
            throw new Exception("Error en product: " + ex.getMessage());
        }

        
        if ((errorCode = libro1.setDate(date)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        if ((errorCode = libro1.setAuthor(author)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        if ((errorCode = libro1.setIsbn(isbn)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        if ((errorCode = libro1.setCover(cover)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        if ((errorCode = libro1.setPage(page)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        if ((errorCode = libro1.setGenre(genre)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }
        if ((errorCode = libro1.setEditorial(editorial)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        
        if (errors.length() > 0) {
            throw new Exception("No es posible crear el libro: \n" + errors.toString());

        }
        return libro1;
    }
    

    


    // getter
    public String getAuthor() {
        return this.author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public String getCover() {
        return this.cover;
    }

    public int getPage() {
        return this.page;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getDate() {
        return this.date.format(formatter);
    }

    public String getEditorial() {
        return this.editorial;
    }

    public Dimensions getDim() {
        return this.dim;
    }

    public double getWeight(){
        return dim.getWeight();
    }
    public double getHeight() {
        return dim.getHeight();
    }
    
    public double getWidth() {
        return dim.getWidth();
    }
    
    public boolean getFragile() {
        return this.fragile;
    }

    public double getLength() {
        return dim.getLength();
    }
    public double getVolume() {
        return dim.getLength() * dim.getWidth() * dim.getHeight();
    }


    

    // setter
    public int setAuthor(String author) {
        int errorAuthor = Check.minMaxLength(author);
        if (errorAuthor == 0) {
            this.author = author;
        }
        return errorAuthor;
    }

    public int setDate(String date) {
        int errorDate = Check.isValidDate(date);  // Usamos isValidDate para validar
        
        if (errorDate == 0) {
            // Si es valida, la analizamos y asignamos
            this.date = LocalDate.parse(date, this.formatter);
        }
        
        return errorDate;
    }



//     public int setDate(String date) {
//         int errorDate = Check.isValidDate(date);
//         if (errorDate == 0) {
//             this.date = LocalDate.parse(date, formatter);
//         }
//         return errorDate;
// }
    

    public int setIsbn(String isbn) {
        int errorIsbn = Check.checkISBN(isbn);
        if (errorIsbn == 0) {
            this.isbn = isbn;
        }
        return errorIsbn;
    }

    public int setCover(String cover) {
        int errorCover = Check.minMaxLength(cover);
        if (errorCover == 0) {
            this.cover = cover;
        }
        return errorCover;
    }

    public int setPage(int page) {
        int errorPage = Check.range(page);
        if (errorPage == 0) {
            this.page = page;
        }
        return errorPage;
    }

    public int setGenre(String genre) {
        int errorGenre = Check.minLenght(genre);
        if (errorGenre == 0) {
            this.genre = genre;
        }
        return errorGenre;
    }

    public int setEditorial(String editorial) {
        int errorEditorial = Check.minLenght(editorial);
        if (errorEditorial == 0) {
            this.editorial = editorial;
        }
        return errorEditorial;
    }

    

    public void setDim(Dimensions dim) {
        this.dim = dim;
    }
    
    

    
    @Override
    public double volume() {
        return this.dim.getVolume();
    }

    @Override
    public String getDetails() {
        return "ID: " + this.getIdent() + "\n" +
                "Precio: $" + this.getPrice() + "\n" +
                "Autor: " + this.getAuthor() + "\n" +
                "ISBN: " + this.getIsbn() + "\n" +
                "Tapa: " + this.getCover() + "\n" +
                "Paginas: " + this.getPage() + "\n" +
                "Género: " + this.getGenre() + "\n" +
                "Editorial: " + this.getEditorial() + "\n" +
                "Fecha: " + this.getDate() + "\n" +
                "Dimensiones (AxAxL): " + this.getDim().getWidth() + "x" + this.getDim().getHeight() + "x" + this.getDim().getLength() + " cm\n" +
                "Peso: " + this.getDim().getWeight() + " kg\n";
    }

    @Override
    public boolean isFlexible() {
        return false; 
    }

    @Override
    public boolean isHeavy() {
        return this.dim.getWeight() > 1.0 ? true:false; //si pesa mas de 1kg
    }

    
}
