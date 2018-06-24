package com.lam.StudentManagement.controller;


import com.lam.StudentManagement.StudentManagement2Application;
import com.lam.StudentManagement.student.Student;
import com.lam.StudentManagement.student.StudentManagementJDBC;
import com.lam.StudentManagement.student.StudentStorage;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
public class StudentManagementController {


    @RequestMapping(value = "/student/list")
    public LinkedHashMap<String, Student> listStudent(){

        return StudentStorage.listStudent.getStudents();
    }


    @RequestMapping(value= "/student/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable String id) {

        return StudentStorage.listStudent.getStudentById(id);
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public void addStudent(@RequestBody Student student) {

        StudentStorage.listStudent.addStudent(student);
    }


    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public Student removeStudent(@PathVariable String id) {

        return StudentStorage.listStudent.removeStudent(id);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public String editStudent(@PathVariable String id, @RequestBody Student student) {

        if(StudentStorage.listStudent.getStudents().containsKey(id)) {

            StudentStorage.listStudent.editStudent(id, student);
            return "Edit successul";
        }
        else  {
            return "Student with id: " + id + " does not exist";
        }
    }


    @RequestMapping("/")
    public String Welcome() {

        return "Welcome";
    }
}
