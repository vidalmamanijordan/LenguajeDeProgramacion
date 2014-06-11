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
 * Servlet implementation class AlumnoServlet
 */
public class DocenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW_MAIN = "/pages/docente/main.jsp";

	//(3)Llamo a la clase de AlumnoService instanciado...
	DocenteService docenteService = new DocenteServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DocenteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<DocenteForm> lista = docenteService.getListaDocentes();

		request.setAttribute("lp", lista);
		request.getRequestDispatcher(VIEW_MAIN).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
