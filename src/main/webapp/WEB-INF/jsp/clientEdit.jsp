<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="resources.jsp" %>

<html>
<head>
    <link href="img/icon.png" rel="icon" type="image/png">
    <title>Edit / ${client.name} ${client.surname}</title>

    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="css/signin.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="container">

    <form:form cssClass="form-signin" action="${contextPath}/Client/Update" method="POST" modelAttribute="clientEdit" commandName="client">

        <h2 class="form-signin-heading">Edit account</h2>

        <form:hidden path="id" />

        Name
        <form:input path="name" cssClass="form-control" placeholder="Name" maxlength="100" autofucus="true" required="true" />
        <br/>
        Surname
        <form:input path="surname" cssClass="form-control" placeholder="Surname" maxlength="100" required="true" />
        <br/>
        Email
        <form:input path="email" cssClass="form-control" placeholder="Email" maxlength="200" required="true" />
        <br/>
        Password
        <form:input path="password" cssClass="form-control" placeholder="Password" maxlength="15" required="true" />
        <br/><br/>

        <input type="submit" class="btn btn-lg btn-success btn-block" value="Save"/>

    </form:form>
</div>

</body>
</html>
