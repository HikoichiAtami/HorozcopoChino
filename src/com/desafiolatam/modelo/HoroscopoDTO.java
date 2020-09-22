package com.desafiolatam.modelo;

public class HoroscopoDTO {

	private int idSigno;
	private String nombreSigno;
	private String descripcion;
	
	public HoroscopoDTO(int idSigno, String nombreSigno, String descripcion) {
		super();
		this.idSigno = idSigno;
		this.nombreSigno = nombreSigno;
		this.descripcion = descripcion;
	}

	public HoroscopoDTO() {
		super();
	}

	public int getIdSigno() {
		return idSigno;
	}

	public void setIdSigno(int idSigno) {
		this.idSigno = idSigno;
	}

	public String getNombreSigno() {
		return nombreSigno;
	}

	public void setNombreSigno(String nombreSigno) {
		this.nombreSigno = nombreSigno;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "HoroscopoDTO [idSigno=" + idSigno + ", nombreSigno=" + nombreSigno + ", descripcion=" + descripcion
				+ "]";
	}
	
	
	
}
