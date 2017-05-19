<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"/>

	<div id="usuarios">Numero de usuarios en el sito web:
		${applicationScope.numeroUsuarios}
	</div>
	<br/>

		<table>
			<tr>Viaje en promoción: </tr>
			 <tr>
				<td>${applicationScope.promocion.id}</td>
			</tr>
			 <tr>
				<td>${applicationScope.promocion.destino}</td>	
			</tr>
			<tr>
				<td>${applicationScope.promocion.duracion} dias</td>	
			</tr>
			<tr>
				<td>${applicationScope.promocion.precio} euros</td>	
			</tr>
		</table>
		

	<table>
		<tr>
			<td>	<a href="ServletListar">Ver todos los viajes</a> </td>
		</tr>
		<tr>
		<td><a href="buscar.jsp">Buscar viaje</a></td>
	</table>
	
<jsp:include page="footer.jsp"/>

