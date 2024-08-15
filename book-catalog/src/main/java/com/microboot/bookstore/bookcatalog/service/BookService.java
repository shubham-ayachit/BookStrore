package com.microboot.bookstore.bookcatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microboot.bookstore.bookcatalog.dto.Book;
import com.microboot.bookstore.bookcatalog.model.BooksResponse;
import com.microboot.bookstore.bookcatalog.repository.AuthorRepository;
import com.microboot.bookstore.bookcatalog.repository.BookRepository;
import com.microboot.bookstore.bookcatalog.service.helper.BookServiceHelper;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookServiceHelper bookServiceHelper;

    public List<BooksResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookServiceHelper.mapToResponse(books);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getBooksByAuthor(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    public List<BooksResponse> getBooksByAuthor(String authorName) {
        Long authorId = authorRepository.findByName(authorName).getId();
        List<Book> byAuthorId = bookRepository.findByAuthorId(authorId);
        return bookServiceHelper.mapToResponse(byAuthorId);
    }

    public List<BooksResponse> getBooksByGenre(String genre) {
        return bookServiceHelper.mapToResponse(bookRepository.findByGenre(genre));
    }

    public List<BooksResponse> getBooksByRating(float ratingGreaterThan) {
        return bookServiceHelper.mapToResponse(bookRepository.findByRatingGreaterThanEqual(ratingGreaterThan));
    }
}
