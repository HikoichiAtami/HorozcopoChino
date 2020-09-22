package com.desafiolatam.procesaConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

	private static ConexionDB instance;
	private Connection conexion;
	private String url = "jdbc:mysql://localhost:3306/horoscopo?serverTimezone=UTC";
	private String user = "root";
	private String pass = "Hikoichi56";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	private ConexionDB() throws SQLException {
		
		try {
			Class.forName(driver);
			this.conexion = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException ex) {
			System.out.println("Fallo la conexion a la Database: " + ex.getMessage());
		}
	}
	
	public Connection getConexion() {
		return conexion;
	}
	
	public static synchronized ConexionDB getInstance() throws SQLException {
		if(instance == null) {
			instance = new ConexionDB();
		}else if(instance.getConexion().isClosed()) {
			instance = new ConexionDB();
		}
		return instance;
	}
	
	public void closeConexion() throws SQLException {
		if(conexion != null) {
			conexion.close();
		}
	}
}
