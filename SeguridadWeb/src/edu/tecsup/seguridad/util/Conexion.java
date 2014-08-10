package edu.tecsup.seguridad.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Conexion {

//	public static Connection getConexion() throws SQLException {
//		Connection con = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost/seguridad", "root", "");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} 
//		return con;
//	}
	
	public static Connection getConexion() throws SQLException {
		Connection con = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource datasource = (DataSource) envContext.lookup("jdbc/seguridad");
			con = datasource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} 
		return con;
	}


	
}
