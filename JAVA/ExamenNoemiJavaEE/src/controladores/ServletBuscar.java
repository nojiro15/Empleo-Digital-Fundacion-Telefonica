package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOViaje;
import models.Viaje;

/**
 * Servlet implementation class Buscar
 */
@WebServlet("/ServletBuscar")
public class ServletBuscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBuscar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Busca el viaje por palabra
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto=request.getServletContext();
		HttpSession sesion=request.getSession();
		
		String palabra=(String)request.getAttribute("palabra");
		
		DAOViaje dao= new DAOViaje();
		ArrayList<Viaje> lista=dao.buscar(palabra);
		request.setAttribute("listaB", lista);
		
		
		RequestDispatcher dispatcher=contexto.getRequestDispatcher("/mostrarBusqueda.jsp");
		dispatcher.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
