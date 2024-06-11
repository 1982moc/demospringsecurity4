package com.example.demospringsecurity.controller;

import com.example.demospringsecurity.models.User;
import com.example.demospringsecurity.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminUserController {
    private final AdminUserService adminUserService;

    @Autowired
    public AdminUserController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @GetMapping
    public String showUsers(Model model) {
        model.addAttribute("users", adminUserService.listUsers());
        return "admin";
    }

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String inputUser(@ModelAttribute("user") User user) {
        adminUserService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("editable_user", adminUserService.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("editable_user") User user, @PathVariable("id") Long id) {
        adminUserService.editUser(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        adminUserService.deleteUser(id);
        return "redirect:/admin";
    }


}
//привет