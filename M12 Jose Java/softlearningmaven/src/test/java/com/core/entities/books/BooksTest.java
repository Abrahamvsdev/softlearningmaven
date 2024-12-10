package com.core.entities.books;
import com.core.entities.book.model.Books;
import com.core.entities.book.services.BooksDTO;
import com.core.entities.book.services.BooksMapper;
import com.core.entities.exceptions.BuildException;
import com.core.entities.exceptions.ServiceException;


public class BooksTest {
    public static void main(String[] args) throws Exception, BuildException, ServiceException {
        //ejemplo de serializacion
        
        Books b;
        b = Books.getInstance(
            "1234",
            10.0,
            true,
            0.0,
            "type",
            "payMethod",
            "2023/11/02-10:00:10",
            "author",
            "isbn",
            "cover",
            10,
            "genre",
            "editorial",
            10.0,
            10.0,
            10.0,
            true,
            10.0
        );
        System.out.println(b.getDetails());

        //Mapper
        BooksDTO bdto = BooksMapper.dtoFromBooks(b);
        System.out.println("Autor: " + bdto.getAuthor());

        Books bcopy = BooksMapper.booksFromDTO(bdto);
        System.out.println("Mapper Book: " + bcopy.getDetails());
    



    }
}
