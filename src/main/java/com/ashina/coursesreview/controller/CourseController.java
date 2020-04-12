package com.ashina.coursesreview.controller;

import com.ashina.coursesreview.entity.Account;
import com.ashina.coursesreview.entity.Course;
import com.ashina.coursesreview.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable("id") Long id) {
        return courseService.findById(id);
    }
}
