<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Add</title>
</head>

<body>




<form action="/jsp/student-edit" method="POST">


ID: <input type="text" name="id" value="${id}">
<br />
name: <input type="text" name="name" value="${name}">
<br />
age: <input type="number" name="age" value="${age}">
<br />
class <input type="text" name="className" value="${className}">
<br />
grade <input type="text" name="grade" value="${grade}">
<br />
<input type="submit" value="Submit" />
</form>

</body>
</html>