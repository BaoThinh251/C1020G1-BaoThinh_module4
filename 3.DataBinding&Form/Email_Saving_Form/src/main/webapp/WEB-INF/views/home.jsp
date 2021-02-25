<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 24-Feb-21
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="save" method="post">
    <table border="1px">
        <tr>
            <td>Language: </td>
            <td>
                <form:select path="language">
                    <form:options items="${language}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page size: </td>
            <td>Show
<%--                <form:select path="page_size">--%>
<%--                    <form:options items="${size}"/>--%>
<%--                    <form:options items="${size}"/>--%>
<%--                    <form:options items="${size}"/>--%>
<%--                    <form:options items="${size}"/>--%>
<%--                    <form:options items="${size}"/>--%>
<%--                    <form:options items="${size}"/>--%>
<%--                    <form:options items="${size}"/>--%>
<%--                </form:select>--%>
            </td>
        </tr>
<%--        <tr>--%>
<%--            <td>Spam filter: </td>--%>
<%--            <td>--%>
<%--                <form:checkbox path="filter"></form:checkbox/> Enable spams filter--%>
<%--            </td>--%>
<%--        </tr>--%>
        <tr>
            <td>Signature: </td>
            <td>
<%--                <form:textarea path="signature"/>--%>
            </td>
        </tr>
    </table>

    <input type="submit" value="Create">
</form:form>
</body>
</html>
