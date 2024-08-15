package com.microboot.bookstore.bookcatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.microboot.bookstore.bookcatalog.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CatalogController {

    @Autowired
    private BookService bookService;

    @GetMapping("/catalog")
    public ResponseEntity<?> getCatalog(@RequestParam(name = "authorName", required = false) String authorName,
                                        @RequestParam(name = "genre", required = false) String genre,
                                        @RequestParam(name = "ratingGreaterThan", required = false) Float ratingGreaterThan) {
        if (authorName != null) {
            return ResponseEntity.ok(bookService.getBooksByAuthor(authorName));
        } else if (genre != null) {
            return ResponseEntity.ok(bookService.getBooksByGenre(genre));
        } else if (ratingGreaterThan != null) {
            return ResponseEntity.ok(bookService.getBooksByRating(ratingGreaterThan));
        } else {
            return ResponseEntity.ok(bookService.getAllBooks());
        }
    }
    
}
