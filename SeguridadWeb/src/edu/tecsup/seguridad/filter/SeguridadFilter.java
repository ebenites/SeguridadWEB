package edu.tecsup.seguridad.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebFilter(urlPatterns = { //Registramos los módulos a proteger
		"/usuarios/*", 
		"/roles/*"
		})
public class SeguridadFilter implements Filter {

	protected Logger log = Logger.getLogger(getClass());
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
         
        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();
        
        log.info("SeguridadFilter: " + uri);
         
        if(session.getAttribute("usuario") == null && !(uri.startsWith(req.getContextPath()+"/seguridad/"))){ 
        	log.info("Unauthorized access request");
            res.sendRedirect(req.getContextPath()+"/seguridad/IndexServlet");
        }else{
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
