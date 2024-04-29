
package com.jeancy.library.repositoty;

import com.jeancy.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author  Jeancy
 */
@Repository
public interface AuthorRepository extends JpaRepository <Author, Long>{
         
}
