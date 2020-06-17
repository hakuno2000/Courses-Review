package com.ashina.coursesreview.controller;

import com.ashina.coursesreview.entity.Course;
import com.ashina.coursesreview.entity.Lecturer;
import com.ashina.coursesreview.entity.Student;
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
    public String findAllLecturers(Model model) {
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

    @GetMapping("/admin/students")
    public String findAllStudents(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "adminStudents";
    }

    @GetMapping("/admin/students/search")
    public String findStudentByName(@RequestParam("name") String name, Model model) {
        if (name.isEmpty()) return "redirect:/admin/students";
        List<Student> students = studentService.findByNameContaining(name);
        model.addAttribute("students", students);
        return "adminStudents";
    }

    @GetMapping("/admin/courses")
    public String findAllCourses(Model model) {
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses", courses);
        return "adminCourses";
    }

    @GetMapping("/admin/courses/search")
    public String findCourseByName(@RequestParam("name") String name, Model model) {
        if (name.isEmpty()) return "redirect:/admin/courses";
        List<Course> courses = courseService.findByNameContaining(name);
        model.addAttribute("courses", courses);
        return "adminCourses";
    }
}
