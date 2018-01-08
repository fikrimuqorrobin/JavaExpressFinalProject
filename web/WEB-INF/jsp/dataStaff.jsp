<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="page-wrapper">
    <div class="container-fluid">

        <div class="row">
            <div class="col-lg-12">
                <h2>Data Staff</h2>
                <div class="table-responsive">
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Nama Staff</th>
                                <th>Option</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach varStatus="no" var="s" items="${staff}">
                                <tr>
                                    <td>${no.count}</td>
                                    <td>${s.getNamaLengkap()}</td>
                                    <td>
                                        <div class="btn-group-justified">
                                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/profil/${s.getIdAdmin()}">
                                                <i class="fa fa-edit"></i>
                                                Edit
                                            </a>
                                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/admin/hapus/staff/${s.getIdAdmin()}" onclick="return confirm('Yakin Akan Menghapus Data ?')">
                                                <i class="fa fa-trash-o"></i>
                                                Hapus
                                            </a>
                                        </div>


                                    </td>
                                </tr>

                            </c:forEach>

                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>
</div>