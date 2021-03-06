package com.ashina.coursesreview.repo;

import com.ashina.coursesreview.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findAll();

    Optional<Student> findById(Long id);

    List<Student> findByNameContaining(String name);

    void deleteById(Long id);

    Student save(Student student);
}
