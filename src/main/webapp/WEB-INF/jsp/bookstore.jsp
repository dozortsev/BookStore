<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="templates/resources.jsp" %>

<html>
<head>
    <link href="img/icon.png" rel="icon" type="image/png">

    <title>Book Store</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="css/justified-nav.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="container">

    <a href="${contextPath}/Client/${client.id}">${client.name} ${client.surname}</a> |
    <a href="${contextPath}/Authentication">Log Out</a>

    <div class="jumbotron">
        <h1>
            Welcome in Book Store.
        </h1>
    </div>

    <div class="row">

        <c:forEach items="${books}" var="book">

            <c:set var="author" value="${book.author}"/>

            <c:set var="pdate" value="${book.pubDate}"/>

            <div class="col-lg-6">

                <div class="panel panel-primary">

                    <div class="panel-heading">
                        <h1 class="panel-title">${book.name}</h1>
                    </div>

                    <table class="table table-condensed">
                        <thead>
                        <tr>
                            <th>Author</th>
                            <th>Genre</th>
                            <th>Language</th>
                            <th>Public date</th>
                            <th>Pages</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${author.name} ${author.surname}</td>
                            <td>${book.genre}</td>
                            <td>${book.language}</td>
                            <td>
                                    ${pdate.get(1)}-${pdate.get(2)}-${pdate.get(5)}
                            </td>
                            <td>${book.pages}</td>
                        </tr>
                        </tbody>
                    </table>

                    <div class="panel-body">
                        <i>${book.description}</i>
                    </div>

                    <div class="panel-footer">

                        <c:set var="buyBook" value="./Welcome?idBook=${book.id}&idClient=${client.id}&status="/>

                        <a href="${buyBook}true" class="btn btn-success" role="button">Buy ${book.price}$</a>
                        <a href="${buyBook}false" class="btn btn-default" role="button">Add</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="footer"><p>Dozortsev Anton</p></div>
</div>
</body>
</html>