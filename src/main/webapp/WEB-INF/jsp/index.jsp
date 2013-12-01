<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
        <meta charset="utf-8">

        <link href="img/icon.png" rel="icon" type="image/png">
        <title>Book Store</title>

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/signin.css" rel="stylesheet" type="text/css">
</head>
<body>
<table border="0">

        <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Surname</td>
        </tr>
        <c:forEach items="${clients}" var="client">
                <tr>
                        <td>${client.id}</td>
                        <td>${client.name}</td>
                        <td>${client.surname}</td>
                </tr>
        </c:forEach>
</table>
</body>
</html>
