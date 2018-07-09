
<%@ page import ="com.lam.StudentManagement.student.*" %>
<%@ page import="java.util.List,java.util.ArrayList,java.util.Iterator,java.lang.Iterable"%>
<html>
<head>
    <title>List</title>
</head>

<body>

<%  Iterable<Object> list = studentList;  %>

<% for(Object student : list) { %>

<% Student std = (Student)(student);   %>

ID: <%= std.getStudentID()%>
<br />
name: <%= std.getName()%>
<br />
age: <%= std.getAge()%>
<br />
class: <%= std.getClassName()%>
<br />
grade: <%= std.getGrade()%>

<br />
<br />

<% } %>

</body>
</html>