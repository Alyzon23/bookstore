package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Marca esta clase como una entidad JPA
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura la generación automática del ID
    private Long id;
    private String title;
    private String genre;
    private String description;
    private String author;
    private Integer publicationYear;

    // Constructor por defecto (necesario para Jackson y JPA)
    public Book() {
    }

    // Constructor con todos los campos (excepto el ID, que se genera automáticamente)
    public Book(String title, String genre, String description, String author, Integer publicationYear) {
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // Getters y setters para todos los campos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }
}