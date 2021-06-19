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
				<td>${product.productId}</td>
				<td>${product.productName}</td>
				<td>${product.salesPrice}</td>
				<td><a
					href="<c:url value='/product/edit/${product.productId}'/>">Guncelle</a></td>
				<td><a
					href="<c:url value='/product/delete/${product.productId}'/>">Sil</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value='/product/edit/0'/>">Ekle</a>
</body>
</html>