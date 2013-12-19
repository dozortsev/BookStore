<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%-- JSP Standard Tag Library --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%-- JSP Variables --%>

<c:set value="${pageContext.request.contextPath}" var="path"/>

<c:set value="BookStore" var="projectName" />

<c:set value="You bought book Thank you" var="thxForBook"/>

<c:set value="You never alone when you read a book" var="quote" />

<c:set value="Your account successfully updated" var="updateClient" />

<c:set value="Welcome on Book Store. Now please sign in." var="welcome" />


<%-- JS --%>

<script src="js/functions.js"></script>


<!-- CSS -->

<link href="css/style.css" rel="stylesheet" type="text/css">

<link href="css/bootstrap.css" rel="stylesheet" type="text/css">

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">



<%-- Icon --%>

<link href="img/icon.png" rel="icon" type="image/png">



