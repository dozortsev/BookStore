<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="templates/resources.jsp" %>

<title><fmt:message key="edit.tit"/></title>

<link href="css/signin.css" rel="stylesheet">

<div class="container">

    <form:form cssClass="form-signin" action="${path}/Client/Update" method="POST" modelAttribute="update">

        <h2 class="form-signin-heading"><fmt:message key="edit.tit"/></h2>

        <jsp:include page="Form"/>
        <br/>
        <button class="btn btn-lg btn-success btn-block" title="<fmt:message key="ttl.save"/>"
                onclick="alertBookstore('<fmt:message key="edit.msg.alert"/>')" type="submit">
            <fmt:message key="btn.save"/>
        </button>

        <a href="${path}/Client" class="btn btn-lg btn-primary btn-block">
            <fmt:message key="btn.cancel"/>
        </a>
    </form:form>
</div>

