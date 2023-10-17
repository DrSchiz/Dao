package com.example.testproj2.controllers;

import com.example.testproj2.dao.DaoClass;
import com.example.testproj2.models.School;
import com.example.testproj2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SchoolController {
    private final DaoClass daoclass;

    @Autowired
    public SchoolController(DaoClass daoClass) {
        this.daoclass = daoClass;
    }


    @GetMapping("/all-schools")
    public String getAllSchools(Model model) {
        model.addAttribute("schools", daoclass.index(DaoClass.classes.School));
        return "all-schools";
    }

    @GetMapping("/create-school")
    public String create(@ModelAttribute("school") School school) {
        return "create-school";
    }

    @PostMapping("/create-school")
    public String postSchool(@ModelAttribute("school") School school) {
        Object school1 = school;
        daoclass.save(school1);
        return "redirect:/all-schools";
    }

    @GetMapping("school/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("school", daoclass.show(DaoClass.classes.School, id));
        return "show-school";
    }

    @PostMapping("school/{id}")
    public String update(@ModelAttribute("school") School school, @PathVariable("id") int id) {
        daoclass.update(school, id);
        return "redirect:/all-schools";
    }

    @DeleteMapping("school/{id}")
    public String delete(@PathVariable("id") int Id) {
        daoclass.delete(DaoClass.classes.School, Id);
        return "all-schools";
    }
}
