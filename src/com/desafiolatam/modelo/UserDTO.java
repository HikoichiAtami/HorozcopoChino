package com.desafiolatam.modelo;

public class UserDTO {
	
	private String nombre;
	private String nombreUsuario;
	private String password;
	private String fechaNac;
	private int idHoroscopo;
	
	public UserDTO(String nombre, String nombreUsuario, String password, String fechaNac, int idHoroscopo) {
		super();
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.fechaNac = fechaNac;
		this.idHoroscopo = idHoroscopo;
	}

	public UserDTO() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public int getIdHoroscopo() {
		return idHoroscopo;
	}

	public void setIdHoroscopo(int idHoroscopo) {
		this.idHoroscopo = idHoroscopo;
	}

	@Override
	public String toString() {
		return "UserDTO [nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", password=" + password
				+ ", fechaNac=" + fechaNac + ", idHoroscopo=" + idHoroscopo + "]";
	}
	
	
	
	
}
