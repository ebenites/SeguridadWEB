package edu.tecsup.seguridad.servlet.usuario;

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

@WebServlet("/usuarios/UsuarioFormServlet")
public class UsuarioFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected Logger log = Logger.getLogger(getClass());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("call UsuarioFormServlet");
		try{
			
			RolService rolService = new RolService();
			List<Rol> roles = rolService.listar();
			
			request.setAttribute("roles", roles);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/form.jsp");
			rd.forward(request, response);
			
		}catch(Exception e){
			log.error(e.toString());
			throw new ServletException(e.getMessage());
		}
	}

}
