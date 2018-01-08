<%-- 
    Document   : SelectPengiriman
    Created on : Dec 30, 2017, 6:14:15 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
       
        <title>Daftar Pengiriman</title>
        <%@taglib  prefix="list" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <jsp:include page="menu_staff.jsp"/>
        <div class="container">
            
        <br>
        <h3>Status Pengiriman</h3>
        <hr>
        <div>
            <table class="table table-hover">
                <thead>
                    <tr>     
                        <th> ID Pengiriman</th>
                        <th> Nomor Resi </th>
                        <th> Nama Penerima </th>
                        <th> Nama Pengirim </th>
                        <th> Total Tarif </th>
                        <th> Status </th>
                    </tr>
                </thead>
                <tbody>
                    <list:forEach items="${list}" var="a">
                    <tr>
                        <td>
                            ${a.getIdPengiriman()}
                        </td>
                        <td>
                            ${a.getNoResi()}
                        </td>
                        <td>
                            ${a.getNamaPenerima()}    
                        </td>
                        <td>
                            ${a.getNamaPengirim()}   
                        </td>
                        <td>
                            ${a.getTotalTarif()}
                        </td>
                        <td>
                            <a class="btn btn-success" href="StatusPengiriman?status=${a.getStatus().getStatus()}&ID=${a.getIdPengiriman()}">${a.getStatus().getStatus()}</a>
                        </td>
                    </tr>
                </list:forEach>
                </tbody>
               
                

            </table>  
        </div>
        </div>
    </body>
</html>
