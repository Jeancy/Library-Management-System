package com.jeancy.library.service;

import com.jeancy.library.model.Book;
import com.jeancy.library.model.Borrowing;
import java.util.List;

/**
 *
 * @author Jeancy
 */
public interface BorrowingService {
    // to get list of borrowings
    List<Borrowing> getAllBorrowings();
    //to save a particular borrowing
    Borrowing saveBorrowing(Borrowing borrowing);
    //getting a borrowing based on provided id
    Borrowing getBorrowingById(Long id);
    //updating a borrowing from the list
    Borrowing updateBorrowing(Borrowing borrowing);
    //deleting a borrowing based on given id.
    void deleteBorrowingById(Long id);
}
