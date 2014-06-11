package edu.upeu.ventas.dao;

import java.util.List;

import edu.upeu.ventas.dominio.Docente;

public interface DocenteDAO {
	List<Docente> listarDocente();
	void guardar(Docente p);
	Docente getDocentePorid(String id);
	void actualizar(Docente p) ;
}
