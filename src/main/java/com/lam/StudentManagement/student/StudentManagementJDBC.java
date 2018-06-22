package com.lam.StudentManagement.student;

import java.sql.*;
import java.util.LinkedHashMap;


public class StudentManagementJDBC implements IStudentManagement {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/student_management?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Nguyenbalam123";

    @Override
    public LinkedHashMap<String, Student> getStudents() {

        /*
            SELECT * FROM com.lam.StudentManagement.student;
         */
        Connection dbConnection = null;
        PreparedStatement statement = null;

        String query = "SELECT * FROM com.lam.StudentManagement.student";
        LinkedHashMap<String, Student> result = new LinkedHashMap<String, Student>();

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
                result.put(studentID, new Student(
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
    public void setStudents(LinkedHashMap<String, Student> students) {

        /*
            TRUNCATE TABLE com.lam.StudentManagement.student;
            INSERT INTO com.lam.StudentManagement.student(StudentID, Name, Age, ClassName, Grade) VALUES
                (students);
         */


        clearData();
        Connection dbConnection = null;
        PreparedStatement statement = null;
        String sql = " INSERT INTO com.lam.StudentManagement.student(StudentID, Name, Age, ClassName, Grade) VALUES" +
                                "(?,?,?,?,?);";

        try {

            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(sql);

            for (String id : students.keySet()) {

                Student newStudent = students.get(id);

                statement.setString(1, newStudent.getStudentID());
                statement.setString(2, newStudent.getName());
                statement.setInt(3, newStudent.getAge());
                statement.setString(4, newStudent.getClassName());
                statement.setString(5, newStudent.getGrade());

                statement.executeUpdate();
            }

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

    }


    private void clearData() {

        Connection dbConnection = null;
        Statement statement = null;

        String sql = "TRUNCATE TABLE com.lam.StudentManagement.student;";


        try {

            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.executeUpdate(sql);

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
    }

    @Override
    public void addStudent(Student student) {

        /*
            INSERT INTO com.lam.StudentManagement.student(StudentID, Name, Age, ClassName, Grade) VALUES
                (students);
         */


        Connection dbConnection = null;
        PreparedStatement statement = null;

        String query = "INSERT INTO com.lam.StudentManagement.student(StudentID, Name, Age, ClassName, Grade) VALUES " +
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

    }

    @Override
    public void editStudent(String idOld, Student newStudent) {

        /*
            UPDATE com.lam.StudentManagement.student
            SET
            StudentID = newStudent.getID,
            Name = newStudent.getName,
            Age = newStudent.Age,
            ClassName = newStudent.GetClassName,
            Grade = newStudent.GetGrade
                WHERE id = idOld;
         */

        Connection dbConnection = null;
        PreparedStatement statement = null;

        String sql = "UPDATE com.lam.StudentManagement.student SET " +
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

    }

    @Override
    public Student removeStudent(String id) {

        /*
            DELETE FROM com.lam.StudentManagement.student WHERE StudentID = id;
         */

        Connection dbConnection = null;
        PreparedStatement statement = null;


        String sql = "DELETE FROM student_managent WHERE StudentID = ?";

        try {

            dbConnection = getDBConnection();
            statement = dbConnection.prepareStatement(sql);

            statement.setString(1, id);

            statement.executeUpdate();

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

        return null;
    }

    @Override
    public Student getStudentById(String id) {

        /*
            SELECT * FROM com.lam.StudentManagement.student WHERE StudentID = id;
         */

        Connection dbConnection = null;
        PreparedStatement statement = null;

        String sql = "SELECT * FROM com.lam.StudentManagement.student WHERE StudentID = ?";
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
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }
}
