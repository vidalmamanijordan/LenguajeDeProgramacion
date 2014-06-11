package edu.upeu.ventas.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.upeu.ventas.service.DocenteService;
import edu.upeu.ventas.service.impl.DocenteServiceImpl;
import edu.upeu.ventas.web.form.DocenteForm;

/**
 * Servlet implementation class AlumnoNuevoServlet
 */
public class DocenteNuevoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_MAIN = "/pages/docente/main.jsp";
	private static final String VIEW_NEW = "/pages/docente/nuevo.jsp";

	DocenteService docenteService = new DocenteServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DocenteNuevoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VIEW_NEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String paterno = request.getParameter("paterno");
		String materno = request.getParameter("materno");

		DocenteForm docenteForm = new DocenteForm();
		
		docenteForm.setNombre(nombre);
		docenteForm.setApePat(paterno);
		docenteForm.setApeMat(materno);

		docenteService.guardarDocente(docenteForm);

		List<DocenteForm> lista = docenteService.getListaDocentes();

		request.setAttribute("lp", lista);
		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}

}
