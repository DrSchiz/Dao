package com.example.testproj2.controllers;

import com.example.testproj2.dao.DaoUser;
import com.example.testproj2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    private final DaoUser daouser;

    @Autowired
    public MainController(DaoUser daoUser) {
        this.daouser = daoUser;
    }

    @GetMapping("/")
    public String getMain(Model model) {
        model.addAttribute("users", daouser.index());
        return "main";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute("user") User user) {
        return "create";
    }

    @PostMapping("/create")
    public String postUser(@ModelAttribute("user") User user) {
        daouser.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", daouser.show(id));
        return "show";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        daouser.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int Id) {
        daouser.delete(Id);
        return "main";
    }
}