package edu.upeu.ventas.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.upeu.ventas.dao.DocenteDAO;
import edu.upeu.ventas.dao.impl.DocenteDAOJdbcImpl;
import edu.upeu.ventas.dominio.Alumno;
import edu.upeu.ventas.dominio.Docente;
import edu.upeu.ventas.service.DocenteService;
import edu.upeu.ventas.web.form.AlumnoForm;
import edu.upeu.ventas.web.form.DocenteForm;

public class DocenteServiceImpl implements DocenteService {

	DocenteDAO docenteDAO = new DocenteDAOJdbcImpl();
	
	public List<DocenteForm> getListaDocentes() {

		List<DocenteForm> l = new ArrayList<DocenteForm>();

		List<Docente> lista = docenteDAO.listarDocente();
		System.out.println("Lista devuelta :" + lista.size());

		for (Docente p : lista) {
			DocenteForm pf = new DocenteForm();
			
			pf.setId(p.getId());
			pf.setNombre(p.getNombre());
			pf.setApePat(p.getApePat());
			pf.setApeMat(p.getApeMat());

			l.add(pf);
		}

		return l;
	}

	public void guardarDocente(DocenteForm p) {
		
		Docente persona = new Docente();
		
		persona.setApePat(p.getApePat());
		persona.setApeMat(p.getApeMat());
		persona.setNombre(p.getNombre());

		docenteDAO.guardar(persona);
	}
	
	public DocenteForm getDocente(String id) {

		Docente dc = docenteDAO.getDocentePorid(id);
			
		DocenteForm pf = new DocenteForm();
		
			pf.setId(dc.getId());
			pf.setNombre(dc.getNombre());
			pf.setApePat(dc.getApePat());
			pf.setApeMat(dc.getApeMat());

		return pf;
	}
	
	public void editarDocente(DocenteForm p){
		Docente persona=new Docente();
		persona.setApePat(p.getApePat());
		persona.setApeMat(p.getApeMat());
		persona.setNombre(p.getNombre());
		persona.setId(p.getId());
		
		docenteDAO.actualizar(persona);
	}
}
