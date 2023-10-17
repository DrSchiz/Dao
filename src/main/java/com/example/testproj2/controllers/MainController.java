package com.example.testproj2.controllers;

import com.example.testproj2.dao.DaoClass;
import com.example.testproj2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @GetMapping("/")
    public String getMain(Model model) {
        return "main";
    }
}