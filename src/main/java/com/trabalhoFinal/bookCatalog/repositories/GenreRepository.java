package com.trabalhoFinal.bookCatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhoFinal.bookCatalog.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
