package com.ashina.coursesreview.repo;

import com.ashina.coursesreview.entity.Account;
import com.ashina.coursesreview.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Long> {
    @Query(value = "SELECT c.* FROM courses c ORDER BY c.id ASC", nativeQuery = true)
    List<Course> findAll();

    @Query(value = "SELECT c.* FROM courses c WHERE c.id = ?1", nativeQuery = true)
    Optional<Course> findById(Long id);

    @Query(value = "SELECT courses.* FROM courses INNER JOIN students_courses ON courses.id=students_courses.course_id WHERE students_courses.student_id=?1", nativeQuery = true)
    List<Course> findCoursesByStudentId(Long studentID);
}
