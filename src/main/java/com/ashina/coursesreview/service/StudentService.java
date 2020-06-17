package com.ashina.coursesreview.service;

import com.ashina.coursesreview.entity.Account;
import com.ashina.coursesreview.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();

    Optional<Student> findById(Long id);

    Boolean studentLogin(Account account);
}
