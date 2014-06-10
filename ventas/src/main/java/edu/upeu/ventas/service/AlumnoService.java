package edu.upeu.ventas.service;

import java.util.List;

import edu.upeu.ventas.web.form.AlumnoForm;

public interface AlumnoService {
	//(2)Podriamos decir que se está instanciando el método Listar Alumno.
	List<AlumnoForm> getListaAlumnos();
	//De igual manera con el método Guardar Alumno...
	void guardarAlumno(AlumnoForm p);
	//LLamar metodo Actualizar...
	void editarAlumno(AlumnoForm p);
}
