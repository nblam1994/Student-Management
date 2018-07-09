package com.lam.StudentManagement.dao;

import com.lam.StudentManagement.student.Student;
import com.lam.StudentManagement.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.*;


@Component(value = "JPA")
public class StudentDAOJPA implements StudentDAO{



    @Autowired
    private StudentRepository repo;

    @Override
    public Student getStudent(String id) {


        try {

            Optional optional = repo.findById(id);

            if (optional.isPresent()) {
                return (Student) optional.get();
            }
            else {
                return null;
            }

        }
        catch (EntityNotFoundException e) {

            return null;
        }
    }

    @Override
    public List<Student> listStudent() {

        return repo.findAll();
    }

    @Override
    public boolean removeStudent(String id) {

        try {
            repo.deleteById(id);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean editStudent(Student student) {

        Student std = getStudent(student.getStudentID());



        if(std != null) {

            try {
                repo.save(student);
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return  true;
        }

        return false;
    }

    @Override
    public boolean addStudent(Student student) {


        Student std = getStudent(student.getStudentID());

        System.out.print(std);

        if(std == null) {

            try {
                repo.save(student);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return  true;
        }

        return false;
    }
}
