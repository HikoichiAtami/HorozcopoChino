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
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
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
		boolean modificado=false;
		boolean existeUser=false;
		String alerta="";
		UserDTO user = new UserDTO();
		UserDTO user2 = new UserDTO();
		String exUser=request.getParameter("userName");
		user.setNombreUsuario(request.getParameter("usuario"));
		user.setNombre(request.getParameter("nombre"));
		user.setPassword(request.getParameter("pass"));
		user.setFechaNac(request.getParameter("fechaNac"));
		Facade facade = new Facade();
		System.out.println(user.getNombreUsuario()+" "+exUser);
		if(user.getNombreUsuario().equals(exUser)) {
			System.out.println("iguales: "+user.getNombreUsuario().equals(exUser));
			
		}else {
			System.out.println("iguales: "+user.getNombreUsuario().equals(exUser));
			
			try {
				user2 = facade.SelectUser(user.getNombreUsuario());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(user2!=null) {
				existeUser = true;
			}
			
		}
		
		if(existeUser) {
			request.setAttribute("alerta", "Nuevo usuario ya existe");
			user.setNombreUsuario(exUser);
			request.setAttribute("funado", user );
			request.getRequestDispatcher("Modificar.jsp").forward(request, response);
		}else {
			try {
				modificado=facade.UpdateUser(user, exUser);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(modificado) {
				request.setAttribute("alerta", "usuario "+user.getNombreUsuario()+
					(user.getNombreUsuario().equals(exUser)?" ":" (ex "+exUser+") ")+"fue modificado con exito" );
				
				request.getRequestDispatcher("Buscar_Modificar.jsp").forward(request, response);
			}else {
				request.setAttribute("alerta", "Sucedio algo y no se pudo actualizar el usuario" );
					
					request.getRequestDispatcher("Buscar_modificar.jsp").forward(request, response);
			}
		}
	}

}
