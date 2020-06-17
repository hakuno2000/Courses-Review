package com.ashina.coursesreview.controller;

import com.ashina.coursesreview.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;

    @GetMapping("lecturer/{id}/delete")
    public String deleteById(@PathVariable("id") Long id) {
        lecturerService.deleteByid(id);
        return "redirect:/admin";
    }
}
