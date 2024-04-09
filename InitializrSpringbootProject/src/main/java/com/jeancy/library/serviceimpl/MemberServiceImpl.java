package com.jeancy.library.serviceimpl;

import com.jeancy.library.model.Member;
import com.jeancy.library.repositoty.MemberRepository;
import com.jeancy.library.service.MemberService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeancy
 */
@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepo;

    public MemberServiceImpl(MemberRepository memberRepo) {
        this.memberRepo = memberRepo;
    }
       
    @Override
    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepo.save(member);
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepo.findById(id).get();
    }

    @Override
    public Member updateMember(Member member) {
        return memberRepo.save(member);
    }

    @Override
    public void deleteMemberById(Long id) {
        memberRepo.deleteById(id);
    }
    
}
