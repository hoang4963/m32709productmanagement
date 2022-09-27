<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Products</h1>
<p>
    <a href="/products?action=create">Create new product</a>
</p>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Cost</td>
        <td>Edit</td>
        <td>Delete</td>
        <td>Details</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var = "product">
    <tr>
        <td>${product.getId()}</td>
    <td>${product.getName()}</td>
        <td>${product.getCost()}</td>
        <td><a href="/products?action=edit&id=${product.getId()}"></a>Edit</td>
        <td><a href="/products?action=delete&id=${product.getId()}"></a>Delete</td>
        <td><a href="/products?action=detail&id${product.getId()}"></a>Detail</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
