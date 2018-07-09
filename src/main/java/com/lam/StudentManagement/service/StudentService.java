package com.lam.StudentManagement.service;

import com.lam.StudentManagement.student.Student;

import java.util.List;

public interface StudentService {

    public Student getStudent(String id);
    public List<Student> listStudent();
    public boolean removeStudent(String id);
    public boolean editStudent(Student student);
    public boolean addStudent(Student student);
}
