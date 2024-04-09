package com.jeancy.library.serviceimpl;

import com.jeancy.library.model.Book;
import com.jeancy.library.repositoty.BookRepository;
import com.jeancy.library.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeancy
 */
@Service
public class BookServiceImpl implements BookService {
    
    private final BookRepository bookRepo;
    
    @Autowired
    public BookServiceImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }
      
    @Override
    public List<Book> getAllBooks() {
       return bookRepo.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepo.findById(id).get();
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepo.deleteById(id);
    }
    
}
