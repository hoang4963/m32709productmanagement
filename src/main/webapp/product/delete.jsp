<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 9/27/2022
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<h1>Delete Product</h1>
<p><a href="/products"></a>Back to Product List</p>
<form method="post">
  <h3>Are You Sure??</h3>
  <feild>
    <legend>Product Information</legend>
      <table>
        <tr>
          <td>Name: </td>
          <td>${requestScope["product"].getName()}</td>
        </tr>
        <tr>
          <td>Email: </td>
          <td>${requestScope["product"].getCost()}</td>
        </tr>
        <tr>
          <td>Address: </td>
          <td>${requestScope["product"].getDescription}</td>
        </tr>
        <tr>
          <td><input type="submit" value="Delete product"></td>
          <td><a href="/products">Back to product list</a></td>
        </tr>
    </table>
  </feild>
</form>
</body>
</html>
