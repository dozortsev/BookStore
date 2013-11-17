<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
        <meta charset="utf-8">

        <title>Sign Up</title>

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="css/signin.css" rel="stylesheet" type="text/css">

        <link href="img/icon.png" rel="icon" type="image/png">
</head>
<body>

<div class="container">

        <form:form cssClass="form-signin" action="./SignUp" method="POST">

                <h2 class="form-signin-heading">Create account</h2>

                <input type="text" name="name" class="form-control" placeholder="Name" autofocus>
                <input type="text" name="surname" class="form-control" placeholder="Surname">
                <input type="text" name="email" class="form-control" placeholder="Email" required>
                <input type="password" name="pwd" class="form-control" placeholder="Password" required>

                <input type="submit" class="btn btn-lg btn-success btn-block" value="Sign Up">
        </form:form>
</div>

</body>
</html>