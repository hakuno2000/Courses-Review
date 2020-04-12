package com.ashina.coursesreview.service;

import com.ashina.coursesreview.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Admin> findAll();

    Optional<Admin> findById(Long id);

    void save(Admin admin);

    void delete(Long id);
}
