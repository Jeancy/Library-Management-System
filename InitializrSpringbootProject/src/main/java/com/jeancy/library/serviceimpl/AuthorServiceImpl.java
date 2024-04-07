package com.jeancy.library.serviceimpl;

import com.jeancy.library.model.Author;
import com.jeancy.library.repositoty.AuthorRepository;
import com.jeancy.library.service.AuthorService;
import java.util.List;


public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepo;

    public AuthorServiceImpl(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }
    
    
    @Override
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepo.findById(id).get();
    }

    @Override
    public Author getAuthorByBookId(Long id) {
        return authorRepo.findAuthorByBookId(id);
    }

    @Override
    public Author getAuthorByBookIsbn(String isbn) {
        return authorRepo.findAuthorByIsbn(isbn);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public void deleteAuthorById(Long id) {
        authorRepo.deleteById(id);
    }
    
}
