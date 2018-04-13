<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zgaze
  Date: 2/7/2018
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <h1>Your profile</h1>
    <div class="profile">
        <p><c:out value="${spitter.username}" /></p>
        <p><c:out value="${spitter.firstname}" /></p>
        <p><c:out value="${spitter.lastname}" /></p>
    </div>

</body>
</html>
