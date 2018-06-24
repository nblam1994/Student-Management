package com.lam.StudentManagement.dao;

import com.lam.StudentManagement.student.Student;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Component(value = "JDBC")
public class StudentDAOJDBC implements StudentDAO {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/student_management?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Nguyenbalam123";

    @Override
    public Student getStudent(String id) {
        Connection dbConnection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM student WHERE StudentID = ?";
        Student student = null;

        try {

            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(sql);

            statement.setString(1, id);

            ResultSet rc = statement.executeQuery();

            if (rc.next()) {

                String name = rc.getString("Name");
                int age = Integer.parseInt(rc.getString("Age"));
                String className = rc.getString("ClassName");
                String grade = rc.getString("Grade");
                student = new Student(
                        id, name, age, className, grade
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }

                if (dbConnection != null) {
                    dbConnection.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return student;
    }

    @Override
    public List<Student> listStudent() {


        Connection dbConnection = null;
        PreparedStatement statement = null;

        String query = "SELECT * FROM student";
        List<Student> result = new ArrayList<>();

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String studentID = rs.getString("StudentID");
                String name = rs.getString("Name");
                int age = Integer.parseInt(rs.getString("Age"));
                String className = rs.getString("ClassName");
                String Grade = rs.getString("Grade");
                result.add(new Student(
                        studentID, name, age, className, Grade
                ));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

            try {
                if (statement != null) {
                    statement.close();
                }

                if (dbConnection != null) {
                    dbConnection.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return result;
    }

    @Override
    public boolean removeStudent(String id) {

        Connection dbConnection = null;
        PreparedStatement statement = null;


        String sql = "DELETE FROM student WHERE StudentID = ?";

        try {

            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(sql);

            statement.setString(1, id);

            statement.executeUpdate();


            return true;

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

            try {
                if (statement != null) {
                    statement.close();
                }

                if (dbConnection != null) {
                    dbConnection.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public boolean editStudent(Student newStudent) {

        Connection dbConnection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE student SET " +
                "Name = ?, " +
                "Age = ?, " +
                "ClassName = ?, "+
                "Grade = ? " +
                "WHERE StudentID = ?";

        try {

            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(sql);

            statement.setString(1, newStudent.getName());
            statement.setInt(2, newStudent.getAge());
            statement.setString(3, newStudent.getClassName());
            statement.setString(4, newStudent.getGrade());
            statement.setString(5, newStudent.getStudentID());

            statement.executeUpdate();

            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

            try {
                if (statement != null) {
                    statement.close();
                }

                if (dbConnection != null) {
                    dbConnection.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public boolean addStudent(Student student) {
        Connection dbConnection = null;
        PreparedStatement statement = null;

        String query = "INSERT INTO student(StudentID, Name, Age, ClassName, Grade) VALUES " +
                "(?, ?, ?, ?, ?);";


        try {

            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(query);

            statement.setString(1, student.getStudentID());
            statement.setString(2, student.getName());
            statement.setInt(3, student.getAge());
            statement.setString(4, student.getClassName());
            statement.setString(5, student.getGrade());

            statement.executeUpdate();

            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();


        }
        finally {

            try {
                if (statement != null) {
                    statement.close();
                }

                if (dbConnection != null) {
                    dbConnection.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }


    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER,DB_PASSWORD);
            System.out.println("Connected Database Successfully...\n\n");
            return dbConnection;

        } catch (SQLException e) {

            System.out.println("Fail to connect to databse");
            System.out.println(e.getMessage());

        }

        return dbConnection;

    }
}
