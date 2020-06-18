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

    <c:forEach var="ad" items="${ads}">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h2 class="card-title"><c:out value="${ad.title}" /></h2>
                <p class="card-text"><c:out value="${ad.description}" /></p>
                <a class="btn btn-primary"href="${pageContext.request.contextPath}/ad?id=${ad.id}" class="card-link">View Ad</a>
            </div>
        </div>
    </c:forEach>
    <br>
    <form action="/ads" method="get">
        <a class="btn btn-primary my-2 my-sm-0" type="submit">View All Ads</a>
    </form>

</div>

</body>
</html>
