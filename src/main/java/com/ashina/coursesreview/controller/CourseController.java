package com.ashina.coursesreview.controller;

import com.ashina.coursesreview.entity.Account;
import com.ashina.coursesreview.entity.Course;
import com.ashina.coursesreview.entity.Student;
import com.ashina.coursesreview.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/course/{id}/delete")
    public String deleteById(@PathVariable("id") Long id) {
        courseService.deleteById(id);
        return "redirect:/admin/courses";
    }

    @GetMapping("/course/create")
    public String createCourse(Model model) {
        model.addAttribute("course", new Course());
        return "formCourse";
    }

    @PostMapping("/course/create")
    public String createCourseComplete(Course course) {
        courseService.save(course);
        return "redirect:/student/courses";
    }

    @GetMapping("/course/{id}/edit")
    public String editReview(@PathVariable("id") Long id, Model model) {
        Account.currentCourse = id;
        model.addAttribute("course", courseService.findReviewById(Account.currentId, id));
        return "formReview";
    }

    @PostMapping("/course/updatereview")
    public String updateReview(Course course) {
        courseService.updateReview(Account.currentId, Account.currentCourse, course.getCoSoVatChat().longValue(), course.getNoiDungMonHoc().longValue(), course.getHoatDongGiangVien().longValue());
        return "redirect:/student";
    }
}
