package edu.tecsup.seguridad.servlet.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.tecsup.seguridad.service.UsuarioService;

@WebServlet("/usuarios/UsuarioEliminarServlet")
public class UsuarioEliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected Logger log = Logger.getLogger(getClass());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("call UsuarioEliminarServlet");
		try{
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			UsuarioService usuarioService = new UsuarioService();
			usuarioService.eliminar(id);
			
			response.sendRedirect(request.getContextPath()+"/usuarios/UsuarioListarServlet");
			
		}catch(Exception e){
			log.error(e.toString());
			throw new ServletException(e.getMessage());
		}
	}

}
