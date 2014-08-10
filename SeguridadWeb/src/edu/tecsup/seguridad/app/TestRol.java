package edu.tecsup.seguridad.app;

import java.util.List;

import edu.tecsup.seguridad.exception.ServiceException;
import edu.tecsup.seguridad.model.Rol;
import edu.tecsup.seguridad.service.RolService;

public class TestRol {

	public static void main(String[] args) throws ServiceException {
		
		RolService rolService = new RolService();
		List<Rol> lista = rolService.listar();
		
		for (Rol rol : lista) {
			System.out.println(rol);
		}

	}

}
