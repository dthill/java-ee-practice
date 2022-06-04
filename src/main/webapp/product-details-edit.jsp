<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product Details</title>
</head>
<body>
<h1>Edit Product Details</h1>
<form action="product-details-edit.jsp" method="post">
    <table>
        <tr>
            <td><label for="description">description</label>
            </td>
            <td><input type="text" name="description" id="description"/>
            </td>
        </tr>
        <tr>
            <td><label for="origin">origin</label>
            </td>
            <td><input type="text" name="origin" id="origin"/>
            </td>
        </tr>
        <tr>
            <td><label for="transport">transport</label>
            </td>
            <td><input type="text" name="transport" id="transport"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Save">
            </td>
        </tr>
    </table>
</form>
<table>
    <tr>
        <jsp:include page="/product-details-controller"></jsp:include>
    </tr>
</table>
</body>
</html>
