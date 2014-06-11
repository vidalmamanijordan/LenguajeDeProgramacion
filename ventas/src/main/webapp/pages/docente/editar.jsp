<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<form onsubmit="upeu.guardarAlumno('docentes/editar');return false;"
	id="formulario">
	
	<h1>Editar Docente</h1>
	<p>
		<input type="hidden" id="id" value="<c:out value="${a.id}"></c:out>">
	</p>
	<p>
		<input type="text" id="nombre" value="<c:out value="${a.nombre}"></c:out>" placeholder="Nombre" autofocus required>
	</p>
	<p>
		<input type="text" id="paterno" value="<c:out value="${a.apePat}"></c:out>" placeholder="Paterno" required>
	</p>
	<p>
		<input type="text" id="materno" value="<c:out value="${a.apeMat}"></c:out>" placeholder="Materno" required>
	</p>
	
	<p>
		<input type="submit" value="Guardar">
	</p>
	
</form>