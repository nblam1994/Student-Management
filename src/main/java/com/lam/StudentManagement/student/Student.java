package com.lam.StudentManagement.student;

public class Student {

    private String studentID;
    private String name;
    private int    age;
    private String className;
    private String grade;


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
}
