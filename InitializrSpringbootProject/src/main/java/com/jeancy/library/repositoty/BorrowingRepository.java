package com.jeancy.library.repositoty;

import com.jeancy.library.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jeancy
 */
@Repository
public interface BorrowingRepository extends JpaRepository <Borrowing, Long> {
    
}
