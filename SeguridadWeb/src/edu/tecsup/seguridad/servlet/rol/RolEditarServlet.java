package edu.tecsup.seguridad.servlet.rol;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.tecsup.seguridad.model.Rol;
import edu.tecsup.seguridad.service.RolService;

@WebServlet("/roles/RolEditarServlet")
public class RolEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected Logger log = Logger.getLogger(getClass());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("call UsuariRolEditarServletoEditarServlet");
		try{
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			RolService rolService = new RolService();
			Rol rol = rolService.obtener(id);
			
			request.setAttribute("rol", rol);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/roles/editar.jsp");
			rd.forward(request, response);
			
		}catch(Exception e){
			log.error(e.toString());
			throw new ServletException(e.getMessage());
		}
	}

}
