<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="templates/resources.jsp" %>

<c:choose>
    <c:when test="${page eq 'bookstore'}">

        <c:set value="${client}" var="client" scope="session"/>
        <c:set value="${bookList}" var="books" scope="session"/>

        <c:redirect url="/Showcase"/>
    </c:when>

    <c:when test="${page eq 'client'}">

        <c:set value="${client}" var="client" scope="session"/>

        <c:redirect url="/Client"/>
    </c:when>
</c:choose>





