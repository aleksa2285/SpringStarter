<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: Zgaze
  Date: 2/4/2018
  Time: 6:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittles</title>
</head>
<body>
    <c:forEach items="${spittle}" var="spittle" >
        <c:out value="${spittle.id}" />
        <c:out value="${spittle.spitter_id}" />
        <c:out value="${spittle.message}" />
        <c:out value="${spittle.timestamp}" />
        <c:out value="${spittle.latitude}" />
        <c:out value="${spittle.longitude}" />
        <c:out value="${spittle.likes}"/>
    </c:forEach>
</body>
</html>
