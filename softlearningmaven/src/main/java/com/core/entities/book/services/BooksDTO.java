package com.core.entities.book.services;

public class BooksDTO {
private final String ident, type, payMethod, date, author, isbn, cover, genre, editorial;
private final double price, discount, weight, height, width, length,volume;
private final boolean delayPay;
private final int page;



    public BooksDTO(String ident,double price ,boolean delayPay,double discount, String type, String payMethod, String date,
                String author, String isbn, String cover, int page, 
                String genre, String editorial, double weight, double height, double width, double length, double volume) {

                    this.ident = ident;
                    this.price = price;
                    this.delayPay = delayPay;
                    this.discount = discount;
                    this.type = type;
                    this.payMethod = payMethod;
                    this.date = date;
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
                    this.volume = volume;
                }
    public String getIdent() {
        return ident;
    }
    public String getType() {
        return type;
    }
    public String getPayMethod() {
        return payMethod;
    }
    public String getDate() {
        return date;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getCover() {
        return cover;
    }
    public String getGenre() {
        return genre;
    }
    public String getEditorial() {
        return editorial;
    }
    public double getPrice() {
        return price;
    }
    public double getDiscount() {
        return discount;
    }
    public double getWeight() {
        return weight;
    }
    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }
    public double getLength() {
        return length;
    }
    public boolean getDelayPay() {
        return delayPay;
    }
    public int getPage() {
        return page;
    }
    public double getVolume() {
        return volume;
    }
    

}