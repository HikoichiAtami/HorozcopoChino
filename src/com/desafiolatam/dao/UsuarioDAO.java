package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.desafiolatam.crud.HoroscopoCRUD;
import com.desafiolatam.modelo.UserDTO;
import com.desafiolatam.procesaConexion.ConexionDB;

public class UsuarioDAO implements HoroscopoCRUD {

	@Override
	public boolean Inscribir(Object object) throws SQLException {
		// TODO Auto-generated method stub
		int result = 0;
		UserDTO user = new UserDTO();
		user = (UserDTO) object;
		int year = Integer.parseInt(user.getFechaNac().substring(0, 4));
		int horoscopo = year % 12;
		String query = "INSERT INTO Usuario(nombreUsuario,nombre,pass,fechaNac,id_Horoscopo)" + "VALUES(?,?,?,?,?)";
		Connection conexion = ConexionDB.getInstance().getConexion();
		
		try (PreparedStatement ps = conexion.prepareStatement(query);) {
			
				ps.setString(1, user.getNombreUsuario());
				ps.setString(2, user.getNombre());
				ps.setString(3, user.getPassword());
				ps.setString(4, user.getFechaNac());
				ps.setInt(5, horoscopo);
				result = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConexionDB.getInstance().closeConexion();
		}
		if(result > 0) {
			System.out.println("Solicitud procesada con exito");
			return true;
		}
		System.out.println("Ha habido un error al procesar la solicitud");
		return false;
	}

	@Override
	public boolean Actualizar(Object object, Object object2) throws SQLException {
		// TODO Auto-generated method stub
		UserDTO user = new UserDTO();
		String userName = (String) object2;
		user = (UserDTO) object;
		int success = 0;
		String query = "UPDATE Usuario SET nombreUsuario = ?,nombre = ?, pass= ?, fechaNac= ? WHERE nombreUsuario = ?";
		Connection conexion = ConexionDB.getInstance().getConexion();
		try (
			PreparedStatement ps = conexion.prepareStatement(query);
			)
				{
				ps.setString(1, user.getNombreUsuario());
				ps.setString(2, user.getNombre());
				ps.setString(3, user.getPassword());
				ps.setString(4, user.getFechaNac());
				ps.setString(5, userName);
				success = ps.executeUpdate();
				return (success !=0);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			ConexionDB.getInstance().closeConexion();
		}
		return false;
	}

	@Override
	public boolean Eliminar(Object object) throws SQLException {
		// TODO Auto-generated method stub
		int success = 0;
		String UserName = (String) object;
		String query = "DELETE FROM Usuario WHERE nombreUsuario = ?";
		Connection conexion = ConexionDB.getInstance().getConexion();
		try (
			PreparedStatement ps = conexion.prepareStatement(query);
			)
				{
				ps.setString(1, UserName);
				success = ps.executeUpdate();
				return (success !=0);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			ConexionDB.getInstance().closeConexion();
		}
		return false;
	}

	@Override
	public UserDTO Seleccionar(Object object) throws SQLException {
		// TODO Auto-generated method stub
		String userName = (String) object;
		UserDTO user = new UserDTO();
		String query = "SELECT * FROM Usuario WHERE nombreUsuario = ?";
		Connection conexion = ConexionDB.getInstance().getConexion();
		try (
			PreparedStatement ps = conexion.prepareStatement(query);
			)
				{
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user.setNombreUsuario(rs.getString("nombreUsuario"));
				user.setNombre(rs.getString("nombre"));
				user.setPassword(rs.getString("pass"));
				user.setFechaNac(rs.getString("fechaNac"));
				user.setIdHoroscopo(rs.getInt("id_Horoscopo"));
				
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			ConexionDB.getInstance().closeConexion();
		}
		if((user.getNombre() == null) || (user.getFechaNac() == null) || (user.getPassword() == null) || (user.getNombreUsuario() == null)) {
			System.out.println("Ha habido un error al procesar la solicitud");
			return null;
		}
		System.out.println("Solicitud procesada con exito");
		return user;
	}

	@Override
	public List<UserDTO> ListarTodo() throws SQLException {
		// TODO Auto-generated method stub
		List<UserDTO> userList = new ArrayList<UserDTO>();
		String query = "SELECT * FROM Usuario";
		Connection conexion = ConexionDB.getInstance().getConexion();
		try (
			PreparedStatement ps = conexion.prepareStatement(query);
			)
				{
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UserDTO user = new UserDTO();
				user.setNombreUsuario(rs.getString("nombreUsuario"));
				user.setNombre(rs.getString("nombre"));
				user.setPassword(rs.getString("pass"));
				user.setFechaNac(rs.getString("fechaNac"));
				user.setIdHoroscopo(rs.getInt("id_Horoscopo"));
				userList.add(user);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			ConexionDB.getInstance().closeConexion();
		}
		if(userList.size() == 0) {
			System.out.println("Ha habido un error al procesar la solicitud");
			return null;
		}
		System.out.println("Solicitud procesada con exito");
		return userList;
	}
	
	public boolean ActualizarClave(Object object, Object object2) throws SQLException {
		int success = 0;
		String usuario = (String) object;
		String clave = (String) object2;
		String query = "UPDATE Usuario SET pass = ? where nombreUsuario = ?";
		Connection conexion = ConexionDB.getInstance().getConexion();
		try (
			PreparedStatement ps = conexion.prepareStatement(query);
			)
				{
				ps.setString(1, clave);
				ps.setString(2, usuario);
				success = ps.executeUpdate();
				return (success !=0);
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			ConexionDB.getInstance().closeConexion();
		}
		return false;
	}

	
}
