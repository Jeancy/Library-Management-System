package com.jeancy.library.service;

import com.jeancy.library.model.Author;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeancy
 */
@Service
public interface AuthorService {
    // to get list of authors
    List<Author> getAllAuthors();
    //to save an particular author
    Author saveAuthor(Author author);
    //getting an author based on provided id
    Author getAuthorById(Long id);
    //getting an author based on provided book id
    Author getAuthorByBookId(Long id);
    
    //getting an author based on provided book isbn
    Author getAuthorByBookIsbn(String isbn);
    
    //updating an author from the list
    Author updateAuthor(Author author);
    //deleting a author based on given id.
    void deleteAuthorById(Long id);
}
