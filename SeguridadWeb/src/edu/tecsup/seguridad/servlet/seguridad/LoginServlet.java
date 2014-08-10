package edu.tecsup.seguridad.servlet.seguridad;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import edu.tecsup.seguridad.model.Usuario;
import edu.tecsup.seguridad.service.UsuarioService;

@WebServlet("/seguridad/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected Logger log = Logger.getLogger(getClass());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("call LoginServlet");
		try{
			
			String username = request.getParameter("usuario");
			String userpass = request.getParameter("clave");
			
			UsuarioService usuarioService = new UsuarioService();
			Usuario usuario = usuarioService.login(username, userpass);
			
			log.info("Usuario:" + usuario);
			
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
			
		}catch(Exception e){
			log.error(e.toString());
			throw new ServletException(e.getMessage());
		}
	}

}
