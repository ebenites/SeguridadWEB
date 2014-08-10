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

import edu.tecsup.seguridad.model.Usuario;
import edu.tecsup.seguridad.service.UsuarioService;

@WebServlet("/usuarios/UsuarioListarServlet")
public class UsuarioListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected Logger log = Logger.getLogger(getClass());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("call UsuarioListarServlet");
		try{
		
			UsuarioService usuarioService = new UsuarioService();
			List<Usuario> lista = usuarioService.listar();
			
//			PrintWriter out = response.getWriter();
//			for (Usuario usuario : lista) {
//				out.print(usuario);
//			}
			request.setAttribute("usuarios", lista);
			request.setAttribute("nombre", "Juan");
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/listar.jsp");  //Llamanado al dispatcher
			rd.forward(request, response);
			
		}catch(Exception e){
			log.error(e.toString());
			throw new ServletException(e.getMessage());
		}
	}

}
