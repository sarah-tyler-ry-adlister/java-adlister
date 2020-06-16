<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Search Result" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here is your search result:</h1>

    <div class="col-md-12">
        <h2>${ads.title}</h2>
        <p>${ads.description}</p>
<%--        <p>Created by user: ${adCreator.username}</p>--%>
<%--        <p>User email: ${adCreator.email}</p>--%>
    </div>
</div>

</body>
</html>
