package com.desafiolatam.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.UserDTO;

/**
 * Servlet implementation class RegistraUsuario
 */
@WebServlet("/RegistraUsuario")
public class RegistraUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistraUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("mensaje", "");
		Facade facade = new Facade();
		UserDTO usuario;
		try {
			usuario=facade.SelectUser(request.getParameter("usuario"));
		if(usuario!=null) {
			request.setAttribute("mensaje", "El usuario ingresado ya existe");
			request.getRequestDispatcher("/Registro.jsp").forward(request, response);
		}else {
			usuario = new UserDTO();
		
		usuario.setNombreUsuario(request.getParameter("usuario"));
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setPassword(request.getParameter("clave"));
		usuario.setFechaNac(request.getParameter("fecha"));
		boolean registrado=facade.NewUser(usuario);
		
			if(registrado) {
				request.setAttribute("mensaje","Usuario ingresado correctamente");
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}else {
				request.setAttribute("mensaje","Error al registrar el usuario");
				request.getRequestDispatcher("/Registro.jsp").forward(request, response);
			}
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
