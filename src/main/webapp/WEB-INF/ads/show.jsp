<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing One Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here is your ad!</h1>

    <div class="col-md-12">
        <h2><c:out value="${ad.title}"/></h2>
        <p><c:out value="${ad.description}"/></p>
        <p>Created by user: <c:out value="${adCreator.username}"/></p>
        <p>User email: <c:out value="${adCreator.email}"/></p>
    </div>

<%--    <a class="btn btn-primary" href="${pageContext.request.contextPath}/ads/update?id=${ad.id}" role="button">Update Ad</a>--%>
<%--    <br>--%>
<%--    <br>--%>

    <form action="/ads" method="get">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">View All Ads</button>
    </form>
</div>

</body>
</html>
