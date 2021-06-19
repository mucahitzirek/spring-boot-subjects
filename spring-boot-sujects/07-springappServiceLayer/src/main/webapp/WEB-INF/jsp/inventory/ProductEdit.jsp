<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form method="post" modelAttribute="product">
		<form:errors />

		<fieldset class="form-group">
			<form:label path="productId">Urun Ozelligi</form:label>
			<form:input path="productId" type="text" disabled="true" />
			<form:errors path="productId" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="productName">Urun Adi</form:label>
			<form:input path="productName" type="text" />
			<form:errors path="productName" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="salesPrice">Satis Ederi</form:label>
			<form:input path="salesPrice" type="text" />
			<form:errors path="salesPrice" />
		</fieldset>

		<button type="submit">Sakla</button>

	</form:form>

</body>
</html>