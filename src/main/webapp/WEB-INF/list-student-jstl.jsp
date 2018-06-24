<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>



<c:forEach items="${studentList}" item="student">
    ID: ${item.studentID}
    <br />
    name: ${item.name}
    <br />
    age: ${item.age}
    <br />
    class: ${item.className}
    <br />
    grade: ${item.grade}
    <br />
</c:forEach>


