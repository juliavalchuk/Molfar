<%--
  Created by IntelliJ IDEA.
  User: julia
  Date: 22.06.14
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="label.title"/></title>

    <%@ include file="style.html" %>
</head>
<body>

<div data-role="page" id="pageone">
<div data-role="main" class="ui-content">

    <a href="/home" style="text-decoration: none; color : #000000;">

        <img src="http://s019.radikal.ru/i602/1406/85/f00e9d2c1a9a.gif" width="70" align="left"
             style="line-height: 10%; ">

        <span style="font-weight: bold; font-size: 140%; margin-left: 10px"><spring:message code="label.title"/></span>
        <br>
        <span style="font-weight: bold; margin-left: 10px; font-size: 70%"><spring:message code="label.subtitle"/></span>

        </img>
    </a>

    <br>
    <br>

    <div id="id" align="center">
        <p> <h3> <spring:message code="label.result"/> </h3></p>
        <br>
    <c:forEach var="book" items="${books}" varStatus="bookLoopCount">
       ${bookLoopCount.count}. "${book.title}" - ${book.writer}
        <c:if test="${not empty book.year}"> (${book.year}) </c:if>
        <br>
    </c:forEach>
    </div>

    <br>
    <br>

    <a href="questions" data-inline="true" data-role="button" rel="external"><spring:message code="label.startAgain"/></a>
</div>
</div>

</body>
</html>
