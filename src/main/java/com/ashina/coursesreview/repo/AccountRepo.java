package com.ashina.coursesreview.repo;

import com.ashina.coursesreview.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account, Long> {
    @Query(value = "SELECT a.* FROM accounts a ORDER BY a.id ASC", nativeQuery = true)
    List<Account> findAll();

    @Query(value = "SELECT a.* FROM accounts a WHERE a.id = ?1", nativeQuery = true)
    Optional<Account> findById(Long id);
}
