package com.ashina.coursesreview.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
@Entity
@Table(name = "lecturers")
public class Lecturer {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "degree", nullable = false)
    private String degree;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "email", nullable = false)
    private String email;
}
