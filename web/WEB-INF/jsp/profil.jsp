<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<link rel="stylesheet" media="all" type="text/css" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" >

<h1>My Profile</h1>
<table >
    <tr>
        <td>Nama Lengkap</td>
        <td>:</td>
        <td>${admin.getNamaLengkap()}</td>
    </tr>
    <tr>
        <td>Username</td>
        <td>:</td>
        <td>${admin.getUsername()}</td>
    </tr>
</table>

<hr/>

        <form:form action="${pageContext.request.contextPath}/admin/profil/update/${admin.getLevel().getLevel()}/${admin.getIdAdmin()}" modelAttribute="profilBean" method="post">
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
            <form:button name="Update" value="Update" class="btn btn-primary" >
                <i class="fa fa-edit" ></i>
                Update
            </form:button>
        </div>

</form:form>