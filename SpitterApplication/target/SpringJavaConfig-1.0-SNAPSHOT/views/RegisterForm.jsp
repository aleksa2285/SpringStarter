<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Zgaze
  Date: 2/7/2018
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/css/style.css" />">
</head>
<body>
    <h1>Register</h1>
        <div class="registrationForm">
            <sf:form method="POST" commandName="spitter" enctype="multipart/form-data">
                <sf:label path="firstname" cssErrorClass="error"/>First name: <sf:input path="firstname"/> <br/>
                <sf:errors path="firstname" cssClass="error"/> <br/>
                <sf:label path="lastname" cssErrorClass="error"/>Last name: <sf:input path="lastname" cssClass="error"/> <br/>
                <sf:errors path="lastname" cssClass="error"/> <br/>
                <sf:label path="username" cssErrorClass="error"/>Username: <sf:input path="username" cssClass="error"/> <br/>
                <sf:errors path="username" cssClass="error"/> <br/>
                <sf:label path="password" cssErrorClass="error"/>Password: <sf:input path="password" cssClass="error"/> <br/>
                <sf:errors path="password"/> <br/>
                <sf:label path="profilePicture" cssErrorClass="error"/> Profile picture: <sf:input path="profilePicture"
                                                                                                   type="file"
                                                                                                   name="profilePicture"
                                                                                                   accept="image/png, image/jpg, image/jpeg, image/gif"/>
                <br/>
                <input type="submit" value="Register"/>
            </sf:form>
        </div>
</body>
</html>
