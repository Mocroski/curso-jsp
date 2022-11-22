<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bem vindo</h1>

	<%
	out.print("teste jsp");
	%>

	<form action="/ServletLogin" method="post">

		<input name="nome"> <input name="idade"> 
		<input type="submit" value="Enviar">
	</form>

</body>
</html>