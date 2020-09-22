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

/**
 * Servlet implementation class BuscaSigno
 */
@WebServlet("/BuscaSigno")
public class BuscaSigno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscaSigno() {
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
		HoroscopoDTO horoscopo = new HoroscopoDTO();
		String fecha = request.getParameter("year");
		try {
			horoscopo = facade.SeleccionarHoroscopo(fecha);
			request.setAttribute("horoscopo", horoscopo);
			request.setAttribute("true", "ok");
			RequestDispatcher rd = request.getRequestDispatcher("BuscarSigno.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
