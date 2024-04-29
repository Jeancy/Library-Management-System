package com.jeancy.library.controller;

import com.jeancy.library.model.Book;
import com.jeancy.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jeancy
 */

@Controller
public class BookController {
    
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @RequestMapping(value="/books", method=RequestMethod.GET)
    public String listBooks (Model model){
        // the model object is going to add books attribute to display as the html view.
        model.addAttribute("books", bookService.getAllBooks());
        // a html string which will be displayed on the web browser.
        return "/books";
    }
    
    // The method will dispaly a form in which the new book detail will be captured.
    @RequestMapping(value="/books/new", method=RequestMethod.GET)
    public String createBookForm(Model model){
        Book newBook = new Book();
        // We are going to add the new book details to the html view books
        model.addAttribute("book", newBook);
        return "/create_book";
    }
    
    //Handler method to save new added book to the table and display it in the table.
    @RequestMapping(value="/books", method=RequestMethod.POST)
    // For MVC we use @ModelAttribute annotation and for a norma restful api @RequestBody
    public String saveBook(@ModelAttribute("book") Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }
    
    //Create a handler method edit book with given id details and display it in the table
    @RequestMapping(value="/books/edit/{id}", method=RequestMethod.GET)
    public String editBookForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", bookService.getBookById(id));
        return "/edit_book";
    }
    
    // Create handler method to update book details after editing.
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.POST)
    public String updateBook(@PathVariable Long id, @ModelAttribute("book") Book book,
                                Model model){
        //get first book from the database
        Book existingBook = bookService.getBookById(id);
        // doing the actual update.
        existingBook.setBookId(id);
        existingBook.setAuthorName(book.getAuthorName());
        existingBook.setAvailabilityStatus(book.getAvailabilityStatus());
        existingBook.setGenre(book.getGenre());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setPublicationYear(book.getPublicationYear());
        existingBook.setTitle(book.getTitle());
        // Save updated book.
        bookService.updateBook(existingBook);
        return "redirect:/books";
    }
    
    //Create handler method to handle delete book request.
    @RequestMapping(value="/books/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
        return "redirect:/books";
    }
    
}
