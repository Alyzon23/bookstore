package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Spring Data JPA proporciona automáticamente los métodos CRUD (Create, Read, Update, Delete)
    // incluyendo findById, findAll, save, deleteById, etc.
    // Puedes añadir métodos de consulta personalizados aquí si los necesitas.
}