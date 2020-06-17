package com.ashina.coursesreview.controller;

import com.ashina.coursesreview.entity.Course;
import com.ashina.coursesreview.entity.Lecturer;
import com.ashina.coursesreview.entity.Student;
import com.ashina.coursesreview.service.CourseService;
import com.ashina.coursesreview.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("student/{id}/delete")
    public String deleteById(@PathVariable("id") Long id) {
        studentService.deleteById(id);
        return "redirect:/admin/students";
    }

    @GetMapping("student/create")
    public String createStudent(Model model) {
        model.addAttribute("student", new Student());
        return "formStudent";
    }

    @PostMapping("student/create")
    public String createStudentComplete(Student student) {
        studentService.save(student);
        return "redirect:/admin/students";
    }
}
