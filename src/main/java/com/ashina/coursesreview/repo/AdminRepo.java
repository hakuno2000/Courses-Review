package com.ashina.coursesreview.repo;

import com.ashina.coursesreview.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, Long> {
    @Query(value = "SELECT a.* FROM admins a ORDER BY a.id ASC", nativeQuery = true)
    List<Admin> findAll();

    @Query(value = "SELECT a.* FROM admins a WHERE a.id = ?1", nativeQuery = true)
    Optional<Admin> findById(Long id);
}
