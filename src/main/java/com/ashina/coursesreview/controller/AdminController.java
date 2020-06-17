package com.ashina.coursesreview.controller;

import com.ashina.coursesreview.entity.Lecturer;
import com.ashina.coursesreview.service.AdminService;
import com.ashina.coursesreview.service.CourseService;
import com.ashina.coursesreview.service.LecturerService;
import com.ashina.coursesreview.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private LecturerService lecturerService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/admin")
    public String adminMain() {
        return "redirect:/admin/lecturers";
    }

    @GetMapping("/admin/lecturers")
    public String findAllAccounts(Model model) {
        List<Lecturer> lecturers = lecturerService.findAll();
        model.addAttribute("lecturers", lecturers);
        return "adminLecturers";
    }

    @GetMapping("/admin/lecturers/search")
    public String findLecturerByName(@RequestParam("name") String name, Model model) {
        if (name.isEmpty()) return "redirect:/admin/lecturers";
        List<Lecturer> lecturers = lecturerService.findByNameContaining(name);
        model.addAttribute("lecturers", lecturers);
        return "adminLecturers";
    }
}
