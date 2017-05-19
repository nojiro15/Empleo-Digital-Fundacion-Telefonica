<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%--Importamos taglib --%>
  
 <%@ page import="dao.DAOAnuncio,models.Anuncio,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contenido del periodico</title>
</head>
<body>
	<div>Listado</div>
	<table>
		<c:forEach items="${lista}" var="anuncio">
			<tr>
				<td><a href="AnyadirFavorito?id=${anuncio.id}">${anuncio.texto}</a></td>
			</tr>
		</c:forEach>	
	
	</table>
<a href="ServletIndex">Volver al inicio</a>
</body>
</html>