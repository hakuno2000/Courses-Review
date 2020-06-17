package com.ashina.coursesreview.service;

import com.ashina.coursesreview.entity.Account;
import com.ashina.coursesreview.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();

    Optional<Course> findById(Long id);

    void delete(Long id);

    List<Course> findCoursesByStudentId(Long studentID);

    List<Course> findByNameContaining(String name);

    void deleteById(Long id);

    Course save(Course course);
}
