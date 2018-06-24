package com.lam.StudentManagement.controller;

import com.lam.StudentManagement.dao.StudentDAO;
import com.lam.StudentManagement.student.StudentStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RequestMapping("/jsp")
public class StudentJspController {

    @Autowired
    @Qualifier("JDBC")
    private StudentDAO studentDAO;


    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public String viewStudent(@PathVariable String id, Map<String, Object> model) {


        model.put("student", StudentStorage.listStudent.getStudentById(id));

        return "view-student";
    }



//    public String addStudent(@) {
//
//    }
}
