package Model.Products;

import Model.Operations.Check;
import java.util.Date; // Import Date class

public class Books {

    protected Date dateTime; // esto hay que acabarlo, tanto el cheker, como la clase, como el test
    protected String author;
    protected String isbn;
    protected String cover;
    protected String page;
    protected String genre;
    protected String editorial;
    protected float weight; // del dimensions
    protected float height; // del dimensions
    protected float width;  // del dimensions
    protected float length; // del dimensions
    protected String ident; // de Product preguntar poque esta no canta siendo que es de la abstracta
    protected float price;   //de Product preguntar poque esta no canta siendo que es de la abstracta

    // Constructor, recordar que deben ir por orden, preguntar a jose o buscar en la docu 
    //el tema de las dimensions y la clase super
    public Books(Date dateTime, String author, String isbn, String cover, String page, String genre, String editorial,
                float weight, float height, float width, float length, String ident, float price) throws Exception {
        
        // inicio aqui, defiendo en los setters abajo
        this.dateTime = dateTime;
        this.author = author;
        this.isbn = isbn;
        this.cover = cover;
        this.page = page;
        this.genre = genre;
        this.editorial = editorial;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
        this.ident = ident;
        this.price = price;
    }

    // revisar si me dejo algun checker

    public Date getDateTime() {
        return dateTime;
    }
    //preguntar jose
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getAuthor() {
        return author;
    }

    public int setAuthor(String author) {
        int errorAuthor = Check.minMaxLength(author);
        if (errorAuthor == 0) {
            this.author = author;
        }
        return errorAuthor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        String errorIsbn= Check.
        this.isbn = isbn;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}


