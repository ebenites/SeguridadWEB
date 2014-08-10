package edu.tecsup.seguridad.app;

import edu.tecsup.seguridad.exception.ServiceException;
import edu.tecsup.seguridad.model.Usuario;
import edu.tecsup.seguridad.service.UsuarioService;

public class TestUsuario {

	public static void main(String[] args) throws ServiceException {
		
		UsuarioService usuarioService = new UsuarioService();
		
//		List<Usuario> lista = usuarioService.listar();
//		
//		for (Usuario usuario : lista) {
//			System.out.println(usuario);
//		}
		
//		usuarioService.insertar("jfarfan", "tecsup", "Jaime Farfan", "jfarfa@tecsup.edu.pe", 2);
		
//		usuarioService.eliminar(2);
	
		Usuario usuario = usuarioService.login(" Jflores", "tecsup");
		System.out.println(usuario);

	}

}
