<%--
  Created by IntelliJ IDEA.
  User: julia
  Date: 22.06.14
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=utf-8"  language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
    <script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">


    <title><spring:message code="label.title"/></title>



    <script type="text/javascript">
        function madeAjaxCall(id){
            $.ajax({
                type: "post",
                url: "http://localhost:8080/answer.htm",
                cache: false,
                mimeType: "text/html; charset=UTF-8",
                data:'answer=' + id,
                success: function(response) {
                    if (response == "results") {
                        window.location.href = "http://localhost:8080/results";
                    } else {
                        $("#questionspan").html(response);
                    }
                },
                error: function(){
               //     alert('Error while request.. ');
                    //     $('#index').html("0");
                }
            });
        }
    </script>


    <%@ include file="style.html" %>

</head>
<body>
<div data-role="page" id="questions">

<div data-role="main" class="ui-content">
    <a href="/home" style="text-decoration: none; color : #000000;">

        <img src="http://s019.radikal.ru/i602/1406/85/f00e9d2c1a9a.gif" width="70" align="left"
             style="line-height: 10%; ">

        <span style="font-weight: bold; font-size: 140%; margin-left: 10px"><spring:message code="label.title"/></span>
        <br>
        <span style="font-weight: bold; margin-left: 10px; font-size: 70%"><spring:message code="label.subtitle"/></span>

        </img>
    </a>
    </div>

        <div id="qdiv" align="center">
            <form name="counter" method="post">

                <%--<p><label id="questionid">${question}</label></p>--%>
                <p><span id="questionspan" style="font-weight:bold">${question_param}</span></p>
                <br>
                <input type="button"  value= "<spring:message code="label.yes"/>"  onclick="madeAjaxCall(1)">

                 <input type="button" value= "<spring:message code="label.no"/>" onclick="madeAjaxCall(2)">

                 <input type="button" value= "<spring:message code="label.doesNotMatter"/>" onclick="madeAjaxCall(3)">

            </form>
        </div>

</div>
</body>
</html>
