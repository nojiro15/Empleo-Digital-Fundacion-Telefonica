package listeners;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import models.Anuncio;

/**
 * Application Lifecycle Listener implementation class ListenerSession
 *
 */
@WebListener
public class ListenerSession implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ListenerSession() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	/*Esto se hará cada vez que la sesion sea nueva*/
    	HttpSession sesion=se.getSession();
    	
    	ServletContext contexto= sesion.getServletContext();
    	
    	/*Debo controlar el acceso con sincronized*/
    	synchronized(contexto){
    		Integer numUsuarios=(Integer) contexto.getAttribute("numUsuarios");
    		numUsuarios++;/*Incremento los usuarios*/
    		contexto.setAttribute("numUsuarios", numUsuarios);
    	}	
    	
         }
    

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	/*No hace falta destruir la sesión*/
    }
	
}
