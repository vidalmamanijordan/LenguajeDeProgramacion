package edu.upeu.ventas.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.upeu.ventas.service.AlumnoService;
import edu.upeu.ventas.service.impl.AlumnoServiceImpl;
import edu.upeu.ventas.web.form.AlumnoForm;

/**
 * Servlet implementation class AlumnoEditar
 */
public class AlumnoEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_MAIN = "/pages/alumno/main.jsp";
	private static final String VIEW_EDIT = "/pages/alumno/editar.jsp";
	
	AlumnoService alumnoService = new AlumnoServiceImpl();       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoEditarServlet() {	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		AlumnoForm alumn = alumnoService.getAlumno(id);
		
		
		request.setAttribute("a", alumn);
		request.getRequestDispatcher(VIEW_EDIT)
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		alumnoService = new AlumnoServiceImpl();  
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String paterno = request.getParameter("paterno");
		String materno = request.getParameter("materno");

		AlumnoForm alumnoForm = new AlumnoForm();
		
		alumnoForm.setId(id);
		alumnoForm.setNombre(nombre);
		alumnoForm.setApePat(paterno);
		alumnoForm.setApeMat(materno);
System.out.print("Llegooooooooooooooooooooooooooooooooo:" +nombre);
		alumnoService.editarAlumno(alumnoForm);

		List<AlumnoForm> lista = alumnoService.getListaAlumnos();

		request.setAttribute("lp", lista);
		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}

}
