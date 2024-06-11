package com.example.demospringsecurity.controller;

import com.example.demospringsecurity.service.UserService;
import com.example.demospringsecurity.service.security.AccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUser(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AccountDetails accountDetails = (AccountDetails) authentication.getPrincipal();
        model.addAttribute("user", accountDetails.getUser());
        return "user";
    }
    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @RequestMapping("/forbidden")
    public String accessDenied() {
        return "forbidden";
    }

}
