package com.ashina.coursesreview.service;

import com.ashina.coursesreview.entity.Account;
import com.ashina.coursesreview.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Admin> findAll();

    Optional<Admin> findById(Long id);

    Boolean adminLogin(Account account);

    void save(Admin admin);

    void delete(Long id);
}
