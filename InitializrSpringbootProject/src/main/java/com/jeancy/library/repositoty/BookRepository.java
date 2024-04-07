package com.jeancy.library.repositoty;

import com.jeancy.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author  Jeancy
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    
}
