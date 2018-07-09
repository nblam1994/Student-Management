package com.lam.StudentManagement.student;



import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
public class Student implements Serializable{

    @Id
    @Basic(optional = false)
    @Column(name = "StudentID")
    private String studentID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Age")
    private int    age;

    @Column(name = "ClassName")
    private String className;

    @Column(name = "Grade")
    private String grade;

    public Student(){
    }


    public Student(String studentID, String name, int age, String className, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.className = className;
        this.grade = grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getClassName() {
        return className;
    }

    public String getGrade() {
        return grade;
    }


    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
