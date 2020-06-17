package com.ashina.coursesreview.controller;

import com.ashina.coursesreview.entity.Account;
import com.ashina.coursesreview.entity.Course;
import com.ashina.coursesreview.service.AdminService;
import com.ashina.coursesreview.service.CourseService;
import com.ashina.coursesreview.service.LecturerService;
import com.ashina.coursesreview.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private LecturerService lecturerService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String mainPage() {
        if (Account.currentId == null) return "redirect:/login";
        else if (Account.type == 0) return "redirect:/admin";
        else if (Account.type == 1) return "redirect:/lecturer";
        else return "redirect:/student";
    }

    @GetMapping("/home")
    public String testRedirect() {
        return "redirect:/";
    }

    @GetMapping("/login")
    public String basicLogin(Model model) {
        Account.currentId = null; Account.type = null;
        model.addAttribute("account", new Account());
        return "formLogin";
    }

    @PostMapping("/home")
    public String testLogin(Account account) {
        Account.currentId = account.getId();
        if (Account.currentId == null) return "redirect:/login";

        if (Account.currentId < 10) Account.type = (long) 0;
        else if (Account.currentId >= 1000 && Account.currentId < 10000000) Account.type = (long) 1;
        else Account.type = (long) 2;

        Boolean check = false;
        if (Account.type == 0) {
            check = adminService.adminLogin(account);
            if (check) return "redirect:/admin";
            else return "redirect:/login";
        } else if (Account.type == 1) {
            check = lecturerService.lecturerLogin(account);
            if (check) return "redirect:/lecturer";
            else return "redirect:/login";
        } else {
            check = studentService.studentLogin(account);
            if (check) return "redirect:/student";
            else return "redirect:/login";
        }
    }
}
