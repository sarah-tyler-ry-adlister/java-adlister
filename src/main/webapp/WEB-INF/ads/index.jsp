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
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h2> class="card-title">${ad.title}</h2>
            <p class="card-text">${ad.description}</p>
            <a href="${pageContext.request.contextPath}/ad?id=${ad.id}" class="card-link">View Ad</a>
        </div>
    </div>
    </c:forEach>


</div>

</body>
</html>
