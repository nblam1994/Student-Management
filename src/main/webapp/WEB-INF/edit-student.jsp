<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Add</title>
</head>

<body>




<c:choose>
    <c:when test = "${param.success eq 'true'}">
        <h5 style="color: red">Edit successful</h5>
    </c:when>
    <c:when test = "${param.success eq 'false'}">
            <h5 style="color: red">Edit fail</h5>
    </c:when>
</c:choose>


<form action="/edit-student" method="POST">


ID: <input type="hidden" name="id" value="${id}">
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