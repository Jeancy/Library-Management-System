package com.jeancy.library.controller;

import com.jeancy.library.model.Member;
import com.jeancy.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jeancy
 */
@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    
    @RequestMapping(value="/members", method=RequestMethod.GET)
    public String listMembers (Model model){
        // the model object is going to add members attribute to display as the html view.
        model.addAttribute("members", memberService.getAllMembers());
        // a html string which will be displayed on the web browser.
        return "/members";
    }
    
    // The method will dispaly a form in which the new memeber details will be captured.
    @RequestMapping(value="/members/new", method=RequestMethod.GET)
    public String createMemberForm(Model model){
        Member newMember = new Member();
        // We are going to add the new member details to the html view books
        model.addAttribute("member", newMember);
        return "/create_member";
    }
    
    //Handler method to save new added member to the table and display it in the table.
    @RequestMapping(value="/members", method=RequestMethod.POST)
    // For MVC we use @ModelAttribute annotation and for a normal restful api @RequestBody
    public String saveMember(@ModelAttribute("member") Member member){
        memberService.saveMember(member);
        return "redirect:/members";
    }
    
    //Create a handler method edit member with given id details and display it in the table
    @RequestMapping(value="/members/edit/{id}", method=RequestMethod.GET)
    public String editMemberForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("member", memberService.getMemberById(id));
        return "/edit_member";
    }
    
    // Create handler method to update member details after editing.
    
    @RequestMapping(value="/members/{id}", method=RequestMethod.POST)
    public String updateMember(@PathVariable Long id, @ModelAttribute("member") Member member,
                                Model model){
        //get first member from the database
        Member existingMember = memberService.getMemberById(id);
        // doing the actual update.
        existingMember.setMemberId(id);
        existingMember.setName(member.getName());
        existingMember.setEmail(member.getEmail());
        existingMember.setAddress(member.getAddress());
        existingMember.setPhoneNumber(member.getPhoneNumber());
        existingMember.setBorrowings(member.getBorrowings());
       
        return "redirect:/members";
    }
}
