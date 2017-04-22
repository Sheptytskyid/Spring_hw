<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pet Shop: Product</title>
</head>
<body>
<a href="/products">back</a>
<br>
<h3>Product: ${product.name}</h3>
<table style="align-items: center">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Manufacturer</th>
        <th>Price</th>
        <th>Description</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.manufacturer}</td>
        <td>${product.price}</td>
        <td>${product.description}</td>
        <td><a href="/products/edit/${product.id}">Edit</a> </td>
        <td><a href="/products/delete/${product.id}">Delete</a> </td>
    </tr>
</table>
</body>
</html>
