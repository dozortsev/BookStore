<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>Spring MVC Starter Application</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>

<body>

        Id: ${client.id}<br>
        Name: ${client.name}<br>
        Surname: ${client.surname}<br>
        Email: ${client.email}<br>
        Password: ${client.password}
        <br><br>
        Books: <br>
        <c:forEach items="${client.books}" var="book">

                ${book.book.name}<br>
        </c:forEach>

</body>
</html>
