package com.desafiolatam.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desafiolatam.facade.Facade;
import com.desafiolatam.modelo.HoroscopoDTO;
import com.desafiolatam.modelo.UserDTO;

/**
 * Servlet implementation class ProcesaLogin
 */
@WebServlet("/ProcesaLogin")
public class ProcesaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesaLogin() {
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
		String user = request.getParameter("usuario");
		String pass = request.getParameter("clave");
		List<UserDTO> userList = new ArrayList<UserDTO>();
		try {
			userList = facade.ListAllUser();
			for(UserDTO dto : userList) {
				if(dto.getNombreUsuario().equals(user)) {
					if(dto.getPassword().equals(pass)) {
						HttpSession sesion = request.getSession(true);
						horoscopo = facade.SeleccionarHoroscopo(dto.getFechaNac());
						usuario.setNombre(dto.getNombre());
						usuario.setNombreUsuario(dto.getNombreUsuario());
						usuario.setPassword(dto.getPassword());
						usuario.setFechaNac(dto.getFechaNac());
						usuario.setIdHoroscopo(dto.getIdHoroscopo());
						request.setAttribute("signo", horoscopo.getNombreSigno());
						sesion.setAttribute("user", dto.getNombreUsuario());
						sesion.setAttribute(dto.getNombreUsuario(), usuario);
						RequestDispatcher rd = request.getRequestDispatcher("Perfil_Inicio.jsp");
						rd.forward(request, response);
					}else {
						request.setAttribute("mensaje", "La clave es incorrecta");
						RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
						rd.forward(request, response);
					}
				}	
			}
			request.setAttribute("mensaje", "El Usuario ingresado no existe");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
