package com.jeancy.library.service;

import com.jeancy.library.model.Book;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeancy
 * 
 */

@Service
public interface BookService {
    
    // to get list of books
    List<Book> getAllBooks();
    //to save a particular book
    Book saveBook(Book book);
    //getting a book based on provided id
    Book getBookById(Long id);
    //updating a book from the list
    Book updateBook(Book book);
    //deleting a book based on given id.
    void deleteBookById(Long id);
}
