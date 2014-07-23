<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" language="javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/jquery.js"></script>
<script type="text/javascript" src="http://www.technicalkeeda.com/js/javascripts/plugin/json2.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Jquery Ajax Demo</title>
<style>
    Table.GridOne {
        padding: 3px;
        margin: 0;
        background: lightyellow;
        border-collapse: collapse;
        width:35%;
    }
    Table.GridOne Td {
        padding:2px;
        border: 1px solid #ff9900;
        border-collapse: collapse;
    }
</style>
<script type="text/javascript">
    function madeAjaxCall(){
        $.ajax({
            type: "post",
            url: "http://localhost:8080/count.htm",
            cache: false,
            data:'index=' + $("#index").val(),
            success: function(response){
                $('#index').val("0");
                var obj = JSON.parse(response);
                $('#index').val(obj);
            },
            error: function(){
                alert('Error while request.. ' + $("#index").val());
           //     $('#index').html("0");
            }
        });
    }
</script>
<body>
<sf:form name="counter" method="post">
    <table cellpadding="0" cellspacing="0" border="1" class="GridOne">
        <tr>
            <td>Counter</td>
            <td><input type="text" name="index" id="index" value=""/>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="button" value="Ajax Submit" onclick="madeAjaxCall();"></td>
        </tr>
    </table>
</sf:form>
<h1>Spring Framework Jquery Ajax Demo</h1>
<div id="result"></div>
</body>
</html>