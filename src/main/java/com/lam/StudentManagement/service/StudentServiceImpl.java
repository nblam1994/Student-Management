package com.lam.StudentManagement.service;

import com.lam.StudentManagement.dao.StudentDAO;
import com.lam.StudentManagement.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "Service")
public class StudentServiceImpl implements StudentService{

    @Autowired
    @Qualifier("JPA")
    StudentDAO studentDAO;

    @Override
    public Student getStudent(String id) {

        return studentDAO.getStudent(id);
    }

    @Override
    public List<Student> listStudent() {

        return studentDAO.listStudent();
    }

    @Override
    public boolean removeStudent(String id) {

        return studentDAO.removeStudent(id);
    }

    @Override
    public boolean editStudent(Student student) {

        return studentDAO.editStudent(student);
    }

    @Override
    public boolean addStudent(Student student) {

        return addStudent(student);
    }
}
