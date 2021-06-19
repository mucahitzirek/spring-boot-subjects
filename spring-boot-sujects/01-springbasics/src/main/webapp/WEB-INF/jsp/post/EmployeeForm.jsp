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

	<form:form method="post" modelAttribute="employee">
		<form:errors />

		<fieldset class="form-group">
			<form:label path="employeeId">Calisan Ozelligi</form:label>
			<form:input path="employeeId" type="text" disabled="true" />
			<form:errors path="employeeId" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="employeeName">Calisan Adi</form:label>
			<form:input path="employeeName" type="text" />
			<form:errors path="employeeName" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="mounthSalary">Calisan Maas</form:label>
			<form:input path="mounthSalary" type="text" />
			<form:errors path="mounthSalary" />
		</fieldset>

		<button type="submit">Sakla</button>

	</form:form>

</body>
</html>