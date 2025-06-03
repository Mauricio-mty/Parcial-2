package com.example.capas.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class QueryBooksDto {
    private UUID id;
    private String title;
    private String author;
    private String isbn;
    private Integer publicationYear;
    private String language;
    private Integer pages;
    private String genre;
}
