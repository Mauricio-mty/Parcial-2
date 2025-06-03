package com.example.capas.services;

import com.example.capas.dto.QueryBooksDto;
import com.example.capas.dto.RegisterBookDto;
import com.example.capas.models.Book;
import com.example.capas.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void createBook(RegisterBookDto book) {
        if (findBookByIsbn(book.getIsbn()) != null) {
            throw new IllegalArgumentException("ISBN already exists");
        }

        Book newBook = new Book();
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(book.getAuthor());
        newBook.setIsbn(book.getIsbn());
        newBook.setPublicationYear(book.getPublicationYear());
        newBook.setLanguage(book.getLanguage());
        newBook.setPages(book.getPages());
        newBook.setLanguage(book.getLanguage());
        newBook.setGenre(book.getGenre());

        bookRepository.save(newBook);
    }

    public QueryBooksDto findBookByIsbn(String isbn) {
        Optional<Book> book = bookRepository.findByIsbn(isbn);
        return book.map(this::buildQueryBooksDto).orElse(null);
    }

    public List<QueryBooksDto> getBooksByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        List<QueryBooksDto> resultBooks = new ArrayList<>();
        books.forEach(book -> {
            resultBooks.add(buildQueryBooksDto(book));
        });
        return resultBooks;
    }

    public List<QueryBooksDto> getBooksByGenre(String genre) {
        List<Book> books = bookRepository.findByGenre(genre);
        List<QueryBooksDto> resultBooks = new ArrayList<>();
        books.forEach(book -> {
            resultBooks.add(buildQueryBooksDto(book));
        });
        return resultBooks;
    }

    public List<QueryBooksDto> getBooksByLanguage(String language) {
        List<Book> books = bookRepository.findByLanguage(language);
        List<QueryBooksDto> resultBooks = new ArrayList<>();
        books.forEach(book -> {
            resultBooks.add(buildQueryBooksDto(book));
        });
        return resultBooks;
    }

    public List<QueryBooksDto> getBooksByPagesBetween(int start, int end) {
        List<Book> books = bookRepository.findByPagesBetween(start, end);
        List<QueryBooksDto> resultBooks = new ArrayList<>();
        books.forEach(book -> {
            resultBooks.add(buildQueryBooksDto(book));
        });
        return resultBooks;
    }

    private QueryBooksDto buildQueryBooksDto(Book book) {
        QueryBooksDto queryBooksDto = new QueryBooksDto();
        queryBooksDto.setId(book.getId());
        queryBooksDto.setTitle(book.getTitle());
        queryBooksDto.setAuthor(book.getAuthor());
        queryBooksDto.setIsbn(book.getIsbn());
        queryBooksDto.setPublicationYear(book.getPublicationYear());
        queryBooksDto.setLanguage(book.getLanguage());
        queryBooksDto.setPages(book.getPages());
        queryBooksDto.setGenre(book.getGenre());
        return queryBooksDto;
    }
}
