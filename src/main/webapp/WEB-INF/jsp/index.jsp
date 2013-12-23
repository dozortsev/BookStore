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

                <h3><b>${book.name}</b></h3>
                <p>
                <div class="list-group">
                    <a class="list-group-item">
                        <i>${fn:substring(book.description, 0, 300)}&hellip;</i>
                    </a>
                    <a class="list-group-item">
                        <span class="badge">${author.name} ${author.surname}</span>
                        <b><fmt:message key="index.lbl.author"/></b>
                    </a>
                    <a class="list-group-item">
                        <span class="badge">${book.genre}</span>
                        <fmt:message key="index.lbl.genre"/>
                    </a>
                    <a class="list-group-item">
                        <span class="badge">${book.language}</span>
                        <fmt:message key="index.lbl.lang"/>
                    </a>
                    <a class="list-group-item">
                        <span class="badge"><fmt:formatDate value="${book.pubDate}"/></span>
                        <fmt:message key="index.lbl.pdate"/>
                    </a>
                    <a class="list-group-item">
                        <span class="badge">${book.pages}</span>
                        <fmt:message key="index.lbl.pages"/>
                    </a>
                </div>
                <p>
                    <a href="${bookAction}true" class="btn btn-primary">
                        <fmt:message key="btn.buy"/>&ensp;
                        <fmt:formatNumber value="${book.price}" type="currency"/>
                    </a>
                    <a href="${bookAction}false" class="btn btn-default" title="<fmt:message key="ttl.add.book"/>">
                        <fmt:message key="btn.add"/>
                    </a>
                </p><br/><br/>
            </div>
        </c:forEach>
    </div>
    <jsp:include page="Footer"/>
</div>