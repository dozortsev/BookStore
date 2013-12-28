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
    <br/>
    <div class="row">

        <c:forEach items="${books}" var="book">

            <c:set var="author" value="${book.author}"/>

            <c:set var="bookAction" value="${path}/Client/Book/${book.id}/Status/"/>

            <c:set var="bookModal" value="bookModal${book.id}"/>

            <div class="col-md-4">
                <h4>
                    <b>${book.name}</b><br/><br/>
                    <small>${author.name}&ensp;${author.surname}</small>
                </h4>
                <p>
                    <i>${fn:substring(book.description, 0, 200)}&hellip;</i>
                </p>
                <p>
                    <a href="${bookAction}true" class="btn btn-success" title="<fmt:message key="ttl.book.buy"/>">
                        <b><fmt:message key="btn.buy"/></b>&ensp;
                        <fmt:formatNumber value="${book.price}" type="currency"/>
                    </a>
                    <button class="btn btn-primary" data-toggle="modal" data-target="#${bookModal}"
                            title="<fmt:message key="ttl.book.more"/>">
                        <span class="glyphicon glyphicon-align-center"></span>
                        <fmt:message key="btn.show"/>
                    </button>
                    <a href="${bookAction}false" class="btn btn-default" title="<fmt:message key="ttl.book.add"/>">
                        <span class="glyphicon glyphicon-plus"></span>
                        <fmt:message key="btn.add"/>
                    </a>
                </p>

                <div class="modal fade" id="${bookModal}" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <br/>
                                <h3 class="modal-title"><b>${book.name}</b></h3>
                            </div>
                            <div class="modal-body">
                                <div class="list-group">
                                    <a class="list-group-item">
                                        <i>${book.description}</i>
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
                            </div>
                            <div class="modal-footer">
                                <a href="${bookAction}true" class="btn btn-primary">
                                        <fmt:message key="btn.buy"/>&ensp;
                                    <fmt:formatNumber value="${book.price}" type="currency"/>
                                </a>
                                <a href="${bookAction}false" class="btn btn-default" title="<fmt:message key="ttl.add.book"/>">
                                    <fmt:message key="btn.add"/>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <jsp:include page="Footer"/>
</div>