package com.microboot.bookstore.bookcatalog.mapper;

import org.springframework.stereotype.Component;

import com.microboot.bookstore.bookcatalog.dto.Book;
import com.microboot.bookstore.bookcatalog.model.BooksResponse;

@Component
public class BookResponseMapper {


    public BooksResponse mapToResponse(Book book) {
        return new BooksResponse.Builder()
                .id(book.getId())
                .title(book.getTitle())
                .authorName(book.getAuthor().getName())
                .description(book.getDescription())
                .price(book.getPrice())
                .rating(book.getRating())
                .genre(book.getGenre())
                .build();
    }
}
