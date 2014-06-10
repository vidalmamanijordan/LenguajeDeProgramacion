package edu.upeu.ventas.service;

import java.util.List;

import edu.upeu.ventas.web.form.AlumnoForm;

public interface AlumnoService {
	//(2)Podriamos decir que se est� instanciando el m�todo Listar Alumno.
	List<AlumnoForm> getListaAlumnos();
	//De igual manera con el m�todo Guardar Alumno...
	void guardarAlumno(AlumnoForm p);
	//LLamar metodo Actualizar...
	void editarAlumno(AlumnoForm p);
}
