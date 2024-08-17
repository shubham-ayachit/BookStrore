package com.microboot.bookstore.bookcatalog.service.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.microboot.bookstore.bookcatalog.dto.Author;
import com.microboot.bookstore.bookcatalog.dto.Book;
import com.microboot.bookstore.bookcatalog.mapper.BookResponseMapper;
import com.microboot.bookstore.bookcatalog.model.BooksResponse;

public class BookServiceHelperTest {

    // @InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    private BookServiceHelper bookServiceHelper;

    // @Mock annotation is used to create the mock object to be injected
    @Mock
    private BookResponseMapper bookResponseMapper;

    // @BeforeEach annotation is used on a method containing the code to run before each test case
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // @Test annotation is used to signal that the annotated method is a test method
    // public void testMapToResponse() is the method to test the mapToResponse method in BookServiceHelper
    @Test
    public void testMapToResponse() {
        // Create an Author object
        Author author = new Author();
        author.setName("Author Name");

        // Create a Book object
        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Book Title");
        book1.setAuthor(author);
        book1.setDescription("Book Description");
        book1.setPrice(10.0);
        book1.setRating(5.0);
        book1.setGenre("Book Genre");

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Book Title 2");
        book2.setAuthor(author);
        book2.setDescription("Book Description 2");
        book2.setPrice(20.0);
        book2.setRating(4.0);
        book2.setGenre("Book Genre 2");

        // Create a BooksResponse object
        BooksResponse booksResponse1 = new BooksResponse.Builder()
                .id(book1.getId())
                .title(book1.getTitle())
                .authorName(book1.getAuthor().getName())
                .description(book1.getDescription())
                .price(book1.getPrice())
                .rating(book1.getRating())
                .genre(book1.getGenre())
                .build();

        // Create a BooksResponse object
        BooksResponse booksResponse2 = new BooksResponse.Builder()
                .id(book2.getId())
                .title(book2.getTitle())
                .authorName(book2.getAuthor().getName())
                .description(book2.getDescription())
                .price(book2.getPrice())
                .rating(book2.getRating())
                .genre(book2.getGenre())
                .build();

        // when() is used to configure the mock object
        when(bookResponseMapper.mapToResponse(book1)).thenReturn(booksResponse1);
        when(bookResponseMapper.mapToResponse(book2)).thenReturn(booksResponse2);

        // Create a List of Book objects
        List<Book> books = Arrays.asList(book1, book2);
        // Call the mapToResponse method in BookServiceHelper
        List<BooksResponse> booksResponse = bookServiceHelper.mapToResponse(books);

        // assertEquals() is used to check if the two objects match
        assertEquals(booksResponse.size(), 2);
        assertEquals(booksResponse.get(0), booksResponse1);
        assertEquals(booksResponse.get(1), booksResponse2);
    }

}
