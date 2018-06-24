package com.lam.StudentManagement.student;

import java.util.LinkedHashMap;

public interface IStudentManagement {

    public LinkedHashMap<String, Student> getStudents();
    public void setStudents(LinkedHashMap<String, Student> students);
    public void addStudent(Student student) ;
    public void editStudent(String idOld, Student newStudent);
    public Student removeStudent(String id);
    public Student getStudentById(String id);

}
