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
	<form:form modelAttribute="employees" method="post">
		<form:label path="departmentId">Bolum</form:label>
		<form:select path="departmentId">
			<form:option value="0">--Tumu--</form:option>
			<c:forEach items="${departments.departmentDetailList}"
				var="department">
				<form:option value="${department.departmentId}">
					${department.departmentName}
					</form:option>
			</c:forEach>
		</form:select>
		<button type="submit" name="filter">Suz</button>
		<br>
		<br>
		<table border="1">
			<c:forEach var="employee" items="${employees.employeeDetailList}">
				<tr>
					<td>${employee.employeeId}</td>
					<td>${employee.employeeName}</td>
					<td>${employee.mounthSalary}</td>
					<td>${employee.departmentId}</td>
					<td>${employee.departmentName}</td>
					<td><a
						href="<c:url value='/employee/edit/${employee.employeeId}'/>">Guncelle</a></td>
					<td><a
						href="<c:url value='/employee/delete/${employee.employeeId}'/>">Sil</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<a href="<c:url value='/employee/edit'/>">Ekle</a>
	</form:form>
</body>
</html>