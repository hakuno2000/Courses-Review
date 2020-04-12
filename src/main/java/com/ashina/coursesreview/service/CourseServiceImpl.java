package com.ashina.coursesreview.service;

import com.ashina.coursesreview.entity.Course;
import com.ashina.coursesreview.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepo.findById(id);
    }

    @Override
    public void save(Course course) {
        courseRepo.save(course);
    }

    @Override
    public void delete(Long id) {
        courseRepo.deleteById(id);
    }

    @Override
    public List<Course> findCoursesByStudentId(Long studentID) {
        return courseRepo.findCoursesByStudentId(studentID);
    }
}
