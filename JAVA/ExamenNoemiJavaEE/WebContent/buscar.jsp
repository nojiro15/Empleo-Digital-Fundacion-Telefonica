<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<jsp:include page="header.jsp"/>
	<h3>Búsqueda de viajes</h3>
	 <form action="ServletBuscar" method="POST">
			<label for="palabra">Palabra a buscar: </label> 
			<input type="text" name="palabra" placeholder="Palabra aquí" />
			<button type="submit">Buscar</button>
		</form>

<jsp:include page="footer.jsp"/>