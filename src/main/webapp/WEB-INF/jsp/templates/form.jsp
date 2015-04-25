<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="resources.jsp" %>

<input name="id" type="hidden" value="${client.id}">

<div class="input-group">

    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
    <input type="text" name="name" class="form-control" value="${client.name}" placeholder="Name *"
           maxlength=100 required>
</div>
<div class="input-group">

    <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
    <input type="text" name="surname" class="form-control" value="${client.surname}" placeholder="Surname *"
           maxlength=100 required>
</div>
<div class="input-group">
    <span class="input-group-addon"><span class="glyphicon glyphicon-map-marker"></span></span>
    <input type="text" name="address" class="form-control" value="${client.address}"
           placeholder="Address [Country, City]" maxlength=200>
</div>
<div class="input-group">

    <span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
    <input type="text" name="phone" class="form-control" value="${client.phone}"
           placeholder="Phone number" maxlength=10>
</div>
<div class="input-group">

    <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
    <input type="text" name="email" class="form-control" value="${client.email}" placeholder="Email *"
           maxlength=200 required>
</div>
<div class="input-group">

    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
    <input type="text" name="password" class="form-control" value="${client.password}"
           placeholder="Password *" maxlength=15 required>
</div>
