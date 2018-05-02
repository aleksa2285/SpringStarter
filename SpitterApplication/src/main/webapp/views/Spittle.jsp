<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zgaze
  Date: 2/7/2018
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Specific Spittle</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/css/style.css" />">
</head>
<body>
    <div class="spittleView">
        <div class="spittleMessage">
            <c:out value="${spittle.id}" />
            <c:out value="${spittle.spitter_id}" />
            <c:out value="${spittle.message}" />
            <c:out value="${spittle.timestamp}" />
            <c:out value="${spittle.latitude}" />
            <c:out value="${spittle.longitude}" />
            <c:out value="${spittle.likes}"/>
        </div>
            <div class="spittleTime">
                Number of comments:
                <c:out value="${spittle.comments}"/>
            </div>
    </div>
</body>
</html>
