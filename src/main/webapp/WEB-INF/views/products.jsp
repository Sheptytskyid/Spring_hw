<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pet Shop: Products</title>
</head>
<body>
<a href="/">back</a>
<br>
<h3>Products</h3>
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
    <c:forEach var="product" items="${productslist}">
    <tr>
        <td><a href="/products/${product.id}">${product.id}</a></td>
        <td>${product.name}</td>
        <td>${product.manufacturer}</td>
        <td>${product.price}</td>
        <td>${product.description}</td>
        <td><a href="/products/edit/${product.id}">Edit</a></td>
        <td><a href="/products/delete/${product.id}">Delete</a></td>
    </tr>
    </c:forEach>
</table>
<br>
<h3>Add product</h3>
<c:url var="addAction" value="/products/add"/>

<form:form action="${addAction}" commandName="product">
    <table>
        <c:if test="${!empty product.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="Dd"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="manufacturer">
                    <spring:message text="Manufacturer"/>
                </form:label>
            </td>
            <td>
                <form:input path="manufacturer"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="price">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="price"/>
            </td>
        </tr><tr>
        <td>
            <form:label path="description">
                <spring:message text="Description"/>
            </form:label>
        </td>
        <td>
            <form:input path="description"/>
        </td>
    </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty product.name}">
                    <input type="submit"
                           value="<spring:message text="Edit product"/>"/>
                </c:if>
                <c:if test="${empty product.name}">
                    <input type="submit"
                           value="<spring:message text="Add product"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>