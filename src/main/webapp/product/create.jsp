<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Product</title>
  <style>
    .message{
      color:green;
    }
  </style>
</head>
<body>
<h1>Create New Product</h1>
<p>
  <c:if test = '${requestScope["message"] != null}'>
    <span class = "message" >${requestScope["message"]}</span>
  </c:if>
</p>
<p><a href="/products">Back to Product List</a></p>
</body>
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
        <td><input type="submit" value="Create Product"></td>
      </tr>
    </table>
  </field>
</form>
</html>
