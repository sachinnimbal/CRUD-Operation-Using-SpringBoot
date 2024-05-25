package com.crud.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.entity.Crud;
import com.crud.service.CrudService;

@Controller
public class CrudController {

    @Autowired
    CrudService crudService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("details", crudService.getAllData());
        return "index";
    }

    @PostMapping("/create")
    public String createNew(@ModelAttribute Crud crud, RedirectAttributes redirectAttributes) {
        crud.setCreatedDate(new Date());
        crudService.addData(crud);
        redirectAttributes.addFlashAttribute("successMessage", "Data saved successfully!");
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String editData(@RequestParam("id") int id, Model model) {
        model.addAttribute("editData", crudService.getDataById(id));
        return "editDetails";
    }

    @PostMapping("/updateDetails")
    public String update(@ModelAttribute Crud crud, RedirectAttributes redirectAttributes) {
        Crud existingData = crudService.getDataById(crud.getId());

        if (existingData != null) {
            existingData.setName(crud.getName() != null ? crud.getName() : existingData.getName());
            existingData.setPhone(crud.getPhone() != null ? crud.getPhone() : existingData.getPhone());
            existingData.setAbout(crud.getAbout() != null ? crud.getAbout() : existingData.getAbout());
            existingData.setUpdatedDate(new Date());
            crudService.updateData(existingData);
            redirectAttributes.addFlashAttribute("successMessage", "Data updated successfully!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Data not found!");
        }
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        crudService.deleteData(id);
        redirectAttributes.addFlashAttribute("successMessage", "Data deleted successfully!");
        return "redirect:/";
    }
}
