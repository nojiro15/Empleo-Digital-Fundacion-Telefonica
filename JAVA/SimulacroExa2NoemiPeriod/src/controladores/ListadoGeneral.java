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

import dao.DAOAnuncio;
import models.Anuncio;

/**
 * Servlet implementation class ListadoGeneral
 */
@WebServlet("/ListadoGeneral")
public class ListadoGeneral extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoGeneral() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * Proporcionar un listado completo
		 */
		/*inicio sesion*/
		HttpSession sesion=request.getSession();
		
		/*Recoperamos listado anuncios*/
		DAOAnuncio dao=new DAOAnuncio();
		ArrayList<Anuncio> lista=dao.listar();
		
		/*Se añade como atributo*/
		request.setAttribute("lista", lista);
		
		/*Obtenemos el contexto*/
		ServletContext context=request.getServletContext();
		RequestDispatcher dispatcher=context.getRequestDispatcher("/listadoAnuncios.jsp");/*Te devuelve a la página principal*/
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
