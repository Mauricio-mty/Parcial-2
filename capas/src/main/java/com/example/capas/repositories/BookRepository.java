package com.example.capas.repositories;

import com.example.capas.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    Optional<Book> findByIsbn(String isbn);

    List<Book> findByAuthor(String author);

    List<Book> findByLanguage(String language);

    List<Book> findByGenre(String genre);

    List<Book> findByPagesBetween(Integer pagesAfter, Integer pagesBefore);
}
