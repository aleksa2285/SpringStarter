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
    <c:forEach items="${spittleList}" var="spittle" >
        <li id="spittle_<c:out value="spittle.id"/>">
            <div class="spittleMessage">
                <c:out value="${spittle.message}"/>
            </div>
                <div>
                    <span class="spittleTime"><c:out value="${spittle.time}"/></span>
                    <span class="spittleLocation">
                        (<c:out value="${spittle.latitude}" />,
                        <c:out value="${spittle.longitude}"/>)
                    </span>
                </div>
        </li>
    </c:forEach>
</body>
</html>
