package com.jeancy.library.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;
    
    private String title;
   
    // Many books can have the same author (many books to one author).
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private Author author;
    private String isbn;
    private String genre;
    
    @Column(name = "publication_year")
    private int publicationYear;
    
    @Column(name = "availability_status")
    private String availabilityStatus;
    
    // args,non args contructors, toString Getters and setters and will be provided 
    // by lombok project
}
