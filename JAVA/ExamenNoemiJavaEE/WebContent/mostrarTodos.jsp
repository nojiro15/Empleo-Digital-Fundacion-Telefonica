<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="header.jsp"/>
    <div>
	<table>
		<th>Listado de todos los viajes</th>
			<tr>
				<td>Id</td>
				<td>Destino</td>
				<td>Duracion</td>
				<td>Precio</td>			
		<c:forEach items="${lista}" var="viaje">
			<tr>
				<td>${viaje.id }</td>
				<td>${viaje.destino }</td>
				<td>${viaje.duracion } dias</td>
				<td>${viaje.precio } euros</td>
				<td><a href="AnyadirFavorito?id=${viaje.id}">Añadir a favoritos</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include page="footer.jsp"/>