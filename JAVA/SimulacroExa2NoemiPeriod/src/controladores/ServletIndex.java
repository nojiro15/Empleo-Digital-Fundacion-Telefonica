package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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
 * Servlet implementation class ServletIndex
 */
@WebServlet(description = "Pagina de bienvenida", urlPatterns = { "/ServletIndex" })
public class ServletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Contexto de la Servlet
	 * @see Servlet#init(ServletConfig)
	 */
    
	public void init(ServletConfig config) throws ServletException {
		ServletContext contexto=config.getServletContext();
		contexto.setAttribute("numUsuarios", new Integer(0));/*Creo el atributo en el contexto*/
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion=request.getSession();/*Devuelve la sesi�n y si no la hay la crea*/
		ServletContext context=request.getServletContext();
		int numUsuarios=(int)context.getAttribute("numUsuarios");
		request.setAttribute("numUsuarios", numUsuarios);/*Hago disponible el n�mero para luego visualizarlo*/
		DAOAnuncio dao=new DAOAnuncio();
		/*Se podr�a hacer de esta manera la recuperaci�n del n�mero de anuncios
		ArrayList<Anuncio> lista =dao.listar();
		request.setAttribute("numeroAnuncios", lista.size());*/
		int n=dao.contar();
		request.setAttribute("numeroAnuncios", n);
		
		RequestDispatcher dispatcher=context.getRequestDispatcher("/index.jsp");/*Te devuelve a la p�gina principal*/
		dispatcher.forward(request, response);
		System.out.println("Esta es la comprobaci�n de la vuelta del forward");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
