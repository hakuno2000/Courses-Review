package com.ashina.coursesreview.controller;

import com.ashina.coursesreview.entity.Account;
import com.ashina.coursesreview.entity.Lecturer;
import com.ashina.coursesreview.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;

    @GetMapping("lecturer/{id}/delete")
    public String deleteById(@PathVariable("id") Long id) {
        lecturerService.deleteByid(id);
        return "redirect:/admin";
    }

    @GetMapping("lecturer/create")
    public String createLecturer(Model model) {
        model.addAttribute("lecturer", new Lecturer());
        return "formLecturer";
    }

    @PostMapping("lecturer/create")
    public String createLecturerComplete(Lecturer lecturer) {
        lecturerService.save(lecturer);
        return "redirect:/admin";
    }
}
