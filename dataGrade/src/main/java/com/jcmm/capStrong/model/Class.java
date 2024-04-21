package com.jcmm.capStrong.model;

import javax.persistence.*;

import lombok.Data;

// name: Classs
// description: Classes
@Entity
@Data
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="class_Id", nullable = false)
    private Integer classId;
    @Column(name="teacher", nullable = false)
    private Integer teacher;
    @Column(name="subject", nullable = false)
    private String subject;
    @Column(name="gradelevel", nullable = false)
    private Integer gradelevel;

    public Class() {}

    public Class(Integer classId, Integer teacher, String subject, Integer gradelevel){
        this.classId = classId;
        this.teacher = teacher;
        this.subject = subject;
        this.gradelevel = gradelevel;
    }

    @Override
    public String toString() {
        return String.format(
            "Class[classId=%s, teacher='%s', subject=%s, gradelevel='%s']",
            classId, teacher, subject, gradelevel);
    }

    // Getters
    public Integer getClassId() {
        return classId;
    }

    public Integer getTeacher() {
        return teacher;
    }

    public String getSubject() {
        return subject;
    }

    public Integer getGradelevel() {
        return gradelevel;
    }

    // Setters
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGradelevel(Integer gradelevel) {
        this.gradelevel = gradelevel;
    }
}
