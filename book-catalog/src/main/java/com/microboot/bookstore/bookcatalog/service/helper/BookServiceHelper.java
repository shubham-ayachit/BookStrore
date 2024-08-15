package com.microboot.bookstore.bookcatalog.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microboot.bookstore.bookcatalog.dto.Book;
import com.microboot.bookstore.bookcatalog.mapper.BookResponseMapper;
import com.microboot.bookstore.bookcatalog.model.BooksResponse;

import java.util.List;
import java.util.ArrayList;

@Component
public class BookServiceHelper {

    @Autowired
    private BookResponseMapper bookResponseMapper;

    public List<BooksResponse> mapToResponse(List<Book> books) {
        List<BooksResponse> booksResponse = new ArrayList<>();
        books.forEach(book -> booksResponse.add(bookResponseMapper.mapToResponse(book)));
        return booksResponse;
    }
}
