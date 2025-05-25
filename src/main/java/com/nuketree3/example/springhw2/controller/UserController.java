package com.nuketree3.example.springhw2.controller;


import com.nuketree3.example.springhw2.domain.User;
import com.nuketree3.example.springhw2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if(error != null) {
            model.addAttribute("loginError", "true");
        }
        return "login";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) throws SQLException {
        if(!userService.createUser(user)) {
            model.addAttribute("error", "Username or password is incorrect");
            return "registration";
        }
        return "redirect:/login";
    }
}
