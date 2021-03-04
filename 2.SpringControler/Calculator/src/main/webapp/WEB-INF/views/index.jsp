<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 23-Feb-21
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="calculate">
    <table border="1px" style="text-align: center">
        <tr>
            <td colspan="2"><input type="number" name="number1" value="0" placeholder="number 1"/></td>
            <td colspan="2"><input type="number" name="number2" value="0" placeholder="number 2"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="sign" value="plus"/></td>
            <td><input type="submit" name="sign" value="minus"/></td>
            <td><input type="submit" name="sign" value="time"/></td>
            <td><input type="submit" name="sign" value="divide"/></td>
        </tr>
    </table>
</form>
<h2>${result}</h2>
</body>
</html>
