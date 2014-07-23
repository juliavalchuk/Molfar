<%--
  Created by IntelliJ IDEA.
  User: julia
  Date: 22.06.14
  Time: 01:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
    <script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>
            <spring:message code="label.title"/>
    </title>

    <%@ include file="style.html" %>

    <%--<script type="text/javascript">--%>
        <%--$("#questions").on("click", function(){ 		$.mobile.changePage("/questions");  	});--%>
    <%--</script>--%>
</head>
<body>

<div data-role="page" id="pageone">

    <div data-role="header">
        <div class="lang" align="right">
            <span style=" margin-right:50px;">
                <a href="?lang=en">
                    <img src="http://www.novisad.org/wp-content/plugins/global-translator-pro/flag_en.png">
                    <%--../resources/images/flag_en.png--%>
                </a>
                <a href="?lang=uk">
                    <img src="http://ndidbms.kharkiv.com/theme/img/ua.gif">
                    <%--http://ndidbms.kharkiv.com/theme/img/ua.gif--%>
                </a>
                <a href="?lang=ru">
                    <img src="http://ndidbms.kharkiv.com/theme/img/ru.gif">
                </a>
            </span>
        </div>
    </div>

    <div data-role="main" class="ui-content" align="center">

        <br/>
        <br/>
        <br/>

        <div id="header" align="center" style="width: 400px">

            <img src="http://s019.radikal.ru/i602/1406/85/f00e9d2c1a9a.gif" width="100" align="left">

            <span style="font-weight: bold; font-size: 40pt; margin-left: 10px"><spring:message code="label.title"/></span>
            <br>
            <span style="font-weight: bold; margin-left: 30pt"><spring:message code="label.subtitle"/></span>


            </img>
        </div>

    <%--<form method="get" action="${pageContext.servletContext.contextPath}/questions">--%>

            <%--<input type="submit" data-inline="true" value="<spring:message code="label.start"/>" >--%>

    <%--</form>--%>
        <br/>
        <br/>
        <br/>

    <a href="/questions" data-inline="true" data-role="button" rel="external"><spring:message code="label.start"/></a>

    <%--<a href="#question" class="ui-btn">Go to Page Two</a>--%>
</div>
</div>

</body>
</html>
