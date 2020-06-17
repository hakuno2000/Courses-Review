package com.ashina.coursesreview.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
public class Account {
    private Long id;

    public static Long currentId;

    private String password;

    public static Long type;

    public static Long getType() {
        return type;
    }

    public static void setType(Long type) {
        Account.type = type;
    }
}
