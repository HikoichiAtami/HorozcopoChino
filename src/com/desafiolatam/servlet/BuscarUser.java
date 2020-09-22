package com.desafiolatam.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.HoroscopoDTO;
import com.desafiolatam.modelo.UserDTO;

/**
 * Servlet implementation class BuscarUser
 */
@WebServlet("/BuscarUser")
public class BuscarUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarUser() {
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
		UserDTO usuario = new UserDTO();
		HoroscopoDTO horoscopo = new HoroscopoDTO();
		try {
			if(facade.SelectUser(request.getParameter("usuario")) == null) {
				request.setAttribute("mensaje", "Lo sentimos");
				request.setAttribute("mensaje2", "El usuario ingresado no existe");
				RequestDispatcher rd = request.getRequestDispatcher("Buscar.jsp");
				rd.forward(request, response);
			}
			usuario = facade.SelectUser(request.getParameter("usuario"));
			horoscopo = facade.SeleccionarHoroscopo(usuario.getFechaNac());
			request.setAttribute("usuario", usuario);
			request.setAttribute("horoscopo", horoscopo);
			RequestDispatcher rd = request.getRequestDispatcher("Resultado_Buscar.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
