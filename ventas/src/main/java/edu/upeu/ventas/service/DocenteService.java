package edu.upeu.ventas.service;

import java.util.List;

import edu.upeu.ventas.web.form.DocenteForm;

public interface DocenteService {
	 List<DocenteForm> getListaDocentes();
	 void guardarDocente(DocenteForm p);
	 DocenteForm getDocente(String id);
	 void editarDocente(DocenteForm p);
}
