package edu.tecsup.seguridad.service;

import java.util.List;

import org.apache.log4j.Logger;

import edu.tecsup.seguridad.dao.UsuarioDAO;
import edu.tecsup.seguridad.exception.ServiceException;
import edu.tecsup.seguridad.model.Rol;
import edu.tecsup.seguridad.model.Usuario;

public class UsuarioService {

	protected Logger log = Logger.getLogger(getClass());
	
	private UsuarioDAO usuarioDAO;
	
//	private RolDAO rolDAO;
	
	public UsuarioService() {
		super();
		this.usuarioDAO = new UsuarioDAO();
	}

	public Usuario login(String username, String userpass) throws ServiceException{
		log.info("login(username:"+username+" - userpass:"+userpass+")");
		try{
			username = username.trim().toLowerCase();
			return usuarioDAO.login(username, userpass);
		} catch(Exception e){
			log.error(e.toString());
			throw new ServiceException(e.getMessage());
		}
	}
	
	public List<Usuario> listar() throws ServiceException{
		log.info("listar()");
		try{
			return usuarioDAO.listar();
		} catch(Exception e){
			log.error(e.toString());
			throw new ServiceException(e.getMessage());
		}
	}
	
	public Usuario obtener(Integer id) throws ServiceException{
		log.info("obtener(id:"+id+")");
		try{
			return usuarioDAO.obtener(id);
		} catch(Exception e){
			log.error(e.toString());
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void insertar(String usuario, String clave, String nombres, String correo, int idrol) throws ServiceException{
		log.info("insertar(usuario:"+usuario+", clave:"+clave+", nombres:"+nombres+", correo:"+correo+", idrol:"+idrol+")");
		try{
			// validar datos de entrada
			
			Usuario u = new Usuario();
			u.setUsuario(usuario);
			u.setClave(clave);
			u.setNombres(nombres);
			u.setCorreo(correo);
			Rol rol = new Rol();
			rol.setId(idrol);
			u.setRol(rol);
			
			usuarioDAO.insertar(u);
			
		} catch(Exception e){
			log.error(e.toString());
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void actualizar(String usuario, String clave, String nombres, String correo, int idrol, int id) throws ServiceException{
		log.info("actualizar(usuario:"+usuario+", clave:"+clave+", nombres:"+nombres+", correo:"+correo+", idrol:"+idrol+", id:"+id+")");
		try{
			// validar datos de entrada
			
			Usuario u = new Usuario();
			u.setId(id);
			u.setUsuario(usuario);
			u.setClave(clave);
			u.setNombres(nombres);
			u.setCorreo(correo);
			Rol rol = new Rol();
			rol.setId(idrol);
			u.setRol(rol);
			
			usuarioDAO.actualizar(u);
			
		} catch(Exception e){
			log.error(e.toString());
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void eliminar(Integer id) throws ServiceException{
		log.info("eliminar(id:"+id+")");
		try{
			usuarioDAO.eliminar(id);
		} catch(Exception e){
			log.error(e.toString());
			throw new ServiceException(e.getMessage());
		}
	}
	
}
