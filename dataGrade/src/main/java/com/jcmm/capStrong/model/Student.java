package com.jcmm.capStrong.model;

import lombok.Data;

import javax.persistence.*;

// name: students
// description: students
@Entity
@Data
@Table(name = "student")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "class_id")
    private Integer classId;

    @Column(name = "user_id")
    private Integer userId;


    protected Student() {}

    public Student(Integer classId, Integer user_id){
        this.classId = classId;
        this.userId = user_id;
    }

    @Override
    public String toString() {
        return String.format(
            "Student[userId=%s, studentId=%s, classId='%s']",
            userId, studentId, classId);
      }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return studentId;
    }

    public Integer getClassId(){
        return classId;
    }

    public Integer getStudentId(){
        return studentId;
    }

    public Integer getStudentUserId(){
        return userId;
    }

    public void setClassId(Integer classId){
        this.classId = classId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public void setStudentId(Integer studentId){
        this.studentId = studentId;
    }
}
