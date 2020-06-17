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

    List<Course> findCourseByStudentIdAndNameContaining(Long id, String name);

    List<Course> findCourseByLecturerId(Long id);

    List<Course> findCourseByLecturerIdAndNameContaining(Long id, String name);

    List<Course> findByNameContaining(String name);

    void deleteById(Long id);

    Course save(Course course);

    void calAvgReview();

    void updateReview(Long studentId, Long courseId, Long coSoVatChat, Long noiDungMonHoc, Long hoatDongGiangVien);

    Course findReviewById(Long studentId, Long courseId);
}
