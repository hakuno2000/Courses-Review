package com.ashina.coursesreview.service;

import com.ashina.coursesreview.entity.Account;
import com.ashina.coursesreview.entity.Lecturer;

import java.util.List;
import java.util.Optional;

public interface LecturerService {
    List<Lecturer> findAll();

    Optional<Lecturer> findById(Long id);

    Boolean lecturerLogin(Account account);

    void deleteByid(Long id);

    List<Lecturer> findByNameContaining(String name);
}
