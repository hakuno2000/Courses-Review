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

    @Query(value = "SELECT c.id, c.name, c.code, c.number, c.time, c.room, sc.coSoVatChat, sc.hoatDongGiangVien, sc.noiDungMonHoc\n" +
            "FROM courses c JOIN students_courses sc on c.id = sc.course_id\n" +
            "WHERE sc.student_id = ?1", nativeQuery = true)
    List<Course> findCoursesByStudentId(Long studentID);

    @Query(value = "SELECT c.id, c.name, c.code, c.number, c.time, c.room, sc.coSoVatChat, sc.hoatDongGiangVien, sc.noiDungMonHoc\n" +
            "FROM courses c JOIN students_courses sc on c.id = sc.course_id\n" +
            "WHERE sc.student_id = ?1 AND c.name LIKE concat(\"%\", ?2, \"%\")", nativeQuery = true)
    List<Course> findCourseByStudentIdAndNameContaining(Long id, String name);

    @Query(value = "select c.* from courses c join lecturers_courses lc on c.id = lc.course_id where lc.lecturer_id = ?1", nativeQuery = true)
    List<Course> findCourseByLecturerId(Long id);

    @Query(value = "select c.* from courses c join lecturers_courses lc on c.id = lc.course_id where lc.lecturer_id = ?1 and c.name like concat(\"%\", ?2, \"%\")", nativeQuery = true)
    List<Course> findCourseByLecturerIdAndNameContaining(Long id, String name);

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

    @Modifying
    @Transactional
    @Query(value = "UPDATE students_courses SET coSoVatChat = ?3, noiDungMonHoc = ?4, hoatDongGiangVien = ?5 WHERE student_id = ?1 AND course_id = ?2", nativeQuery = true)
    void updateReview(Long studentId, Long courseId, Long coSoVatChat, Long noiDungMonHoc, Long hoatDongGiangVien);

    @Query(value = "SELECT c.id, c.name, c.code, c.number, c.time, c.room, sc.coSoVatChat, sc.hoatDongGiangVien, sc.noiDungMonHoc\n" +
            "FROM courses c JOIN students_courses sc on c.id = sc.course_id\n" +
            "WHERE sc.student_id = ?1 AND c.id = ?2", nativeQuery = true)
    Course findReviewById(Long studentId, Long courseId);
}
