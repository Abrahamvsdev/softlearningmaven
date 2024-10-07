package com.core.entities.book.services;
import com.core.entities.book.model.Books;


public class BooksMapper {
    public static Books booksFromDTO(BooksDTO bdto) throws Exception{
        return Books.getInstance(bdto.getIdent(),
                                bdto.getPrice(),
                                bdto.getDelayPay(),
                                bdto.getDiscount(),
                                bdto.getType(),
                                bdto.getPayMethod(),
                                bdto.getDate(),
                                bdto.getAuthor(),
                                bdto.getIsbn(),
                                bdto.getCover(),
                                bdto.getPage(),
                                bdto.getGenre(),
                                bdto.getEditorial(),
                                bdto.getWeight(),
                                bdto.getHeight(),
                                bdto.getWidth(),
                                bdto.getLength());
    }

    public static BooksDTO dtoFromBooks(Books b){

        return new BooksDTO(
        
                                b.getIdent(),
                                b.getPrice(),
                                b.getDelayPay(),
                                b.getDiscount(),
                                b.getType(),
                                b.getPayMethod(),
                                b.getDate(),
                                b.getAuthor(),
                                b.getIsbn(),
                                b.getCover(),
                                b.getPage(),
                                b.getGenre(),
                                b.getEditorial(),
                                b.getWeight(),
                                b.getHeight(),
                                b.getWidth(),
                                b.getLength(),
                                b.getVolume()
                                );
    }

}
