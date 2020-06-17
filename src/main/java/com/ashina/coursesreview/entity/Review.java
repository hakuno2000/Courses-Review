package com.ashina.coursesreview.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter
@Entity
@Table(name = "students_courses")
public class Review {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "course_id", nullable = false)
    private Long courseId;

    @Column(name = "coSoVatChat")
    private Long coSoVatChat;

    @Column(name = "noiDungMonHoc")
    private Long noiDungMonHoc;

    @Column(name = "hoatDongGiangVien")
    private Long hoatDongGiangVien;
}
