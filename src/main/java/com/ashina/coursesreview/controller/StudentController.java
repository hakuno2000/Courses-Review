package com.ashina.coursesreview.controller;

import com.ashina.coursesreview.entity.Course;
import com.ashina.coursesreview.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable("id") Long id) {
        return courseService.findCoursesByStudentId(id);
    }
}
