package com.ashina.coursesreview.controller;

import com.ashina.coursesreview.entity.Account;
import com.ashina.coursesreview.entity.Course;
import com.ashina.coursesreview.entity.Lecturer;
import com.ashina.coursesreview.service.CourseService;
import com.ashina.coursesreview.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/lecturer/{id}/delete")
    public String deleteById(@PathVariable("id") Long id) {
        lecturerService.deleteByid(id);
        return "redirect:/admin";
    }

    @GetMapping("/lecturer/create")
    public String createLecturer(Model model) {
        model.addAttribute("lecturer", new Lecturer());
        return "formLecturer";
    }

    @PostMapping("/lecturer/create")
    public String createLecturerComplete(Lecturer lecturer) {
        lecturerService.save(lecturer);
        return "redirect:/admin";
    }

    @GetMapping("/lecturer")
    public String findCoursesByLecturerId(Model model) {
        List<Course> courses = courseService.findCourseByLecturerId(Account.currentId);
        model.addAttribute("courses", courses);
        return "lecturerCourses";
    }

    @GetMapping("/lecturer/search")
    public String findCoursesByName(@RequestParam("name") String name, Model model) {
        if (name.isEmpty()) return "redirect:/lecturer";
        List<Course> courses = courseService.findCourseByLecturerIdAndNameContaining(Account.currentId, name);
        model.addAttribute("courses", courses);
        return "lecturerCourses";
    }
}
