package edu.tecsup.seguridad.servlet.rol;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.tecsup.seguridad.service.RolService;

@WebServlet("/roles/RolEliminarServlet")
public class RolEliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected Logger log = Logger.getLogger(getClass());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("call RolEliminarServlet");
		try{
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			RolService rolService = new RolService();
			rolService.eliminar(id);
			
			response.sendRedirect(request.getContextPath()+"/roles/RolListarServlet");
			
		}catch(Exception e){
			log.error(e.toString());
			throw new ServletException(e.getMessage());
		}
	}

}
