<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="templates/resources.jsp" %>

<title><fmt:message key="project.name"/></title>

<link rel="stylesheet" href="css/jumbotron.css">
<link rel="stylesheet" href="css/justified-nav.css">

<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active">
                <a href="${path}/Client" title="<fmt:message key="ttl.client.you"/>">
                    <span class="glyphicon glyphicon-user"></span>
                    &ensp;${client.name} ${client.surname}
                </a>
            </li>
            <li>
                <a href="${path}/SignIn">
                    <span class="glyphicon glyphicon-off"></span>
                    &ensp;<fmt:message key="btn.logout"/>
                </a>
            </li>
        </ul>
        <h3 class="text-muted"><fmt:message key="project.name"/></h3>
    </div>
</div>

<div class="jumbotron img-background">
    <div class="container">
        <h1>
            <fmt:message key="index.quote"/>
        </h1>

        <p><a href="#Books" title="<fmt:message key="ttl.showcase.book"/>">
            <span class="glyphicon glyphicon-circle-arrow-down"></span>
        </a></p>
    </div>
</div>

<div id="Books" class="container">

    <div class="row">

        <c:forEach items="${books}" var="book">

            <c:set var="author" value="${book.author}"/>

            <c:set var="bookAction" value="${path}/Client/Book/${book.id}/Status/"/>

            <div class="col-md-4">

                <h4><b>${book.name}</b></h4>
                <p>
                    <i>${fn:substring(book.description, 0, 100)}&hellip;</i>
                </p>
                <p>
                    <a href="${bookAction}true" class="btn btn-primary">
                        <fmt:message key="btn.buy"/>&ensp;
                        <fmt:formatNumber value="${book.price}" type="currency"/>
                    </a>
                    <a href="${bookAction}false" class="btn btn-default" title="<fmt:message key="ttl.add.book"/>">
                        <fmt:message key="btn.add"/>
                    </a>
                </p>

                <!-- Button trigger modal -->
                <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#bookModal${book.id}">
                    Launch demo modal
                </button>

                <!-- Modal -->
                <div class="modal fade" id="bookModal${book.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="myModalLabel">${book.name}</h4>
                            </div>
                            <div class="modal-body">
                                It's work !
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <jsp:include page="Footer"/>
</div>