package com.jeancy.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "birth_date")
    private LocalDate birthDate;
    
    @Column(name = "nationality")
    private String nationality;
    
    @Column(name = "biography")
    private String biography;

    // Getters and setters provided by lombok 
}
