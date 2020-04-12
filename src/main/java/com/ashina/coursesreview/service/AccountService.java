package com.ashina.coursesreview.service;

import com.ashina.coursesreview.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> findAll();

    Optional<Account> findById(Long id);

    void save(Account account);

    void delete(Long id);
}
