package com.jeancy.library.controller;

import com.jeancy.library.model.Member;
import com.jeancy.library.repositoty.MemberRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Jeancy
 */
public class LoginController {
    @Autowired
    private MemberRepository userRepository;
    
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        Member member = userRepository.findByUserName(username).get();
        if (member != null && BCrypt.checkpw(password, member.getPassword())) {
            session.setAttribute("member", member);
            return "redirect:/library";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
