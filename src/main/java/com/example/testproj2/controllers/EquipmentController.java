package com.example.testproj2.controllers;

import com.example.testproj2.dao.DaoClass;
import com.example.testproj2.models.Equipment;
import com.example.testproj2.models.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EquipmentController {
    private final DaoClass daoclass;

    @Autowired
    public EquipmentController(DaoClass daoClass) {
        this.daoclass = daoClass;
    }


    @GetMapping("/all-equipments")
    public String getAllEquipments(Model model) {
        model.addAttribute("equipments", daoclass.index(DaoClass.classes.Equipment));
        return "all-equipments";
    }

    @GetMapping("/create-equipment")
    public String create(@ModelAttribute("equipment") Equipment equipment) {
        return "create-equipment";
    }

    @PostMapping("/create-equipment")
    public String postEquipment(@ModelAttribute("equipment") Equipment equipment) {
        Object equipment1 = equipment;
        daoclass.save(equipment1);
        return "redirect:/all-equipments";
    }

    @GetMapping("equipment/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("equipment", daoclass.show(DaoClass.classes.Equipment, id));
        return "show-equipment";
    }

    @PostMapping("equipment/{id}")
    public String update(@ModelAttribute("equipment") Equipment equipment, @PathVariable("id") int id) {
        daoclass.update(equipment, id);
        return "redirect:/all-equipments";
    }

    @DeleteMapping("equipment/{id}")
    public String delete(@PathVariable("id") int Id) {
        daoclass.delete(DaoClass.classes.Equipment, Id);
        return "all-equipments";
    }
}
