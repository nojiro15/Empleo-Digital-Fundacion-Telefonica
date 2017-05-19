<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="header.jsp"/>
		<table>
		  <tr>
		    <th>Viajes Favoritos</th>
		   </tr>
		  <c:forEach items="${favoritos }" var="viajes"> 
		  <tr>
		   		<td>${viajes.id }</td>
				<td>${viajes.destino }</td>
				<td>${viajes.duracion } dias</td>
				<td>${viajes.precio } euros</td>
		  </tr>
		  </c:forEach>
	</table>

<jsp:include page="footer.jsp"/>