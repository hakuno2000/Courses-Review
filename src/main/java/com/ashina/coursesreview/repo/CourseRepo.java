package com.ashina.coursesreview.repo;

import com.ashina.coursesreview.entity.Account;
import com.ashina.coursesreview.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Long> {
    @Query(value = "SELECT c.* FROM courses c ORDER BY c.id ASC", nativeQuery = true)
    List<Course> findAll();

    @Query(value = "SELECT c.* FROM courses c WHERE c.id = ?1", nativeQuery = true)
    Optional<Course> findById(Long id);

    @Query(value = "SELECT courses.* FROM courses INNER JOIN students_courses ON courses.id=students_courses.course_id WHERE students_courses.student_id=?1", nativeQuery = true)
    List<Course> findCoursesByStudentId(Long studentID);

    List<Course> findByNameContaining(String name);

    void deleteById(Long id);

    Course save(Course course);

    @Modifying
    @Transactional
    @Query(value = "UPDATE courses c,\n" +
            "(SELECT c.id, ROUND(AVG(sc.coSoVatChat), 2) AS coSoVatChat,\n" +
            "        ROUND(AVG(sc.noiDungMonHoc), 2) AS noiDungMonHoc,\n" +
            "        ROUND(AVG(sc.hoatDongGiangVien), 2) AS hoatDongGiangVien\n" +
            "FROM students_courses sc JOIN courses c on sc.course_id = c.id\n" +
            "GROUP BY course_id) AS t\n" +
            "\n" +
            "SET\n" +
            "    c.coSoVatChat = t.coSoVatChat,\n" +
            "    c.noiDungMonHoc = t.noiDungMonHoc,\n" +
            "    c.hoatDongGiangVien = t.hoatDongGiangVien\n" +
            "WHERE\n" +
            "    c.id = t.id", nativeQuery = true)
    void calAvgReview();
}
