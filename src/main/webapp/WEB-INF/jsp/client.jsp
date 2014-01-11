<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="templates/resources.jsp" %>

<title>
    <fmt:message key="client.tit"/>
    ${client.name}&ensp;${client.surname}
</title>

<link rel="stylesheet" href="css/jumbotron-narrow.css"/>

<div class="container">

    <div class="header">

        <ul class="nav nav-pills pull-right">
            <li class="active">
                <a href="${path}/toShowcase">
                    <span class="glyphicon glyphicon-shopping-cart"></span>
                    &ensp;<fmt:message key="btn.showcase"/>
                </a>
            </li>
            <li>
                <a href="${path}/Edit">
                    <span class="glyphicon glyphicon-pencil"></span>
                    &ensp;<fmt:message key="btn.edit"/>
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

    <div class="jumbotron">
        <div class="row">

            <div class="col-lg-4" title="<fmt:message key="ttl.client.you"/>">
                <img src="img/user.png" width="230" height="210">
            </div>

            <div class="col-lg-8">
                <h3>
                    <fmt:message key="client.lbl.name"/>
                    &ensp;<span class="label label-default">${client.name}</span>
                </h3>
                <h3>
                    <fmt:message key="client.lbl.surname"/>
                    &ensp;<span class="label label-default">${client.surname}</span>
                </h3>
                <h3>
                    <fmt:message key="client.lbl.joined"/>
                    &ensp;
                    <span class="label label-default">
                        <fmt:formatDate type="both" pattern="yyyy-MM-dd / HH:mm" value="${client.joined}"/>
                    </span>
                </h3>
                <h3>
                    <c:if test="${ not empty client.address}">
                        <fmt:message key="client.lbl.address"/>
                        &ensp;<span class="label label-default">${client.address}</span>
                    </c:if>
                </h3>
                <h3>
                    <c:if test="${ not empty client.phone}">
                        <fmt:message key="client.lbl.phone"/>
                        &ensp;<span class="label label-default">${client.phone}</span>
                    </c:if>
                </h3>
                <h3>
                    <fmt:message key="client.lbl.email"/>
                    &ensp;<span class="label label-default">${client.email}</span>
                </h3>
            </div>
        </div>
    </div>


    <div class="row marketing">

        <c:if test="${ not empty client.cards}">

            <div class="col-lg-12">

                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>
                            <span class="glyphicon glyphicon-book"></span>
                            &ensp;${fn:length(client.cards)}
                        </th>
                        <th><fmt:message key="client.tbl.book"/></th>
                        <th><fmt:message key="client.tbl.status"/></th>
                    </tr>
                    </thead>
                    <c:forEach items="${client.cards}" var="card">

                        <c:set value="${card.book}" var="book"/>
                        <c:set value="${book.author}" var="author"/>

                        <c:set value="${path}/Client/Card/${card.id}/Status/" var="cardAction"/>
                        <tbody>
                        <tr>
                            <td>
                                <a href="${cardAction}false">
                                    <span class="glyphicon glyphicon-remove-circle"></span>
                                </a>
                            </td>
                            <td>
                                    ${book.name}<br/>
                                <b>
                                    <small>${author.name}&ensp;${author.surname}</small>
                                </b>
                            </td>
                            <c:choose>
                                <c:when test="${card.status}">
                                    <td>
                                        <span class="glyphicon glyphicon-star"></span>
                                        &ensp;<fmt:message key="client.tbl.status.pcd"/>
                                    </td>
                                </c:when><c:otherwise>
                                <td class="active success">
                                    <a href="${cardAction}true">

                                        <fmt:message key="btn.buy"/>&ensp;
                                        <fmt:formatNumber value="${book.price}" type="currency"/>
                                    </a>
                                </td>
                            </c:otherwise>
                            </c:choose>
                        </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>
        </c:if>
    </div>

    <jsp:include page="Footer"/>
</div>