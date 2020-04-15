package com.ashina.coursesreview.controller;

import com.ashina.coursesreview.entity.Course;
import com.ashina.coursesreview.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public String demo(Model model) {
        List<Course> courses = courseService.findCoursesByStudentId((long)18021273);
        model.addAttribute("courses", courses);
        return "list";
    }
}
