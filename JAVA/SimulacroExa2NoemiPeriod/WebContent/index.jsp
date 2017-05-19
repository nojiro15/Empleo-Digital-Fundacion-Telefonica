<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Principal</title>
</head>
<body>
<table>
	<tr>
		<td>Los anuncios que hay son: </td>
		<td>${numeroAnuncios}</td>
	</tr>
	<tr>
		<td>Los usuarios conectados son:</td>
		<td>${numUsuarios}</td>
	</tr>
</table>
	
	<a href="ListadoAnuncios">Listado de Anuncios</a><%--Van a ser sevlet --%>
	<a href="formularioBusqueda.jsp">Búsqueda por texto</a>
	
</body>
</html>