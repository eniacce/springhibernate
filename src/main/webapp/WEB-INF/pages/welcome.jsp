<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: n2015
  Date: 21.03.2015
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TEST</title>

</head>
<body>
<h2>

    <c:forEach var="person" items="${listPersons}">
        <li>${person.name}</li>
        <li>${person.country}</li>
    </c:forEach>




</h2>

</body>
</html>
