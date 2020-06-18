<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Error" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <div class="alert alert-danger" role="alert">
            Action failed. Please try again.
        </div>
        <div>
            <a class="btn btn-primary" href="/register">Register</a>
            <a class="btn btn-primary" href="/ads/create">Create Ad</a>
        </div>
    </div>
</body>
</html>
