package edu.tecsup.seguridad.servlet.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import edu.tecsup.seguridad.service.UsuarioService;

@WebServlet("/usuarios/UsuarioActualizarServlet")
public class UsuarioActualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected Logger log = Logger.getLogger(getClass());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("call UsuarioActualizarServlet");
		try{
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			String usuario = request.getParameter("usuario");
			String clave = request.getParameter("clave");
			String nombres = request.getParameter("nombres");
			String correo = request.getParameter("correo");
			Integer idrol = Integer.parseInt(request.getParameter("rol"));
			
			UsuarioService usuarioService = new UsuarioService();
			usuarioService.actualizar(usuario, clave, nombres, correo, idrol, id);
			
			response.sendRedirect(request.getContextPath()+"/usuarios/UsuarioListarServlet");
			
		}catch(Exception e){
			log.error(e.toString());
			throw new ServletException(e.getMessage());
		}
	}

}
