package com.example.capas.services;

import com.example.capas.dto.RegisterBookDto;
import com.example.capas.models.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {



    public void createBook(RegisterBookDto book) {
        if(isbnExist(book.getIsbn())) {
            throw new IllegalArgumentException("Isbn already exists");
        }

        Book newBook = new Book();
        book.setTitle(book.getTitle());
        book.setAuthor(book.getAuthor());
        book.setIsbn(book.getIsbn());
        book.setPublicationYear(book.getPublicationYear());
        book.setLanguage(book.getLanguage());
        book.setPages(book.getPages());
        book.setLanguage(book.getLanguage());


    }

    private Boolean isbnExist(String isbn) {
        return false;
    }
}
