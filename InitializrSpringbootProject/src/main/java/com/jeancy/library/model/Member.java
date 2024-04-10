package com.jeancy.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    //  accessing all the borrowing transactions associated with a member 
    // Each Borrowing object in the set represents a book borrowed by that member.
    @OneToMany(mappedBy = "member")
    private Set<Borrowing> borrowings;

    // Getters and setters provided by lombok
}
