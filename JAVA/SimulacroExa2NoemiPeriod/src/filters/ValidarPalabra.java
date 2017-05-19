package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ValidarPalabra
 */
@WebFilter("/ServletBuscar")
public class ValidarPalabra implements Filter {

    /**
     * Default constructor. 
     */
    public ValidarPalabra() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String palabra=request.getParameter("palabra");
		if(palabra!=null){
			palabra.trim();
				if(palabra.equals("")){
					chain.doFilter(request, response);	
				}
			
		}
		else{
			ServletContext context=request.getServletContext();
			RequestDispatcher dispatcher=context.getRequestDispatcher("/error.jsp");/*Te devuelve a la página principal*/
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
