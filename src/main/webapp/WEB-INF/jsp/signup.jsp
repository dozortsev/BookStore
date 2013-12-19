<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="templates/resources.jsp" %>

<title>Sign Up</title>

<link href="css/signin.css" rel="stylesheet" type="text/css">

<div class="container">

    <form:form cssClass="form-signin" action="${path}/Client/Save" method="POST" modelAttribute="newClient">

        <h2 class="form-signin-heading">Create account</h2>

        <jsp:include page="Form"/>

        <br/>
        <input type="submit" class="btn btn-lg btn-success btn-block" onclick="alertBookstore('${welcome}');"
               value="Sign Up"/>

        <a href="${path}/SignIn" class="btn btn-lg btn-primary btn-block">
            I have account
        </a>
    </form:form>
</div>