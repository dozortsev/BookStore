<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="templates/resources.jsp" %>

<title><fmt:message key="signup.tit"/></title>

<link href="css/signin.css" rel="stylesheet" type="text/css">

<div class="container">

    <form:form cssClass="form-signin" action="${path}/Client/Save" method="POST" modelAttribute="newClient">

        <h2 class="form-signin-heading"><fmt:message key="signup.header"/></h2>

        <jsp:include page="Form"/>

        <br/>
        <button type="submit" class="btn btn-lg btn-success btn-block" onclick="alertBookstore('<fmt:message key="signup.msg.alert"/>');">
            <fmt:message key="btn.signup"/>
        </button>

        <a href="${path}/SignIn" class="btn btn-lg btn-primary btn-block">
            <fmt:message key="signup.btn.signin"/>
        </a>
    </form:form>
</div>