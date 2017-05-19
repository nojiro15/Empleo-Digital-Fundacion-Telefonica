<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="header.jsp"/>
		
		<table>
			<th>Resultado de la búsqueda</th>
				<tr>
				<td>Id</td>
				<td>Destino</td>
				<td>Duracion</td>
				<td>Precio</td>			
				</tr>
		<c:forEach items="${listaB}" var="viaje">
			<tr>
				<td>${viaje.id }</td>
				<td>${viaje.destino }</td>
				<td>${viaje.duracion } dias</td>
				<td>${viaje.precio } euros</td>
				<td><a href="AnyadirFavorito?id=${viaje.id}">Añadir a favoritos</a></td>
			</tr>
			</c:forEach>
		</table>
		
<jsp:include page="footer.jsp"/>