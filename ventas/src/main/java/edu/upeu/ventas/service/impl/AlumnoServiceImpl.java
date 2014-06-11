package edu.upeu.ventas.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.upeu.ventas.dao.AlumnoDAO;
import edu.upeu.ventas.dao.impl.AlumnoDAOJdbcImpl;
import edu.upeu.ventas.dominio.Alumno;
import edu.upeu.ventas.service.AlumnoService;
import edu.upeu.ventas.web.form.AlumnoForm;

public class AlumnoServiceImpl implements AlumnoService {

	AlumnoDAO alumnoDAO = new AlumnoDAOJdbcImpl();

	//(1)Implementamos los metodos Listar Alumno...para luego jalarlo a Service...
	public List<AlumnoForm> getListaAlumnos() {

		List<AlumnoForm> l = new ArrayList<AlumnoForm>();

		List<Alumno> lista = alumnoDAO.listarAlumnos();
		System.out.println("Lista devuelta :" + lista.size());

		for (Alumno p : lista) {
			AlumnoForm pf = new AlumnoForm();
			pf.setId(p.getId());
			pf.setNombre(p.getNombre());
			pf.setApePat(p.getApePat());
			pf.setApeMat(p.getApeMat());

			l.add(pf);
		}

		return l;
	}
	//De Igual manera implementamos el siguiente metodo para luego determinarlo en el service...
	public void guardarAlumno(AlumnoForm p) {
		Alumno persona = new Alumno();
		persona.setApePat(p.getApePat());
		persona.setApeMat(p.getApeMat());
		persona.setNombre(p.getNombre());

		alumnoDAO.guardar(persona);
	}
	
	//Implementar Alumno
	public void editarAlumno(AlumnoForm p){
		Alumno persona=new Alumno();
		persona.setApePat(p.getApePat());
		persona.setApeMat(p.getApeMat());
		persona.setNombre(p.getNombre());
		persona.setId(p.getId());
		
		alumnoDAO.actualizar(persona);
	}
	
	public AlumnoForm getAlumno(String id) {

		Alumno alu = alumnoDAO.getAlumnoPorid(id);
			
		AlumnoForm pf = new AlumnoForm();
		
			pf.setId(alu.getId());
			pf.setNombre(alu.getNombre());
			pf.setApePat(alu.getApePat());
			pf.setApeMat(alu.getApeMat());

		return pf;
	}
}
