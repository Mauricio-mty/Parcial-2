package com.example.capas.controllers;

import com.example.capas.dto.RegisterBookDto;
import com.example.capas.models.Book;
import com.example.capas.repositories.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public void addBook(@RequestBody @Valid RegisterBookDto book) {
        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
    }
}
