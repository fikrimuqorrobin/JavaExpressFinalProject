<%-- 
    Document   : UpdateTarif
    Created on : Dec 30, 2017, 7:12:28 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">  
            <jsp:include page="menu_staff.jsp"/>
            <br>
              <h3>Update Data Kota</h3>
              <hr>
            <form:form action="${pageContext.request.contextPath}/admin/updateTarif/${atrb.idTarif}" modelAttribute="TarifBean" method="POST">
                <table>
                    <tr> 
                        <td><form:label path="kotaAsal">Kota Asal</form:label></td>
                        <td><input type="text" value="${atrb.kotaAsal.getNamaKota()}"></td>
                        <td hidden="true"><form:input class="form-control" path="kotaAsal" value="${atrb.kotaAsal.getKodeKota()}" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="kotaTujuan">Kota Tujuan</form:label></td>
                        <td><input type="text" value="${atrb.kotaTujuan.getNamaKota()}"></td>
                        <td hidden="true"><form:input class="form-control" path="kotaTujuan" value="${atrb.kotaTujuan.getKodeKota()}" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="reguler">Harga Reguler</form:label></td>
                        <td><form:input class="form-control" path="reguler" value="${atrb.reguler}"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="kilat">Harga Kilat</form:label></td>
                        <td><form:input class="form-control" path="kilat" value="${atrb.kilat}"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="ons">Harga ONS</form:label></td>
                        <td><form:input class="form-control" path="ons" value="${atrb.ons}"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="sds">Harga SDS</form:label></td>
                        <td><form:input class="form-control" path="sds" value="${atrb.sds}"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="hds">Harga HDS</form:label></td>
                        <td><form:input class="form-control" path="hds" value="${atrb.hds}"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="createdBy">Create By</form:label></td>
                        <td><input type="text" class="form-control" value="${atrb.createdBy.getNamaLengkap()}"/>
                        <form:input class="form-control" path="createdBy" value="${atrb.createdBy.getIdAdmin()}" hidden="true"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="createdTime">Create Time</form:label></td>
                        <td><form:input class="form-control"  path="createdTime" value="${atrb.createdTime}" readonly="true"/></td>
                    </tr>
                    <tr hidden="true">
                        <td><form:label path="updatedBy">Update By</form:label></td>
                        <td><form:input class="form-control" path="updatedBy" value="${admin.getIdAdmin()}" readonly="true"/></td><!--Ambil admin dari session-->
                    </tr>
                    <tr hidden="true">
                        <td><form:label path="status">Status</form:label></td>
                        <td><form:input class="form-control" path="status" value="${atrb.status.getIdStatus()}"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right">
                            <a class="btn btn-warning" href="${pageContext.request.contextPath}/admin/tarif">Kembali</a>
                            <form:button class="btn btn-success" name="submitButton" value="Submit">Update</form:button>
                            </td>
                        </tr>
                    </table>
            </form:form>
        </div>
    </body>
</html>