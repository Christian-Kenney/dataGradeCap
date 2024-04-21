package com.jcmm.capStrong.model;

import javax.persistence.*;

import lombok.Data;

// name: Assignment
// description: Assignment
@Entity
@Data
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="assignment_Id", nullable = false)
    private Integer assignmentId;
    @Column(name="classId", nullable = false)
    private Integer classId;
    @Column(name="name", nullable = false)
    private String name;

    public Assignment() {}

    public Assignment(Integer assignmentId, Integer classId, String name){
        this.assignmentId = assignmentId;
        this.classId = classId;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
            "Assignment[assignmentId=%s, classId='%s', name='%s']",
            assignmentId, classId, name);
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return assignmentId;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public Integer getClassId() {
        return classId;
    }

    public String getName() {
        return name;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
