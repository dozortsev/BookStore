<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="templates/resources.jsp" %>

<title>Sign In</title>

<link href="css/signin.css" rel="stylesheet" type="text/css">

<c:remove var="client" scope="session"/>
<c:remove var="books" scope="session"/>

<div class="container">

    <form:form cssClass="form-signin" action="${path}/Welcome" method="POST">

        <h2 class="form-signin-heading">Please sign in</h2>

        <input type="text" name="email" class="form-control" placeholder="Email *" maxlength=200 required autofocus>
        <input type="password" name="pwd" class="form-control" placeholder="Password *" maxlength=15 required>

        <input type="submit" class="btn btn-lg btn-success btn-block" value="Sing In">

        <a href="${path}/SignUp" class="btn btn-lg btn-primary btn-block">
            Sign Up for ${projectName}
        </a>
    </form:form>
</div>
