package com.lam.StudentManagement.controller;

import com.lam.StudentManagement.dao.StudentDAO;
import com.lam.StudentManagement.student.Student;
import com.lam.StudentManagement.student.StudentStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.io.IOException;

@Controller
@RequestMapping("/jsp")
public class StudentJspController {

    @Autowired
    @Qualifier("JPA")
    private StudentDAO studentDAO;


    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public String viewStudent(@PathVariable String id, Map<String, Object> model) {

        model.put("student", studentDAO.getStudent(id));
        return "view-student";
    }



    @RequestMapping(value = "/student-add", method = RequestMethod.GET)
    public String addStudent() {

        return "add-student";
    }

    @RequestMapping(value = "/student-add", method = RequestMethod.POST)
    public String addStudent(HttpServletRequest request, Map<String, Object> model) {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String className = request.getParameter("class-name");
        String grade = request.getParameter("grade");
        Student student = new  Student(id, name, age, className, grade);
        boolean isAdd = studentDAO.addStudent(student);

        System.out.print("IsAdd: " +  isAdd);

        model.put("student", student);
        return "view-student";
    }

    @RequestMapping(value = "/student-list", method = RequestMethod.GET)
    public String listStudent(Model model) {

        Iterable<Student> studentList = studentDAO.listStudent();
        model.addAttribute("studentList", studentList);
        return "list-student-jstl";
    }

    @RequestMapping(value = "/student-delete/{id}")
    public void removeStudent(@PathVariable String id, HttpServletResponse resp) throws IOException{

        boolean isDelete = studentDAO.removeStudent(id);

        if(isDelete) {

            resp.getWriter().print("Student with id :" + id + " deleted");
        }
        else {

            resp.getWriter().print("Student does not exist");
        }

    }


    @RequestMapping(value = "/student-edit")
    public String removeStudent(){

        return "edit-student";
    }


    @RequestMapping(value = "/student-edit", method = RequestMethod.POST)
    public void removeStudent(HttpServletRequest request, HttpServletResponse resp) throws IOException{


        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String className = request.getParameter("className");
        String grade = request.getParameter("grade");
        Student student = new  Student(id, name, age, className, grade);

        boolean success = studentDAO.editStudent(student);

        if (success) {
            resp.getWriter().print("Edit success");
        }
        else {
            resp.getWriter().print("Edit fails");
        }



    }



}
