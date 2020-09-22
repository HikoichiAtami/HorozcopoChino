package com.desafiolatam.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;

/**
 * Servlet implementation class Clave
 */
@WebServlet("/Clave")
public class Clave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Clave() {
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
		Facade facade = new Facade();
		String alerta = "";
		String username = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		boolean actualizado = false;
		try {
			actualizado = facade.CambiarClave(username, clave);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(actualizado) {
			alerta="La contraseña del usuario "+username+" ha sido actualizada.";
		}else {

			alerta="No fue posible actualizar la contraseña del usuario "+username;
		}
		request.setAttribute("mensaje", alerta);
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

}
