package com.microboot.bookstore.bookcatalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microboot.bookstore.bookcatalog.dto.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorId(Long authorId);
    List<Book> findByGenre(String genre);
    List<Book> findByRating(int rating);
    List<Book> findByRatingGreaterThanEqual(float rating);
}
