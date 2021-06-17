<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Ileti:	${message}
	<form name="login" action="/login" method="POST">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token }"> Kullanici: <input type="text"
			name="username"><br /> Parola: <input type="password"
			name="password"><br /> <input type="submit" value="Gir">

	</form>


</body>
</html>