package edu.upeu.ventas.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.upeu.ventas.service.AlumnoService;
import edu.upeu.ventas.service.DocenteService;
import edu.upeu.ventas.service.impl.AlumnoServiceImpl;
import edu.upeu.ventas.service.impl.DocenteServiceImpl;
import edu.upeu.ventas.web.form.AlumnoForm;
import edu.upeu.ventas.web.form.DocenteForm;

/**
 * Servlet implementation class AlumnoEditar
 */
public class DocenteEditarServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_MAIN = "/pages/docente/main.jsp";
	private static final String VIEW_EDIT = "/pages/docente/editar.jsp";
	
	DocenteService docenService = new DocenteServiceImpl();       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocenteEditarServelt() {	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		DocenteForm docen = docenService.getDocente(id);
		
		
		request.setAttribute("a", docen);
		request.getRequestDispatcher(VIEW_EDIT)
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String paterno = request.getParameter("paterno");
		String materno = request.getParameter("materno");

		DocenteForm docenteForm = new DocenteForm();
		
		docenteForm.setId(id);
		docenteForm.setNombre(nombre);
		docenteForm.setApePat(paterno);
		docenteForm.setApeMat(materno);

		docenService.editarDocente(docenteForm);

		List<DocenteForm> lista = docenService.getListaDocentes();

		request.setAttribute("lp", lista);
		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}

}
