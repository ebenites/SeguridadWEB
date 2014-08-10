package edu.tecsup.seguridad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.tecsup.seguridad.exception.DAOException;
import edu.tecsup.seguridad.model.Rol;
import edu.tecsup.seguridad.model.Usuario;
import edu.tecsup.seguridad.util.Conexion;

public class UsuarioDAO {

	protected Logger log = Logger.getLogger(getClass());
	
	public Usuario login(String username, String userpass) throws DAOException{
		log.info("login(username:"+username+", userpass:"+userpass+")");
		try{
			
			Connection con = Conexion.getConexion();
			
			String sql = "SELECT u.id, u.usuario, u.clave, u.nombres, u.correo, u.rol_id, r.nombre as rol_nombre "
					+ "FROM usuarios u "
					+ "inner join rol r on r.id=u.rol_id "
					+ "WHERE lower(u.usuario) = ? AND u.clave = ?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, userpass);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setClave(rs.getString("clave"));
				usuario.setNombres(rs.getString("nombres"));
				usuario.setCorreo(rs.getString("correo"));
				
				Rol rol = new Rol(rs.getInt("rol_id"), rs.getString("rol_nombre"));
				usuario.setRol(rol);
				
				return usuario;
				
			}
			rs.close();
			stmt.close();
			con.close();
			
			throw new DAOException("Usuario y/o clave incorrecto");
			
		}catch(Exception e){
			log.error(e.toString());
			throw new DAOException(e.getMessage());
		}
	}
	
	public List<Usuario> listar() throws DAOException{
		log.info("listar()");
		try{
			
			List<Usuario> lista = new ArrayList<>();
			
			Connection con = Conexion.getConexion();
			
			String sql = "SELECT u.id, u.usuario, u.clave, u.nombres, u.correo, u.rol_id, r.nombre as rol_nombre "
					+ "FROM usuarios u "
					+ "inner join rol r on r.id=u.rol_id";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setClave(rs.getString("clave"));
				usuario.setNombres(rs.getString("nombres"));
				usuario.setCorreo(rs.getString("correo"));
				
				Rol rol = new Rol(rs.getInt("rol_id"), rs.getString("rol_nombre"));
				usuario.setRol(rol);
				
				lista.add(usuario);
				
			}
			
			rs.close();
			stmt.close();
			con.close();
			
			return lista;
		}catch(Exception e){
			log.error(e.toString());
			throw new DAOException(e.getMessage());
		}
	}
	
	public Usuario obtener(Integer id) throws DAOException{
		log.info("obtener(id:"+id+")");
		try{
			
			Connection con = Conexion.getConexion();
			
			String sql = "SELECT u.id, u.usuario, u.clave, u.nombres, u.correo, u.rol_id, r.nombre as rol_nombre "
					+ "FROM usuarios u "
					+ "inner join rol r on r.id=u.rol_id "
					+ "WHERE u.id = ? ";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setClave(rs.getString("clave"));
				usuario.setNombres(rs.getString("nombres"));
				usuario.setCorreo(rs.getString("correo"));
				
				Rol rol = new Rol(rs.getInt("rol_id"), rs.getString("rol_nombre"));
				usuario.setRol(rol);
				
				return usuario;
				
			}
			
			rs.close();
			stmt.close();
			con.close();
			
			return null;
		}catch(Exception e){
			log.error(e.toString());
			throw new DAOException(e.getMessage());
		}
	}
	
	public void insertar(Usuario usuario) throws DAOException{
		log.info("insertar(usuario:"+usuario+")");
		try{
			
			Connection con = Conexion.getConexion();
			
			String sql = "INSERT INTO usuarios(usuario, clave, nombres, correo, rol_id) "
					+ "VALUES(?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getClave());
			stmt.setString(3, usuario.getNombres());
			stmt.setString(4, usuario.getCorreo());
			stmt.setInt(5, usuario.getRol().getId());
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
			
		}catch(Exception e){
			log.error(e.toString());
			throw new DAOException(e.getMessage());
		}
	}
	
	public void actualizar(Usuario usuario) throws DAOException{
		log.info("actualizar(usuario:"+usuario+")");
		try{
			
			Connection con = Conexion.getConexion();
			
			//if usuario.getClave().equals("")  -> SQL SIN update clave 
			
			String sql = "UPDATE usuarios SET usuario=?, nombres=?, correo=?, rol_id=? "
					+ "WHERE id=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getNombres());
			stmt.setString(3, usuario.getCorreo());
			stmt.setInt(4, usuario.getRol().getId());
			stmt.setInt(5, usuario.getId());
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
			
		}catch(Exception e){
			log.error(e.toString());
			throw new DAOException(e.getMessage());
		}
	}
	
	public void eliminar(Integer id) throws DAOException{
		log.info("eliminar(id:"+id+")");
		try{
			
			Connection con = Conexion.getConexion();
			
			String sql = "DELETE FROM usuarios WHERE id = ?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
			
		}catch(Exception e){
			log.error(e.toString());
			throw new DAOException(e.getMessage());
		}
	}
	
}
