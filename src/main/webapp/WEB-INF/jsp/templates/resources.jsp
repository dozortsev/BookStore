<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%-- JSP Standard Tag Library --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%-- JSP Variables --%>

<c:set value="${pageContext.request.contextPath}" var="path"/>

<head>

    <!-- CSS -->
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">


    <%-- jQuery --%>
    <script src="jquery/jquery-1.10.1.min.js" type="text/javascript"></script>


    <%-- JS --%>
    <script src="js/functions.js" type="text/javascript" ></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>


    <%-- Icon --%>
    <link href="img/icon.png" rel="icon" type="image/png">
</head>



