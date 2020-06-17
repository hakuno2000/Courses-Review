package com.ashina.coursesreview.service;

import com.ashina.coursesreview.entity.Account;
import com.ashina.coursesreview.entity.Student;
import com.ashina.coursesreview.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepo.findById(id);
    }

    @Override
    public Boolean studentLogin(Account account) {
        Optional<Student> student = studentRepo.findById(Account.currentId);
        if (student.isEmpty()) return false;
        return student.get().getPassword().equals(account.getPassword());
    }

    @Override
    public List<Student> findByNameContaining(String name) {
        return studentRepo.findByNameContaining(name);
    }

    @Override
    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }
}
