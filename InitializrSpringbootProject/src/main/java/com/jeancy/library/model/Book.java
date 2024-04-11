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
    
    @Column(name = "title")
    private String title;
   
    // Many books can have the same author (many books to one author).
//    @ManyToOne
//    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
//    private Author author;
    
    @Column(name = "author_name")
    private String authorName;
    
   @Column(name = "isbn")
    private String isbn;
   
    @Column(name = "length")
    private int length;
   
    @Column(name = "genre")
    private String genre;
    
    @Column(name = "publication_year")
    private int publicationYear;
    
    @Column(name = "availability_status")
    private String availabilityStatus;
    // Book contructor excluding id as it will be created automatically.

    public Book() {
    }
    
    public Book(String title, String authorName, int length,String isbn, String genre,
                int publicationYear, String availabilityStatus) {
        this.title = title;
        this.authorName = authorName;
        this.length = length;
        this.isbn = isbn;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.availabilityStatus = availabilityStatus;
    }
    // args,non args contructors, toString Getters and setters and will be provided 
    // by lombok project
}
