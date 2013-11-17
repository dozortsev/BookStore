<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
        <meta charset="utf-8">

        <link href="img/icon.png" rel="icon" type="image/png">
        <title>Sign In</title>

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/signin.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="container">

        <form:form cssClass="form-signin" action="./SignIn" method="POST">

                <h2 class="form-signin-heading">Please sign in</h2>

                <input type="text" name="email" class="form-control" placeholder="Email" required autofocus>
                <input type="password" name="pwd" class="form-control" placeholder="Password" required="">

                <input type="submit" class="btn btn-lg btn-success btn-block" value="Sign In">

                <a href="./CreateAccount" class="btn btn-lg btn-primary btn-block" type="submit">
                        Sign Up for BookStore
                </a>

        </form:form>
</div>
</body>
</html>
