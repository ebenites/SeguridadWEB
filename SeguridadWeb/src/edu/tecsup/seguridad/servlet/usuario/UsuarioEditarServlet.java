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
import edu.tecsup.seguridad.model.Usuario;
import edu.tecsup.seguridad.service.RolService;
import edu.tecsup.seguridad.service.UsuarioService;

@WebServlet("/usuarios/UsuarioEditarServlet")
public class UsuarioEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected Logger log = Logger.getLogger(getClass());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("call UsuarioEditarServlet");
		try{
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			UsuarioService usuarioService = new UsuarioService();
			Usuario usuario = usuarioService.obtener(id);
			
			request.setAttribute("usuario", usuario);
			
			//carga de roles
			RolService rolService = new RolService();
			List<Rol> roles = rolService.listar();
			
			request.setAttribute("roles", roles);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/editar.jsp");  //Llamanado al dispatcher
			rd.forward(request, response);
			
		}catch(Exception e){
			log.error(e.toString());
			throw new ServletException(e.getMessage());
		}
	}

}
