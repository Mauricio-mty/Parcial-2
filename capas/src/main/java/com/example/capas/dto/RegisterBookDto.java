package com.example.capas.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterBookDto {
    @NotBlank(message = "Title cannot be blank")
    @NotNull(message = "Title cannot be null")
    @Pattern(regexp = "^[^0-9]*$")
    private String title;

    @NotBlank
    @NotNull
    private String author;

    @NotBlank
    @NotNull
    @Pattern(regexp = "^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)97[89][- ]?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9]$")
    private String isbn;

    @NotNull
    private Integer publicationYear;

    @NotNull
    private String language;

    @NotNull
    @Min(10)
    private Integer pages;

    @NotNull
    @NotBlank
    private String genre;
}
