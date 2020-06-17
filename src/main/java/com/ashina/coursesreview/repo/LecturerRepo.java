package com.ashina.coursesreview.repo;

import com.ashina.coursesreview.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LecturerRepo extends JpaRepository<Lecturer, Long> {
    List<Lecturer> findAll();

    Optional<Lecturer> findById(Long id);

    void deleteById(Long id);

    Lecturer save(Lecturer lecturer);

    List<Lecturer> findByNameContaining(String name);
}
