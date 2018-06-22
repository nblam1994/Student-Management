package com.lam.StudentManagement.student;


import java.util.LinkedHashMap;

public class StudentManagement implements IStudentManagement{

    private LinkedHashMap<String, Student> students;

    public StudentManagement() {
        students = new LinkedHashMap<>();
    };

    public StudentManagement(LinkedHashMap<String, Student> students) {
        this.students = students;
    }

    @Override
    public LinkedHashMap<String, Student> getStudents() {
        return students;
    }

    @Override
    public void setStudents(LinkedHashMap<String, Student> students) {
        this.students = students;
    }

    @Override
    public void addStudent(Student student) {
        this.editStudent(student.getStudentID(), student);
    }


    @Override
    public void editStudent(String idOld, Student newStudent) {
        students.put(idOld, newStudent);
    }


    @Override
    public Student removeStudent(String id) { return students.remove(id); }

    @Override
    public Student getStudentById(String id) {
        return students.get(id);
    }

}
