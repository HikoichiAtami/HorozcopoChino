package com.desafiolatam.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.HoroscopoDTO;
import com.desafiolatam.modelo.UserDTO;
import com.desafiolatam.procesaConexion.ConexionDB;

public class main {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Double a = 11.222222222222222;
		DecimalFormat formateador = new DecimalFormat("####.##");
		String b = formateador.format(a);
		System.out.println(b);
		Map<String, String> map = new HashMap<String,String>();
		map.put("hola", b);
		for(String d : map.keySet()) {
			System.out.println(d);
			System.out.println(map.get(d));
		}
//		String consulta = "SELECT nombreSigno, COUNT(id_Horoscopo) FROM Usuario JOIN Horoscopo " + 
//				"ON(idHoroscopo = id_Horoscopo) " + 
//				"GROUP BY nombreSigno";
//		Connection conexion = ConexionDB.getInstance().getConexion();
//		PreparedStatement ps = conexion.prepareStatement(consulta);
//		ResultSet rs = ps.executeQuery();
//		while(rs.next()) {
//			map.put(rs.getString("nombreSigno"), rs.getInt(2));
//	
//		}
//		for(String ma : map.keySet()) {
//			System.out.println(ma + " " + map.get(ma));
//			
//		}
		}
		
	}

