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
    public void delete(Long id) {
        courseRepo.deleteById(id);
    }

    @Override
    public List<Course> findCoursesByStudentId(Long studentID) {
        return courseRepo.findCoursesByStudentId(studentID);
    }

    @Override
    public List<Course> findCourseByStudentIdAndNameContaining(Long id, String name) {
        return courseRepo.findCourseByStudentIdAndNameContaining(id, name);
    }

    @Override
    public List<Course> findCourseByLecturerId(Long id) {
        return courseRepo.findCourseByLecturerId(id);
    }

    @Override
    public List<Course> findCourseByLecturerIdAndNameContaining(Long id, String name) {
        return courseRepo.findCourseByLecturerIdAndNameContaining(id, name);
    }

    @Override
    public List<Course> findByNameContaining(String name) {
        return courseRepo.findByNameContaining(name);
    }

    @Override
    public void deleteById(Long id) {
        courseRepo.deleteById(id);
    }

    @Override
    public Course save(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public void calAvgReview() {
        courseRepo.calAvgReview();
    }

    @Override
    public void updateReview(Long studentId, Long courseId, Long coSoVatChat, Long noiDungMonHoc, Long hoatDongGiangVien) {
        courseRepo.updateReview(studentId, courseId, coSoVatChat, noiDungMonHoc, hoatDongGiangVien);
    }

    @Override
    public Course findReviewById(Long studentId, Long courseId) {
        return courseRepo.findReviewById(studentId, courseId);
    }
}
