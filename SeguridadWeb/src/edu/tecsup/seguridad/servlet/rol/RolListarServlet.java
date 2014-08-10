package edu.tecsup.seguridad.servlet.rol;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.tecsup.seguridad.model.Rol;
import edu.tecsup.seguridad.service.RolService;

@WebServlet("/roles/RolListarServlet")
public class RolListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected Logger log = Logger.getLogger(getClass());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("call RolListarServlet");
		try{
		
			RolService rolService = new RolService();
			List<Rol> lista = rolService.listar();
			
			request.setAttribute("roles", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/roles/listar.jsp");  
			rd.forward(request, response);
			
		}catch(Exception e){
			log.error(e.toString());
			throw new ServletException(e.getMessage());
		}
	}

}
