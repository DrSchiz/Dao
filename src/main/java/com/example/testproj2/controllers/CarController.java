package com.example.testproj2.controllers;

import com.example.testproj2.dao.DaoClass;
import com.example.testproj2.models.Car;
import com.example.testproj2.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {
    private final DaoClass daoclass;

    @Autowired
    public CarController(DaoClass daoClass) {
        this.daoclass = daoClass;
    }


    @GetMapping("/all-cars")
    public String getAllCars(Model model) {
        model.addAttribute("cars", daoclass.index(DaoClass.classes.Car));
        return "all-cars";
    }

    @GetMapping("/create-car")
    public String create(@ModelAttribute("car") Car car) {
        return "create-car";
    }

    @PostMapping("/create-car")
    public String postCar(@ModelAttribute("car") Car car) {
        Object car1 = car;
        daoclass.save(car1);
        return "redirect:/all-cars";
    }

    @GetMapping("car/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", daoclass.show(DaoClass.classes.Car, id));
        return "show-car";
    }

    @PostMapping("car/{id}")
    public String update(@ModelAttribute("car") Car car, @PathVariable("id") int id) {
        daoclass.update(car, id);
        return "redirect:/all-cars";
    }

    @DeleteMapping("car/{id}")
    public String delete(@PathVariable("id") int Id) {
        daoclass.delete(DaoClass.classes.Car, Id);
        return "all-cars";
    }
}
