package com.example.capas.controllers;

import com.example.capas.dto.QueryBooksDto;
import com.example.capas.dto.RegisterBookDto;
import com.example.capas.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books/")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Void> addBook(@RequestBody @Valid RegisterBookDto book) {
        try {
            bookService.createBook(book);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println("Error in BookController.addBook: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/", params = "author")
    public ResponseEntity<List<QueryBooksDto>> getBooksByAuthor(@RequestParam String author) {
        try {
            return ResponseEntity.ok(bookService.getBooksByAuthor(author));
        } catch (Exception e) {
            System.out.println("Error in BookController.getBooksByAuthor: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/", params = "language")
    public ResponseEntity<List<QueryBooksDto>> getBooksByLanguage(@RequestParam String language) {
        try {
            return ResponseEntity.ok(bookService.getBooksByLanguage(language));
        } catch (Exception e) {
            System.out.println("Error in BookController.getBooksByLanguage: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/", params = "genre")
    public ResponseEntity<List<QueryBooksDto>> getBooksByGenre(@RequestParam String genre) {
        try {
            return ResponseEntity.ok(bookService.getBooksByGenre(genre));
        } catch (Exception e) {
            System.out.println("Error in BookController.getBooksByGenre: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<QueryBooksDto> getBookByIsbn(@PathVariable String isbn) {
        try {
            return ResponseEntity.ok(bookService.findBookByIsbn(isbn));
        } catch (Exception e) {
            System.out.println("Error in BookController.getBookByIsbn: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/", params = {"minPages", "maxPages"})
    public ResponseEntity<List<QueryBooksDto>> getBooksByPagesBetween(@RequestParam int minPages, @RequestParam int maxPages) {
        try {
            return ResponseEntity.ok(bookService.getBooksByPagesBetween(minPages, maxPages));
        } catch (Exception e) {
            System.out.println("Error in BookController.getBooksByPagesBetween: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
