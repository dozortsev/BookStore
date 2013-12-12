<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="resources.jsp" %>

<html>
<head>
    <link href="img/icon.png" rel="icon" type="image/png">

    <title>Client / ${client.name} ${client.surname}</title>

    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="css/signin.css" rel="stylesheet" type="text/css">

</head>
<body>

<%-- todo: log out system --%>

<div class="container">

    <a href="${contextPath}/Client/Edit/${client.id}">Edit ${client.name} ${client.surname}</a> |
    <a href="${contextPath}/Authentication">Log Out</a>

    <form:form action="${contextPath}/Welcome" method="POST" commandName="client">

        <form:hidden path="id"/>

        <br/><br/>
        Name: ${client.name}
        <br/>
        Surname: ${client.surname}
        <br/>
        Email: ${client.email}

        <br/><br/>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Author</td>
                <td>Status</td>
            </tr>
            <c:forEach items="${client.cards}" var="card">

                <c:set value="${card.book}" var="book"/>
                <c:set value="${book.author}" var="author"/>
                <tr>
                    <td>${book.id}</td>
                    <td>${book.name}</td>
                    <td>${author.name} ${author.surname}</td>

                    <c:set value="${contextPath}/Client/${client.id}/Card/${card.id}?status=" var="clientBook"/>

                    <c:choose>
                        <c:when test="${card.status}">
                            <td>
                                <a href="${clientBook}false">Delete</a>
                            </td>
                        </c:when><c:otherwise>
                        <td>
                            <a href="${clientBook}true">Buy ${book.price}$</a> |
                            <a href="${clientBook}false">Delete</a>
                        </td>
                    </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
        </table>

        <input type="submit" role="button" value="Showcase">

    </form:form>
</div>

</body>
</html>