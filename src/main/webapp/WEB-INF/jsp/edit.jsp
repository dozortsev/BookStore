<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="templates/resources.jsp" %>

<title>Edit Account</title>

<link href="css/signin.css" rel="stylesheet" type="text/css">

<div class="container">

    <form:form cssClass="form-signin" action="${path}/Client/Update" method="POST" modelAttribute="update">

        <h2 class="form-signin-heading">Edit account</h2>

        <jsp:include page="Form"/>
        <br/>
        <button class="btn btn-lg btn-success btn-block" onclick="alertBookstore('${updateClient}')" type="submit">
            <span class="glyphicon glyphicon-saved"></span>&ensp;Save
        </button>

        <a href="${path}/Client" class="btn btn-lg btn-warning btn-block">
            <span class="glyphicon glyphicon-ban-circle"></span>&ensp;Cancel
        </a>

    </form:form>
</div>

