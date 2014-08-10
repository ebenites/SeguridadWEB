package edu.tecsup.seguridad.service;

import java.util.List;

import org.apache.log4j.Logger;

import edu.tecsup.seguridad.dao.RolDAO;
import edu.tecsup.seguridad.exception.ServiceException;
import edu.tecsup.seguridad.model.Rol;

public class RolService {

	protected Logger log = Logger.getLogger(getClass());
	
	private RolDAO rolDAO;
	
	public RolService() {
		super();
		this.rolDAO = new RolDAO();
	}

	public List<Rol> listar() throws ServiceException{
		log.info("listar()");
		try{
			return rolDAO.listar();
		} catch(Exception e){
			log.error(e.toString());
			throw new ServiceException(e.getMessage());
		}
	}
	
	public Rol obtener(Integer id) throws ServiceException{
		log.info("obtener(id:"+id+")");
		try{
			return rolDAO.obtener(id);
		} catch(Exception e){
			log.error(e.toString());
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void insertar(String nombre) throws ServiceException{
		log.info("insertar(nombre:"+nombre+")");
		try{
			// validar datos de entrada
			
			Rol rol = new Rol();
			rol.setNombre(nombre);
			
			rolDAO.insertar(rol);
			
		} catch(Exception e){
			log.error(e.toString());
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void actualizar(String nombre, int id) throws ServiceException{
		log.info("actualizar(nombre:"+nombre+", id:"+id+")");
		try{
			// validar datos de entrada
			
			Rol rol = new Rol();
			rol.setId(id);
			rol.setNombre(nombre);
			
			rolDAO.actualizar(rol);
			
		} catch(Exception e){
			log.error(e.toString());
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void eliminar(Integer id) throws ServiceException{
		log.info("eliminar(id:"+id+")");
		try{
			rolDAO.eliminar(id);
		} catch(Exception e){
			log.error(e.toString());
			throw new ServiceException(e.getMessage());
		}
	}
	
}
