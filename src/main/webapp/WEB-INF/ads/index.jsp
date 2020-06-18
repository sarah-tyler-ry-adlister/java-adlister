<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here are all the ads!</h1>
<div class="row">
    <c:forEach var="ad" items="${ads}">
    <div class="card col-md-4" style="width: 18rem;">
        <div class="card-body">
            <h2 class="card-title"><c:out value="${ad.title}" /></h2>
            <p class="card-text"><c:out value="${ad.description}" /></p>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/ad?id=${ad.id}" role="button">View Ad</a>
        </div>
    </div>
    </c:forEach>
</div>


</div>

</body>
</html>
