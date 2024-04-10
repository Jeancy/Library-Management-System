package com.jeancy.library.controller;

import com.jeancy.library.model.Author;
import com.jeancy.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jeancy
 */
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public  AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    
    @RequestMapping(value="/authors", method=RequestMethod.GET)
    public String listAuthors (Model model){
        // the model object is going to add authors attribute to display as the html view.
        model.addAttribute("authors", authorService.getAllAuthors());
        // a html string which will be displayed on the web browser.
        return "/authors";
    }
    
    // The method will dispaly a form in which the new author detail will be captured.
    @RequestMapping(value="/authors/new", method=RequestMethod.GET)
    public String createAuthorForm(Model model){
        Author newAuthor = new Author();
        // We are going to add the new author details to the html view books
        model.addAttribute("author", newAuthor);
        return "/create_author";
    }
    
    //Handler method to save new added author to the table and display it in the table.
    @RequestMapping(value="/authors", method=RequestMethod.POST)
    // For MVC we use @ModelAttribute annotation and for a normal restful api @RequestBody
    public String saveAuthor(@ModelAttribute("author") Author author){
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }
    
    //Create a handler method edit author with given id details and display it in the table
    @RequestMapping(value="/authors/edit/{id}", method=RequestMethod.GET)
    public String editAuthorForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("author", authorService.getAuthorById(id));
        return "/edit_author";
    }
    
    // Create handler method to update author details after editing.
    
    @RequestMapping(value="/authors/{id}", method=RequestMethod.POST)
    public String updateAuthor(@PathVariable Long id, @ModelAttribute("author") Author author,
                                Model model){
        //get first book from the database
        Author existingAuthor = authorService.getAuthorById(id);
        // doing the actual update.
        existingAuthor.setAuthorId(id);
        existingAuthor.setName(author.getName());
        existingAuthor.setNationality(author.getNationality());
        existingAuthor.setBirthDate(author.getBirthDate());
       existingAuthor.setBiography(author.getBiography());
       
        // Save updated author.
        authorService.updateAuthor(existingAuthor);
        return "redirect:/authors";
    }
    
    //Create handler method to handle delete author request.  
    @RequestMapping(value="/authors/{id}", method=RequestMethod.GET)
    public String deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthorById(id);
        return "redirect:/authors";
    }
    
}
