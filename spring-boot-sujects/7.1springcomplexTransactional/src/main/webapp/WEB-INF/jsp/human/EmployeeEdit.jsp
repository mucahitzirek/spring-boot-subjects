<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form method="post" modelAttribute="employee">
		<form:errors />
		<form:hidden path="employeeId" />
		<fieldset class="form-group">
			<form:label path="employeeId">Isalan Ozelligi</form:label>
			<form:input path="employeeId" type="text" disabled="true" />
			<form:errors path="employeeId" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="employeeName">Isalan Adi</form:label>
			<form:input path="employeeName" type="text" />
			<form:errors path="employeeName" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="mounthSalary">Aylik Maas</form:label>
			<form:input path="mounthSalary" type="text" />
			<form:errors path="mounthSalary" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="departmentId">Bolum</form:label>
			<form:select path="departmentId">
				<form:option value="0">--Seciniz--</form:option>
				<c:forEach items="${departments.departmentDetailList}" var="department">
					<form:option value="${department.departmentId}">
					${department.departmentName}
					</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="departmentId" />
		</fieldset>

		<button type="submit">Sakla</button>
	</form:form>

</body>
</html>