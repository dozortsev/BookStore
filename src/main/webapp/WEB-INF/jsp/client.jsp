<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="templates/resources.jsp" %>

<title>Client / ${client.name} ${client.surname}</title>

<link rel="stylesheet" href="css/jumbotron-narrow.css"/>

<div class="container">

    <div class="header">

        <ul class="nav nav-pills pull-right">
            <li class="active">
                <a href="${path}/toShowcase">
                    <span class="glyphicon glyphicon-shopping-cart"></span>&ensp;Showcase
                </a>
            </li>
            <li>
                <a href="${path}/Edit">
                    <span class="glyphicon glyphicon-pencil"></span>&ensp;Edit
                </a>
            </li>
            <li>
                <a href="${path}/SignIn">
                    <span class="glyphicon glyphicon-off"></span>&ensp;Log Out
                </a>
            </li>
        </ul>
        <h3 class="text-muted">${projectName}</h3>
    </div>

    <div class="jumbotron">
        <div class="row">

            <div class="col-lg-4">
                <img src="img/user.png" width="230" height="210">
            </div>

            <div class="col-lg-8">
                <h3>
                    Name:&ensp;<span class="label label-default">${client.name}</span>
                </h3>
                <h3>
                    Surname:&ensp;<span class="label label-default">${client.surname}</span>
                </h3>
                <h3>
                    <c:if test="${ not empty client.address}">
                        Address:&ensp;<span class="label label-default">${client.address}</span>
                    </c:if>
                </h3>
                <h3>
                    <c:if test="${ not empty client.phone}">
                        Phone:&ensp;<span class="label label-default">${client.phone}</span>
                    </c:if>
                </h3>
                <h3>
                    Email:&ensp;<span class="label label-default">${client.email}</span>
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
                            <span class="glyphicon glyphicon-book"></span>&ensp;
                                ${fn:length(client.cards)}
                        </th>
                        <th>Book</th>
                        <th>Status</th>
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
                                        <span class="glyphicon glyphicon-star"></span>&ensp;Purchased
                                    </td>
                                </c:when><c:otherwise>
                                <td class="active success">
                                    <a href="${cardAction}true">
                                        Buy&ensp;<fmt:formatNumber value="${book.price}" type="currency"/>
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