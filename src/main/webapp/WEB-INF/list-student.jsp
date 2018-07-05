
<%@ page import ="com.hvcg.servlet.student.*" %>
<%@ page import ="java.util.LinkedHashMap"%>

<html>
<head>
    <title>List</title>
</head>

<body>

<%  LinkedHashMap<String, Student>  studentList = (LinkedHashMap<String, Student>)(request.getAttribute("studentList")); %>

<% for(String id : studentList.keySet()) { %>

<% Student student = studentList.get(id); %>

ID: <%= student.getStudentID()%>
<br />
name: <%= student.getName()%>
<br />
age: <%= student.getAge()%>
<br />
class: <%= student.getClassName()%>
<br />
grade: <%= student.getGrade()%>

<% } %>

</body>
</html>