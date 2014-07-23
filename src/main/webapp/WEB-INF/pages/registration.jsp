<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: julia
  Date: 24.06.14
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<div>
    <h2>Registration</h2>
    <sf:form method="POST" modelAttribute="user">
        <fieldset>
        <table cellspacing="0">
            <tr>
            <th><label for="user_screen_email">Username:</label></th>
                <td><sf:input path="userEmail" id="user_screen_email"/>
                    <sf:errors path="userEmail" cssClass="error" />
        </td> </tr>
            <tr>
                <th><label for="user_password">Password:</label></th>
                <td><sf:password path="password" showPassword="false"  id="user_password"/>
                    <sf:errors path="password" cssClass="error" />
            </td> </tr>
            <tr>
                <th><label for="user_password_confirm">Confirm password:</label></th>
                <td><sf:password path="passwordConfirm" showPassword="false"  id="user_password_confirm"/>
                    <sf:errors path="passwordConfirm" cssClass="error" />
                </td>
            </tr>
            <tr> <th></th>
                <td><input name="commit" type="submit"
                           value="I accept. Create my account." /></td>
            </tr>
        </table> </fieldset>
    </sf:form> </div>
</body>
</html>
