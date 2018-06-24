package com.lam.StudentManagement.controller;

import com.lam.StudentManagement.dao.StudentDAO;
import com.lam.StudentManagement.student.Student;
import com.lam.StudentManagement.student.StudentStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class StudentDIController {

    @Autowired
    @Qualifier("JDBC")
    private StudentDAO studentDAO;


    @RequestMapping(value = "/studentDI/list")
    public List<Student> listStudent(){

        return studentDAO.listStudent();
    }

    @RequestMapping(value = "/studentDI", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student) {

        studentDAO.addStudent(student);
        return student;
    }

    @RequestMapping(value = "/studentDI/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable String id) {

        return studentDAO.getStudent(id);
    }

    @RequestMapping(value = "/studentDI", method = RequestMethod.PUT)
    public Student editStudent(@RequestBody Student student) {

        boolean found = studentDAO.editStudent(student);

        if(found) {
            return student;
        }
        else {
            return null;
        }
    }


    @RequestMapping(value = "/studentDI/{id}", method = RequestMethod.DELETE)
    public Student removeStudent(@PathVariable String id) {


        Student student = studentDAO.getStudent(id);
        if(student != null) {
            studentDAO.removeStudent(id);
            return student;
        }
        else {
            return null;
        }
    }
}
