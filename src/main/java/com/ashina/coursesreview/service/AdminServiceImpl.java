package com.ashina.coursesreview.service;

import com.ashina.coursesreview.entity.Admin;
import com.ashina.coursesreview.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepo adminRepo;

    @Override
    public List<Admin> findAll() {
        return adminRepo.findAll();
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepo.findById(id);
    }

    @Override
    public void save(Admin admin) {
        adminRepo.save(admin);
    }

    @Override
    public void delete(Long id) {
        adminRepo.deleteById(id);
    }
}
