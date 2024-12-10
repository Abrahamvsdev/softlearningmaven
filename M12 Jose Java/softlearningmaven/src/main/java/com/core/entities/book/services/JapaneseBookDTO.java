package com.core.entities.book.services;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "本")

public class JapaneseBookDTO {

    private String ident, type, payMethod, date, author, isbn, cover, genre, editorial;
    private double price, discount, weight, height, width, length,volume;
    private boolean delayPay,fragile;
    private int page;
    public JapaneseBookDTO(){};

    public JapaneseBookDTO(String ident,double price ,boolean delayPay,double discount, String type, String payMethod, String date,
                String author, String isbn, String cover, int page, 
                String genre, String editorial, double weight, double height, double width, boolean fragile, double length, double volume) {

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
                    this.fragile = fragile;
                    this.length = length;
                    this.volume = volume;
                }

    @JsonGetter("識別")
    public String getIdent() {
        return ident;
    }

    @JsonGetter("種類")
    public String getType() {
        return type;
    }

    @JsonGetter("支払方法")
    public String getPayMethod() {
        return payMethod;
    }

    @JsonGetter("日付")
    public String getDate() {
        return date;
    }

    @JsonGetter("著者")
    public String getAuthor() {
        return author;
    }

    @JsonGetter("isbn")
    public String getIsbn() {
        return isbn;
    }

    @JsonGetter("表紙")
    public String getCover() {
        return cover;
    }

    @JsonGetter("ジャンル")
    public String getGenre() {
        return genre;
    }

    @JsonGetter("編集")
    public String getEditorial() {
        return editorial;
    }

    @JsonGetter("価格")
    public double getPrice() {
        return price;
    }

    @JsonGetter("割引")
    public double getDiscount() {
        return discount;
    }

    @JsonGetter("重量")
    public double getWeight() {
        return weight;
    }

    @JsonGetter("高さ")
    public double getHeight() {
        return height;
    }

    @JsonGetter("幅")
    public double getWidth() {
        return width;
    }

    @JsonGetter("壊れやすい")
    public boolean getFragile() {
        return fragile;
    }

    @JsonGetter("長さ")
    public double getLength() {
        return length;
    }

    @JsonGetter("ボリューム")
    public double getVolume() {
        return volume;
    }

    @JsonGetter("支払遅延")
    public boolean getDelayPay() {
        return delayPay;
    }

    @JsonGetter("ページ")
    public int getPage() {
        return page;
    }

    //setters

    @JsonSetter("識別")
    public void setIdent(String ident) {
        //this.ident = ident;
    }

    @JsonSetter("種類")
    public void setType(String type) {
        //this.type = type;
    }

    @JsonSetter("支払方法")
    public void setPayMethod(String payMethod) {
        //this.payMethod = payMethod;
    }
    
    @JsonSetter("日付")
    public void setDate(String date) {
        //this.date = date;
    }
    
    @JsonSetter("著者")
    public void setAuthor(String author) {
        //this.author = author;
    }

    @JsonSetter("isbn")
    public void setIsbn(String isbn) {
        //this.isbn = isbn;
    }

    @JsonSetter("表紙")
    public void setCover(String cover) {
        //this.cover = cover;
    }

    @JsonSetter("ジャンル")
    public void setGenre(String genre) {
        //this.genre = genre;
    }

    @JsonSetter("編集")
    public void setEditorial(String editorial) {
        //this.editorial = editorial;
    }

    @JsonSetter("価格")
    public void setPrice(double price) {
        //this.price = price;
    }

    @JsonSetter("割引")
    public void setDiscount(double discount) {
        //this.discount = discount;
    }

    @JsonSetter("重量")
    public void setWeight(double weight) {
        //this.weight = weight;
    }

    @JsonSetter("高さ")
    public void setHeight(double height) {
        //this.height = height;
    }

    @JsonSetter("幅")
    public void setWidth(double width) {
        //this.width = width;
    }

    @JsonSetter("壊れやすい")
    public void setFragile(boolean fragile) {
        //this.fragile = fragile;
    }

    @JsonSetter("長さ")
    public void setLength(double length) {
        //this.length = length;
    }

    @JsonSetter("ボリューム")
    public void setVolume(double volume) {
        //this.volume = volume;
    }

    @JsonSetter("支払遅延")
    public void setDelayPay(boolean delayPay) {
        //this.delayPay = delayPay;
    }

    @JsonSetter("ページ")
    public void setPage(int page) {
        //this.page = page;
    }

    
    


}
