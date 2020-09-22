package com.desafiolatam.facade;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.desafiolatam.dao.HoroscopoDAO;
import com.desafiolatam.dao.UsuarioDAO;
import com.desafiolatam.modelo.HoroscopoDTO;
import com.desafiolatam.modelo.UserDTO;

public class Facade {

	public static boolean NewUser(UserDTO user) throws SQLException{
		UsuarioDAO usuario = new UsuarioDAO();
		return usuario.Inscribir(user);
	}
	
	public static boolean UpdateUser(UserDTO user, String key) throws SQLException  {
		//se añadio el argumento id a la funcion actual y a la funcion Actualizar
		UsuarioDAO usuario = new UsuarioDAO();
		return usuario.Actualizar(user,key);
	}
	
	public static boolean DeleteUser(String key) throws SQLException {
		UsuarioDAO usuario = new UsuarioDAO();
		return usuario.Eliminar(key);
	}
	
	public static UserDTO SelectUser(String key) throws SQLException {
		//se modifico el dao, ya que el listar no necesita ningun argumento 
		UsuarioDAO usuario = new UsuarioDAO();
		return usuario.Seleccionar(key);
	}
	
	public static List<UserDTO> ListAllUser() throws SQLException {
		UsuarioDAO usuario = new UsuarioDAO();
		return usuario.ListarTodo();
	}
	
	public static List<HoroscopoDTO> ListHoroscopo() throws SQLException {
		HoroscopoDAO horoscopo =  new HoroscopoDAO();
		return horoscopo.ListarTodo();
	}
	
	public static Map<String,Double> Grafico() throws SQLException{
		HoroscopoDAO horoscopo = new HoroscopoDAO();   
		return horoscopo.ContadorHoroscopo();
	}
	
	public static HoroscopoDTO SeleccionarHoroscopo(String key) throws SQLException {
		HoroscopoDAO horoscopo = new HoroscopoDAO();
		return horoscopo.Seleccionar(key);
	}
	
	public static boolean CambiarClave(Object key, Object key2) throws SQLException {
		UsuarioDAO user = new UsuarioDAO();
		return user.ActualizarClave(key, key2);
	}
}
