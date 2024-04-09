package com.jeancy.library.service;

import com.jeancy.library.model.Member;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeancy
 */
@Service
public interface MemberService {
    
    // to get list of members list
    List<Member> getAllMembers();
    //to save a particular member
    Member saveMember(Member member);
    //getting a member based on provided id
    Member getMemberById(Long id);
    //updating a member from the list
    Member updateMember(Member member);
    //deleting a member based on given id.
    void deleteMemberById(Long id);
}
