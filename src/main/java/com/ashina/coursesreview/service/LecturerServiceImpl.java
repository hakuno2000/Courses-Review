package com.ashina.coursesreview.service;

import com.ashina.coursesreview.entity.Account;
import com.ashina.coursesreview.entity.Lecturer;
import com.ashina.coursesreview.repo.LecturerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LecturerServiceImpl implements LecturerService {
    @Autowired
    private LecturerRepo lecturerRepo;

    @Override
    public List<Lecturer> findAll() {
        return lecturerRepo.findAll();
    }

    @Override
    public Optional<Lecturer> findById(Long id) {
        return lecturerRepo.findById(id);
    }

    @Override
    public Boolean lecturerLogin(Account account) {
        Optional<Lecturer> lecturer = lecturerRepo.findById(Account.currentId);
        if (lecturer.isEmpty()) return false;
        return lecturer.get().getPassword().equals(account.getPassword());
    }

    @Override
    public void deleteByid(Long id) {
        lecturerRepo.deleteById(id);
    }

    @Override
    public Lecturer save(Lecturer lecturer) {
        return  lecturerRepo.save(lecturer);
    }

    @Override
    public List<Lecturer> findByNameContaining(String name) {
        return lecturerRepo.findByNameContaining(name);
    }
}
