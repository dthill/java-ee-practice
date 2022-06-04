<%@ page import="java.util.List" %>
<%@ page import="pgfsd.entities.Product" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h1>Products</h1>
<h2>Add New Product</h2>
<form action="products.jsp" method="post">
    <table>
        <tr>
            <td>
                <label for="name">Name</label>
            </td>
            <td>
                <input type="text" name="name" id="name">
            </td>
        </tr>
        <tr>
            <td>
                <label for="price">Price</label>
            </td>
            <td>
                <input type="text" name="price" id="price">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Add Product">
            </td>
        </tr>
    </table>
</form>
<p>
    <jsp:include page="/product-add-controller"></jsp:include>
</p>


<h2>Search Products</h2>
<form action="products.jsp" method="get">
    <label for="search">Search Products</label>
    <input
            type="text" name="search" id="search"
            value="<%=request.getParameter("search") == null ? "" : request.getParameter("search") %>"
    >
    <input type="submit" value="search">
</form>
<table>
    <tr>
        <td>Product ID</td>
        <td>Product Name</td>
        <td>Product Price</td>
        <td>View Details</td>
        <td>Edit Details</td>
    </tr>
    <jsp:include page="/product-list-controller"></jsp:include>
</table>
</body>
</html>
