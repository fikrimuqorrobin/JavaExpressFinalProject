<%-- 
    Document   : insertPengiriman
    Created on : Dec 29, 2017, 9:27:02 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Input Pengiriman</title>

        <script>
            var cek = '${validator}';
            if (cek.length > 0) {
                alert(cek);
            }
        </script>   

        <style>
            .error {
                color: red; font-weight: bold; font-style: normal;
            }
        </style>
    </head>
    <%--<jsp:include page="menu_staff.jsp"/>--%>
    <body>

        <jsp:include page="menu_staff.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <br>
            <h3>Form Input Pengiriman</h3>
            <hr>
            <form:form action="InsertP" modelAttribute="fp" method="Post">
                <div class="form-group">
                    <label>Nama Penerima  <form:errors path="namaPenerima" cssClass="error"/></label>
                    <form:input class="form-control" path="namaPenerima"></form:input> 
                </div>
                <div class="form-group">
                    <label>Alamat Penerima  <form:errors path="alamatPenerima" cssClass="error"/></label>
                    <form:input class="form-control" path="alamatPenerima"></form:input>
                </div>
                <div class="form-group">
                    <label>Kota Penerima  </label>
                    <form:select class="form-control" path="kotaPenerima" items="${kotaAsal}"></form:select>
                </div>
                <div class="form-group">
                    <label>Telepon Penerima  <form:errors path="teleponPenerima" cssClass="error"/></label>
                    <form:input class="form-control" path="teleponPenerima"></form:input> 
                </div>
                <div class="form-group">
                    <label>Nama Pengirim  <form:errors path="namaPengirim" cssClass="error"/></label>
                    <form:input class="form-control" path="namaPengirim"></form:input>
                </div>
                <div class="form-group">
                    <label>Alamat Pengirim  <form:errors path="alamatPengirim" cssClass="error"/></label>
                    <form:input class="form-control" path="alamatPengirim"></form:input> 
                </div>
                <div class="form-group">
                    <label>Kota Pengirim</label>
                    <form:select class="form-control" path="kotaPengirim" items="${kotaTujuan}" value= "${kotaTujuan}" onchange="tampil(value)"></form:select>
                </div>
                <div class="form-group">
                    <label>Telpon Pengirim  <form:errors path="teleponPengirim" cssClass="error"/></label>
                    <form:input class="form-control" path="teleponPengirim"></form:input> 
                </div>
                <div class="form-group">
                    <label>Asuransi</label>
                    <div class="radio">
                        <label>
                            <form:radiobutton path="asuransi" value="Y"/> Ya 
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <form:radiobutton path="asuransi" value="T"/> Tidak
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label>Berat Barang</label>
                    <form:input class="form-control" path="beratBarang"></form:input>
                </div>
                <div class="form-group">
                    <label>Harga Barang</label>
                    <form:input class="form-control" path="hargaBarang"></form:input>
                </div>
                <div class="form-group">
                    <label>Jenis Layanan  <form:errors path="jenisLayanan" cssClass="error"/></label>
                    <form:select class="form-control" path="jenisLayanan" items="${jenisLayanan}"></form:select>
                </div>
                <div class="form-group">
                    <label>Nama Paket  <form:errors path="namaPaket" cssClass="error"/></label>
                    <form:input class="form-control" path="namaPaket"></form:input> 
                </div>
                <div class="form-group">
                    <label>Tipe Paket  <form:errors path="tipePaket" cssClass="error"/></label>
                    <form:input class="form-control" path="tipePaket"></form:input> 
                </div>
                <div class="form-group">
                    <form:button path="buttonInsertP" class="btn btn-primary">
                        <i class="fa fa-pencil"></i> Submit
                    </form:button>
                </div>
                   
        </form:form>
        </div>
    </div>
</div>
       
    </body>
</html>
