<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Just Adim <br /> High Security
	</h1>

	<security:authorize access="hasRole('ADMIN')">
		<h2>Yoneciti Erisebilir</h2>
	</security:authorize>

	<security:authorize access="hasRole('USER')">
		<h2>Kullanici Erisebilir.</h2>
	</security:authorize>


</body>
</html>