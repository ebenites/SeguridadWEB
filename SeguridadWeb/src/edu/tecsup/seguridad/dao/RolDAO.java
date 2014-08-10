package edu.tecsup.seguridad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.tecsup.seguridad.exception.DAOException;
import edu.tecsup.seguridad.model.Rol;
import edu.tecsup.seguridad.util.Conexion;

public class RolDAO {

	protected Logger log = Logger.getLogger(getClass());
	
	public List<Rol> listar() throws DAOException{
		log.info("listar()");
		try{
			
			List<Rol> lista = new ArrayList<>();
			
			Connection con = Conexion.getConexion();
			
			String sql = "SELECT * FROM rol";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Rol rol = new Rol(rs.getInt("id"), rs.getString("nombre"));
				lista.add(rol);
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
	
	public Rol obtener(Integer id) throws DAOException{
		log.info("obtener(id:"+id+")");
		try{
			
			Connection con = Conexion.getConexion();
			
			String sql = "SELECT * FROM rol WHERE id=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				Rol rol = new Rol(rs.getInt("id"), rs.getString("nombre"));
				return rol;
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
	
	public void insertar(Rol rol) throws DAOException{
		log.info("insertar(rol:"+rol+")");
		try{
			
			Connection con = Conexion.getConexion();
//			con.setAutoCommit(false);
			
			String sql = "INSERT INTO rol(nombre) VALUES(?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, rol.getNombre());
			stmt.executeUpdate();
			
//			con.commit();
			
			stmt.close();
			con.close();
			
		}catch(Exception e){
//			con.rollback();
			log.error(e.toString());
			throw new DAOException(e.getMessage());
		}
	}
	
	public void actualizar(Rol rol) throws DAOException{
		log.info("actualizar(rol:"+rol+")");
		try{
			
			Connection con = Conexion.getConexion();
			
			String sql = "UPDATE rol SET nombre=? WHERE id=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, rol.getNombre());
			stmt.setInt(2, rol.getId());
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
			
			String sql = "DELETE FROM rol WHERE id = ?";
			
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
