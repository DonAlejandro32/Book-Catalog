package com.trabalhoFinal.bookCatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhoFinal.bookCatalog.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
