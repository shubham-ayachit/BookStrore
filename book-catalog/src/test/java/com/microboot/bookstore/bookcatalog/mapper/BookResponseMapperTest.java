package com.microboot.bookstore.bookcatalog.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.microboot.bookstore.bookcatalog.dto.Author;
import com.microboot.bookstore.bookcatalog.dto.Book;
import com.microboot.bookstore.bookcatalog.model.BooksResponse;

public class BookResponseMapperTest {

    private BookResponseMapper bookResponseMapper;

    // @BeforeEach annotation is used on a method containing the code to run before each test case
    @BeforeEach
    public void setUp() {
        bookResponseMapper = new BookResponseMapper();
    }

    // @Test annotation is used to signal that the annotated method is a test method
    // public void testMapToResponse() is the method to test the mapToResponse method in BookResponseMapper
    @Test
    public void testMapToResponse() {
        // Create an Author object
        Author author = new Author();
        author.setName("Author Name");

        // Create a Book object
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Book Title");
        book.setAuthor(author);
        book.setDescription("Book Description");
        book.setPrice(10.0);
        book.setRating(5.0);
        book.setGenre("Book Genre");

        // Call the mapToResponse method in BookResponseMapper
        BooksResponse booksResponse = bookResponseMapper.mapToResponse(book);

        // Test the values of the booksResponse object
        assertEquals(1L, booksResponse.getId());
        assertEquals("Book Title", booksResponse.getTitle());
        assertEquals("Author Name", booksResponse.getAuthorName());
        assertEquals("Book Description", booksResponse.getDescription());
        assertEquals(10.0, booksResponse.getPrice());
        assertEquals(5.0, booksResponse.getRating());
        assertEquals("Book Genre", booksResponse.getGenre());

    }

}
