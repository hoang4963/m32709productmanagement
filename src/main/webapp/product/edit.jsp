<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 9/27/2022
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<p><c:if test='${requestScope["message"] != null}'>
  <span class="message">${requestScope["message"]}</span>
</c:if></p>
<p><a href="/products">Back to Product List</a></p>
<form method="post">
  <field>
    <legend>Product Information</legend>
    <table>
        <tr>
            <td>ID</td>
            <td><input type="number" name="id" id="id"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td>Cost</td>
            <td><input type="text" name="cost" id="cost"></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="description" id="description"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update Product"></td>
        </tr>
    </table>
  </field>
</form>
</body>
</html>
