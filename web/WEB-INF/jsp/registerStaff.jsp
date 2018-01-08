<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Input Staff</h1>

<form:form action="${pageContext.request.contextPath}/admin/input/staff/save" method="post" modelAttribute="registerBean" >
    <div class="form-group">
        <form:label path="nama">Nama Lengkap</form:label>
        <form:input class="form-control" path="nama" required="true"></form:input>
        </div>
        <div class="form-group">
        <form:label path="username">Username</form:label>
        <form:input class="form-control" path="username" required="true"></form:input>
        </div>
        <div class="form-group">
        <form:label path="password">Password</form:label>
        <form:password class="form-control" path="password" required="true"></form:password>
        </div>
        <div class="form-group">
        <form:button name="submitButton" value="Submit" class="btn btn-success" >
            <i class="fa fa-save"></i>
            Save
        </form:button>
    </div>

</form:form>