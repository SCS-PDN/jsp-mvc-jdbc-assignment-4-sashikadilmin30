package com.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session) {

        if(email.equals("john@gmail.com") && password.equals("123")) {
            session.setAttribute("user", email);
            return "redirect:/courses";
        }

        return "login";
    }
}