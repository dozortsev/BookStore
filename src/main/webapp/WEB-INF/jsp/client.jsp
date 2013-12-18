<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="templates/resources.jsp" %>

<title>Client / ${client.name} ${client.surname}</title>

<div class="container">

    <a href="${path}/toShowcase">Showcase</a>
    <a href="${path}/Edit">Edit</a>
    <a href="${path}/SignIn">Log Out</a>

    Name: ${client.name}
    <br/>
    Surname: ${client.surname}
    <br/>
    Email: ${client.email}

    <c:if test="${ not empty client.cards}">
        <br/><br/>
        <table border="1">
            <tr>
                <td>
                    <span class="glyphicon glyphicon-book"></span>${fn:length(client.cards)}
                </td>
                <td>Book</td>
                <td>Status</td>
            </tr>
            <c:forEach items="${client.cards}" var="card">

                <c:set value="${card.book}" var="book"/>
                <c:set value="${book.author}" var="author"/>

                <c:set value="${path}/Client/Card/${card.id}/Status/" var="cardAction"/>
                <tr>
                    <td>
                        <a href="${cardAction}false">
                            <span class="glyphicon glyphicon-remove-circle"></span>
                        </a>
                    </td>
                    <td>${book.name}<br/>
                        <b>
                            <small>${author.name}&ensp;${author.surname}</small>
                        </b>
                    </td>
                    <c:choose>
                        <c:when test="${card.status}">
                            <td>
                                Purchased !
                            </td>
                        </c:when><c:otherwise>

                        <td class="active">
                            <a href="${cardAction}true">
                                Buy <fmt:formatNumber value="${book.price}" type="currency"/>
                            </a>
                        </td>
                    </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>