<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.desafiolatam.modelo.HoroscopoDTO" %>
    <%@ page import="com.desafiolatam.modelo.UserDTO" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Horoscopo Chino</title>

    <!-- <link rel="stylesheet" href="style.css"> -->
    <!-- BOOSTRAP -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        
    <!--FONT AWEONSOME -->
    <script src="https://kit.fontawesome.com/251a436168.js" crossorigin="anonymous"></script>
    <!--JQUERY -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
   	<!--OWN CSS -->
   	<link rel="stylesheet" type="text/css" href="assets/css/style.css">
    
</head>
<body class="">
    <nav class="navbar navbar-expand-lg navbar-dark bg-patron text-dark">
        <a class="navbar-brand">
            <i class="fab fa-d-and-d fa-4x"></i>  
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <form id="formNavBar" class="w-100">
        <div class="collapse navbar-collapse" id="navbarNav">
        
          <ul class="navbar-nav">
          <li class="nav-item">
                <a id="linkHome" class="nav-link text-light"  ><i class="fa fa-home"></i> Mi Perfil</a>
              </li>
            <li class="nav-item ">
               
              <a id="linkListar" class="nav-link text-light" ><i class="fas fa-globe"></i> Todos los perfiles</a>
            </li>
            <li class="nav-item">
              <a id="linkBuscarPerfil" class="nav-link text-light"  ><i class="fas fa-search"></i> Buscar Perfil</a>
            </li>
            <li class="nav-item">
              <a id="linkModificar" class="nav-link text-light" ><i class="fas fa-pen-alt"></i> Modificar Perfil</a>
            </li>
            <li class="nav-item">
                <a id="linkEliminar" class="nav-link text-light"  ><i class="fas fa-skull"></i> Eliminar Perfil</a>
              </li>
              <li class="nav-item">
                <a id="linkMiZodiaco" class="nav-link text-light"  ><i class="fas fa-star"></i> Mi Zodiaco Chino</a>
              </li>
              <li class="nav-item">
                <a id="linkEstadisticas" class="nav-link text-light"  ><i class="far fa-sun"></i> Zodialestadisticas</a>
              </li>
              <li class="nav-item">
                <a id="linkSignos" class="nav-link text-light"  ><i class="fa fa-flask"></i> Buscar Signo</a>
              </li>
          </ul>
          
        	<a id="linkLogOut"  class="nav-link text-light  ml-auto"><!-- icono log out -->
            	<i class="fas fa-power-off fa-2x"></i>   
        	</a> 
        
        </div>
        </form>
    </nav>
      <div class="card mx-5 my-3 px-3">
        <div class="card-body">
          <h3 class="card-title">Lista de usuarios registrados</h3>
          <table class="table table-light rounded-lg table-striped mt-3">
            <thead>
              <tr>
                <th scope="col">USUARIO</th>
                <th scope="col">NOMBRE</th>
                <th scope="col">FECHA NAC</th>
                <th scope="col">SIGNO</th>
              </tr>
            </thead>
 
            <% List<UserDTO> usuario = (List<UserDTO>)request.getAttribute("usuario");
            List<HoroscopoDTO> horoscopo = (List<HoroscopoDTO>)request.getAttribute("horoscopo");
            out.print("<tbody>");
            for(UserDTO user  : usuario){
            	out.print("<tr>");
              
                
                out.print("<td>");
                out.print(user.getNombreUsuario());
                out.print("</td>");
                
                out.print("<td>");
                out.print(user.getNombre());
                out.print("</td>");
                
                out.print("<td>");
                out.print(user.getFechaNac());
                out.print("</td>");
                
                out.print("<td>");
                for(HoroscopoDTO signo : horoscopo){
                	if(user.getIdHoroscopo() == signo.getIdSigno()){
                		out.print(signo.getNombreSigno());
                	}
                }
                out.print("</td>");
               
                out.print("</tr>");
                out.print("</tbody>");
            }
            %>
          </table>
        </div>
      </div>
     
     
     


    <!-- BOOSTRAP  JS POPPER -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

<script type="text/javascript" src="assets/js/Javascript.js"></script>
</body>
</html>