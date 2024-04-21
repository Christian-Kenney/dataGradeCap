package com.jcmm.capStrong.model;

import javax.persistence.*;

import lombok.Data;

// name: grades
// description: grades
@Entity
@Data
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="grade_id", nullable = false)
    private Integer gradeId;
    @Column(name="student_id", nullable = false)
    private Integer studentId;
    @Column(name="grade", nullable = false)
    private Integer grade;
    @Column(name="assignment_Id", nullable = false)
    private Integer assignmentId;

    public Grade() {}

    public Grade(Integer gradeId, Integer studentId, Integer grade, Integer assignmentId){
        this.gradeId = gradeId;
        this.studentId = studentId;
        this.grade = grade;
        this.assignmentId = assignmentId;
    }

    @Override
    public String toString() {
        return String.format(
            "grades[gradeId=%s, studentId='%s', grade=%s, assignmentId='%s']",
            gradeId, studentId, grade, assignmentId);
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return gradeId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Integer getGrade() {
        return grade;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setGradesId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }
}
