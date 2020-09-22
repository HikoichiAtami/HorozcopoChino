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
 * Servlet implementation class BuscarModificar
 */
@WebServlet("/BuscarModificar")
public class BuscarModificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarModificar() {
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
		String nombreUsuario=request.getParameter("usuario");
		Facade  facade = new Facade();
		UserDTO usuario = new UserDTO();
		try {
			usuario = facade.SelectUser(nombreUsuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(usuario==null) {
			request.setAttribute("alerta", "Usuario no encontrado");
			request.getRequestDispatcher("Buscar_Modificar.jsp").forward(request, response);
		}else {
			request.setAttribute("funado", usuario);
			request.getRequestDispatcher("Modificar.jsp").forward(request, response);
		}
	}

}
