<%  if (session.getAttribute("admin") == null) { %>

<jsp:forward page="login.jsp"></jsp:forward>

<%  } else { %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="all" type="text/css" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" >
        <title>Java Express</title>
    </head>

    <body>
        <!--<h1>Home</h1>-->

        <%  if (session.getAttribute("level").equals("master")) { %>
        <jsp:include page="menu_master.jsp"></jsp:include>
        <%  } else if (session.getAttribute("level").equals("staff")) { %>
        <jsp:include page="menu_staff.jsp"></jsp:include>
        <%  } %> 
        
        <br/>
        <div class="container">
            <jsp:include flush="true" page="${file}"></jsp:include>
        </div>
        
        

        </body>
    </html>

<% }%>
