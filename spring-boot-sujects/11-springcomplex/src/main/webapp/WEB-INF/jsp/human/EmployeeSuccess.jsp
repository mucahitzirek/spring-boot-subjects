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
	Ileti : ${message}
	<br>Isalan : ${employee.employeeId}
	<br>Isalan Adi : ${employee.employeeName}
	<br>Aylik Maas : ${employee.mounthSalary}
	<br>Calistigi Bolum : ${employee.departmentName}
	<br>
	<a href="<c:url value='/employee/list'/>">Isalanlar</a>

</body>
</html>

