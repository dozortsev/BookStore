<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="templates/resources.jsp" %>

<title>Book Store</title>

<link href="css/justified-nav.css" rel="stylesheet" type="text/css">

<div class="container">

    <a href="${path}/Client">${client.name} ${client.surname}</a> |
    <a href="${path}/SignIn">Log Out</a>

    <div class="jumbotron">
        <h1>
            ${quote}
        </h1>
        <a href="#Books" class="glyphicon glyphicon-circle-arrow-down"></a>
    </div>

    <div id="Books" class="row">
        <br/>
        <c:forEach items="${books}" var="book">

            <c:set var="author" value="${book.author}"/>

            <c:set var="bookAction" value="${path}/Client/Book/${book.id}/Status/"/>

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
                                <fmt:formatDate value="${book.pubDate}"/>
                            </td>
                            <td>${book.pages}</td>
                        </tr>
                        </tbody>
                    </table>

                    <div class="panel-body">
                        <i>${fn:substring(book.description, 0, 400)}&hellip;</i>
                    </div>

                    <div class="panel-footer">

                        <a href="${bookAction}true" class="btn btn-primary">
                            Buy <fmt:formatNumber value="${book.price}" type="currency"/>
                        </a>
                        <a href="${bookAction}false" class="btn btn-default">Add</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <%-- todo: add footer.jsp --%>

    <div class="footer"><p>Dozortsev Anton</p></div>
</div>