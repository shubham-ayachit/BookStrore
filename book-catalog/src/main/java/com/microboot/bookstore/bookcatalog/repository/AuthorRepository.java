package com.microboot.bookstore.bookcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microboot.bookstore.bookcatalog.dto.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);
}
