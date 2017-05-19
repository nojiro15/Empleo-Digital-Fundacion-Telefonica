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
 * Servlet implementation class AnyadirFavorito
 * Para añadir los viajes favoritos.
 */
@WebServlet("/AnyadirFavorito")
public class AnyadirFavorito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnyadirFavorito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto=request.getServletContext();
		HttpSession sesion=request.getSession();
		ArrayList<Viaje> favoritos=(ArrayList<Viaje>) sesion.getAttribute("favoritos");
		if(favoritos==null){
			favoritos=new ArrayList<Viaje>();
			sesion.setAttribute("favoritos",favoritos);
		}
		String stId=request.getParameter("id");
		int id=Integer.parseInt(stId);
		DAOViaje dao=new DAOViaje();
		Viaje via=dao.read(id);
		
		/**
		 * Comprobamos si existe en favoritos
		 */
		boolean existe =false;
		for(Viaje v:favoritos){
			if(v.getId()==via.getId()){
				existe=true;
				RequestDispatcher dispatcher=contexto.getRequestDispatcher("/errorYaExiste.jsp");
				dispatcher.forward(request,response);
			}
		}
		if(!existe){
			favoritos.add(via);
			sesion.setAttribute("favoritos", favoritos);
		}
		RequestDispatcher dispatcher=contexto.getRequestDispatcher("/anyadirFavoritos.jsp");
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
