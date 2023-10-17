package com.example.testproj2.controllers;

import com.example.testproj2.dao.DaoClass;
import com.example.testproj2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final DaoClass daoclass;

    @Autowired
    public UserController(DaoClass daoClass) {
        this.daoclass = daoClass;
    }


    @GetMapping("/all-users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", daoclass.index(DaoClass.classes.User));
        return "all-users";
    }

    @GetMapping("/create-user")
    public String create(@ModelAttribute("user") User user) {
        return "create-user";
    }

    @PostMapping("/create-user")
    public String postUser(@ModelAttribute("user") User user) {
        Object user1 = user;
        daoclass.save(user1);
        return "redirect:/all-users";
    }

    @GetMapping("user/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", daoclass.show(DaoClass.classes.User, id));
        return "show-user";
    }

    @PostMapping("user/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        daoclass.update(user, id);
        return "redirect:/all-users";
    }

    @DeleteMapping("user/{id}")
    public String delete(@PathVariable("id") int Id) {
        daoclass.delete(DaoClass.classes.User, Id);
        return "all-users";
    }
}
