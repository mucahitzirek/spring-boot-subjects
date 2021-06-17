<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">

		<c:forEach var="product" items="#{products}">

			<tr>
				<td>${product.productId }</td>
				<td>${product.productName}</td>
				<td>${product.salesPrice }</td>
				<td><c:choose>
						<c:when test="${product.salesPrice > 3000 }"> Pahali</c:when>
						<c:otherwise>Ucuz</c:otherwise>
					</c:choose></td>
			</tr>

		</c:forEach>

	</table>
</body>
</html>