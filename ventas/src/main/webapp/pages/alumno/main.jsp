<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<c:choose>
	<c:when test="${not empty lp}">
		<table class="tabla-cebra">
			<caption>Lista de Alumnos</caption>
			<tr>
				<td colspan="4"><a href="#"
					onclick="upeu.cargarUrl('alumnos/nuevo')">+ Nuevo</a></td>
			</tr>
			<tr>
				<th>#</th>
				<th>Paterno</th>
				<th>Materno</th>
				<th>Nombre</th>
				<th>Opc</th>
			</tr>
			<c:forEach items="${lp}" var="p" varStatus="ps">
				<tr>
					<td><c:out value="${ps.count}"></c:out></td>
					<td><c:out value="${p.apePat}"></c:out></td>
					<td><c:out value="${p.apeMat}"></c:out></td>
					<td><c:out value="${p.nombre}"></c:out></td>
					<td><a href="#"
						onclick="upeu.cargarUrl('alumnos/editar')"('<c:out value="${p.id}"></c:out>')>[Editar]</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
	<!--  
		<p>
			<a href="#" onclick="upeu.cargarUrl('alumnos/nuevo')">+ Nuevo</a>
		</p>
 	-->	
		<div class="aviso">No se encontraron alumnos</div>
	</c:otherwise>
</c:choose>