package com.example.testproj2.controllers;

import com.example.testproj2.dao.DaoClass;
import com.example.testproj2.models.Country;
import com.example.testproj2.models.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CountryController {
    private final DaoClass daoclass;

    @Autowired
    public CountryController(DaoClass daoClass) {
        this.daoclass = daoClass;
    }


    @GetMapping("/all-countries")
    public String getAllCountries(Model model) {
        model.addAttribute("countries", daoclass.index(DaoClass.classes.Country));
        return "all-countries";
    }

    @GetMapping("/create-country")
    public String create(@ModelAttribute("country") Country country) {
        return "create-country";
    }

    @PostMapping("/create-country")
    public String postCountry(@ModelAttribute("country") Country country) {
        Object country1 = country;
        daoclass.save(country1);
        return "redirect:/all-countries";
    }

    @GetMapping("country/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("country", daoclass.show(DaoClass.classes.Country, id));
        return "show-country";
    }

    @PostMapping("country/{id}")
    public String update(@ModelAttribute("country") Country country, @PathVariable("id") int id) {
        daoclass.update(country, id);
        return "redirect:/all-countries";
    }

    @DeleteMapping("country/{id}")
    public String delete(@PathVariable("id") int Id) {
        daoclass.delete(DaoClass.classes.Country, Id);
        return "all-countries";
    }
}
