<%@ page import="java.util.List" %>
<%@ page import="pgfsd.bean.Product" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h1>Products</h1>
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
    </tr>
    <jsp:include page="/products-controller"></jsp:include>
</table>
</body>
</html>
