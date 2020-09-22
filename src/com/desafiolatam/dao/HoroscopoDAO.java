package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.desafiolatam.crud.HoroscopoCRUD;
import com.desafiolatam.modelo.HoroscopoDTO;
import com.desafiolatam.procesaConexion.ConexionDB;

public class HoroscopoDAO implements HoroscopoCRUD {

	@Override
	public boolean Inscribir(Object object) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean Actualizar(Object object, Object object2) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean Eliminar(Object object) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public HoroscopoDTO Seleccionar(Object object) throws SQLException {
		// TODO Auto-generated method stub
		String date = (String) object;
		int year = Integer.parseInt(date.substring(0, 4));
		int signo = year % 12;
		String query = "SELECT * FROM horoscopo WHERE idHoroscopo = ?";
		Connection conexion = ConexionDB.getInstance().getConexion();
		HoroscopoDTO horoscopo = new HoroscopoDTO();
		try (
			PreparedStatement ps = conexion.prepareStatement(query);
			)
				{
			ps.setInt(1, signo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				horoscopo.setIdSigno(rs.getInt("idHoroscopo"));
				horoscopo.setNombreSigno(rs.getString("nombreSigno"));
				horoscopo.setDescripcion(rs.getString("descripcion"));
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			ConexionDB.getInstance().closeConexion();
		}
		return horoscopo;
	}

	@Override
	public List ListarTodo() throws SQLException {
		// TODO Auto-generated method stub
		List<HoroscopoDTO> horoscopoList = new ArrayList<HoroscopoDTO>();
		String query = "SELECT * FROM Horoscopo";
		Connection conexion = ConexionDB.getInstance().getConexion();
		try (
			PreparedStatement ps = conexion.prepareStatement(query);
			)
				{
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				HoroscopoDTO horoscopo = new HoroscopoDTO();
				horoscopo.setIdSigno(rs.getInt("idHoroscopo"));
				horoscopo.setNombreSigno(rs.getString("nombreSigno"));
				horoscopo.setDescripcion(rs.getString("descripcion"));
				horoscopoList.add(horoscopo);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			ConexionDB.getInstance().closeConexion();
		}
		return horoscopoList;
	}

	public Map<String,Double> ContadorHoroscopo() throws SQLException{
		Map<String, Double> map = new HashMap<String,Double>();
		String consulta = "SELECT nombreSigno,FORMAT((COUNT(id_Horoscopo)* 100/(SELECT COUNT(*) FROM Usuario)),2) "
				+ "FROM Usuario JOIN Horoscopo " + 
				"ON(idHoroscopo = id_Horoscopo) " + 
				"GROUP BY nombreSigno";
		Connection conexion = ConexionDB.getInstance().getConexion();
		PreparedStatement ps = conexion.prepareStatement(consulta);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			map.put(rs.getString("nombreSigno"), rs.getDouble(2));
		}
		return map;
	}

}
