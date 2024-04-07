
package com.jeancy.library.repositoty;

import com.jeancy.library.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jeancy
 */
@Repository
public interface MemberRepository extends JpaRepository <Member, Long>{
    
}
