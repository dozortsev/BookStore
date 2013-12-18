<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="templates/resources.jsp" %>

<html>
<head>
    <title>Sign Up</title>

    <link href="css/signin.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="container">

    <form:form cssClass="form-signin" action="${path}/Welcome" method="POST">

        <h2 class="form-signin-heading">Create account</h2>

        <input type="text" name="name" class="form-control" placeholder="Name" maxlength=100 required autofocus>
        <input type="text" name="surname" class="form-control" placeholder="Surname" maxlength=100 required>
        <input type="text" name="email" class="form-control" placeholder="Email" maxlength=200 required>
        <input type="password" name="password" class="form-control" placeholder="Password" maxlength=15 required>

        <input type="submit" class="btn btn-lg btn-success btn-block" value="Sign Up">
    </form:form>
</div>

</body>
</html>