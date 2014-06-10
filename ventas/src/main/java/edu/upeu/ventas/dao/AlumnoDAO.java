package edu.upeu.ventas.dao;

import java.util.List;

import edu.upeu.ventas.dominio.Alumno;

public interface AlumnoDAO {
	//Llamamos de la clase AlumnoDAOJdbcImpl---
	void guardar(Alumno p);
	//Repetimos el mismo caso del de arriba...
	List<Alumno> listarAlumnos();
	//Actualizar Alumno
	void actualizar(Alumno p);

}
