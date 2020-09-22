package com.desafiolatam.crud;

import java.sql.SQLException;
import java.util.List;

public interface HoroscopoCRUD <Horoscopo> {

	public boolean Inscribir(Object object) throws SQLException;
	
	public boolean Actualizar(Object object, Object object2) throws SQLException;
	
	public boolean Eliminar(Object object) throws SQLException;
	
	public Horoscopo Seleccionar(Object object) throws SQLException;
	
	public List<Horoscopo> ListarTodo() throws SQLException;
}
