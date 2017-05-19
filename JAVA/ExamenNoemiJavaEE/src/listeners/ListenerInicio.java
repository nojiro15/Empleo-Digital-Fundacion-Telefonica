package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.DAOViaje;
import models.Viaje;

/**
 * Application Lifecycle Listener implementation class ListenerInicio
 *
 */
@WebListener
public class ListenerInicio implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerInicio() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	/**
		 * Para tener el viaje en promoción
		 * 
		 */
    	ServletContext contexto=sce.getServletContext();
		DAOViaje dao=new DAOViaje();
		Viaje promocion=dao.read(1);
		contexto.setAttribute("promocion", promocion);
    }
	
}
