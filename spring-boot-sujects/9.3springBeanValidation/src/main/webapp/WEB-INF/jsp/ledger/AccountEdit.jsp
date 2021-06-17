<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	Ileti : ${message}
	<form:form method="post" modelAttribute="account">
		<form:hidden path="accountId" />
		<form:errors />
		<fieldset class="form-group">
			<form:label path="accountId">Hesap Ozelligi</form:label>
			<form:input path="accountId" type="text" disabled="true" />
			<form:errors path="accountId" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="accountName">Hesap Adi</form:label>
			<form:input path="accountName" type="text" />
			<form:errors path="accountName" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="totalBalance">Toplam Bakiye</form:label>
			<form:input path="totalBalance" type="text" />
			<form:errors path="totalBalance" />
		</fieldset>
		<button type="submit">Sakla</button>
	</form:form>

</body>
</html>