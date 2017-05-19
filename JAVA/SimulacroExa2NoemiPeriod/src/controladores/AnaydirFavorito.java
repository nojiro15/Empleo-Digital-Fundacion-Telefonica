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
 * Servlet implementation class AnaydirFavoritos
 */
@WebServlet("/AnaydirFavoritos")
public class AnaydirFavorito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnaydirFavorito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*inicio sesion*/
		HttpSession sesion=request.getSession();
		
		/*No hace falta try/catch puesto que lo hemos metido desde el sistema*/
		String stId=request.getParameter("id");
		int id = Integer.parseInt(stId);
		
		/*Creo el objeto dao para buscar el anuncio de id?*/
		DAOAnuncio dao=new DAOAnuncio();
		Anuncio a =dao.read(id);
		
		/*Crea el array de favoritos*/
		ArrayList<Anuncio> favoritos=(ArrayList<Anuncio>) sesion.getAttribute("favoritos");
		if(favoritos==null){
			favoritos=new ArrayList<Anuncio>();/*Si no existe creo el arraylist*/
			sesion.setAttribute("favoritos", favoritos);
		}
		/*Si existe que no se añada el anuncio a favoritos*/
		boolean existe=false;
		for(Anuncio i:favoritos){
			if(i.getId()==a.getId()){
				existe=true;
				break;
			}
		}
		if(!existe){
			favoritos.add(a);
		}
		
		
		/*Hago la lista disponible para la servlet*/
		ServletContext context=request.getServletContext();
		RequestDispatcher dispatcher=context.getRequestDispatcher("/anyadirFavorito.jsp");/*Te devuelve a la página principal*/
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
