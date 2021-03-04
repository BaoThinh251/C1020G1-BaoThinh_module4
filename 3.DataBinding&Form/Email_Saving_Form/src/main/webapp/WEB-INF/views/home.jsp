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

<form action="save" method="post">
    <table>
        <tr>
            <td>Language:</td>
            <td>
                <select name="language">
                    <option value="English">English</option>
                    <option value="Vietnamese">Vietnamese</option>
                    <option value="Japanese">Japanese</option>
                    <option value="Chinese">Chinese</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Page size:</td>
            <td>
                Show
                <select name="page">
                    <option value="5">5</option>
                    <option value="10">10</option>
                    <option value="15">15</option>
                    <option value="20">20</option>
                    <option value="25">25</option>
                    <option value="50">50</option>
                    <option value="100">100</option>
                </select>
                Email per page.
            </td>
        </tr>
        <tr>
            <td>Spams filter:</td>
            <td><input type="checkbox" name="spam"> Enable Spams Filter</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td>
                <input type="text" name="signature">
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="save" name="save"></td>
            <td><input type="reset" value="cancel" name="cancel"></td>
        </tr>
    </table>
</form>
</body>
</html>
