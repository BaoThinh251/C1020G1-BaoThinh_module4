<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 23-Feb-21
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h3>SANDWICH INGREDIENT</h3>
  <form action="choose">
    <table>
      <tr>
        <td>Lettuce<input type="checkbox" name="ingredient" value="lettuce"/></td>
        <td>Tomato<input type="checkbox" name="ingredient" value="tomato"/></td>
        <td>Mustard<input type="checkbox" name="ingredient" value="mustard"/></td>
        <td>Sprout<input type="checkbox" name="ingredient" value="sprout"/></td>
      </tr>
      <tr>
        <td><input type="submit" name="save"/></td>
      </tr>
    </table>
  </form>
  </body>
</html>
