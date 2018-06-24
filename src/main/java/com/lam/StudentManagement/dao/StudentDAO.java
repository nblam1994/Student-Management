package com.lam.StudentManagement.dao;

import com.lam.StudentManagement.student.Student;

import java.util.LinkedHashMap;
import java.util.List;

public interface StudentDAO {

    public Student getStudent(String id);
    public List<Student> listStudent();
    public boolean removeStudent(String id);
    public boolean editStudent(Student student);
    public boolean addStudent(Student student);
}
