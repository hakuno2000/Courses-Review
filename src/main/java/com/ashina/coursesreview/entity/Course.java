package com.ashina.coursesreview.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
@Entity
@Table (name = "courses")
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "number", nullable = false)
    private Long number;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "room", nullable = false)
    private String room;
}
