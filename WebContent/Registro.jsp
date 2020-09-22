<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <% 
        String mensaje = (String) request.getAttribute("mensaje");
        %>
<body class="">
  <div class="container-fluid">
    <div class="row justify-content-center">
      <!-- columnas de color -->
      <div class="col-1  col-lg-2 bg-danger bg-patron"></div>
      <div class="col-1  col-lg-2 "></div>
        <div class=" col-8 col-lg-4 row vh-100 align-items-center  text-white">
          <!-- caja central -->
            <div class="col bg-patron py-3 px-4  rounded-lg">
                <div class="row">
                    <div class="col-12 text-center "><!-- logo dragon -->
                      <i class="fab fa-d-and-d fa-5x"></i>    
                    </div>  
                </div>
                <!-- solo formulario -->
                <div class="row">
                    <div class="col-12">
                        <form action="RegistraUsuario" method="POST" class="" id="registro">
                        <h4 class="text-center" id="alertas"><% if(mensaje!=null){ %>
                        <%=mensaje %>
                        <%}else{ %>
                        Ingrese todos los datos solicitados
                        <%} %> 
                        </h4>
                            <div class="form-group font-weight-bold ">
                                <label for="txtUsuario">Usuario</label>
                                <input type="text" class="form-control" id="txtUsuario" placeholder="Nombre Usuario" name="usuario" required>
                            </div><div class="form-group font-weight-bold ">
                                <label for="txtNombre">Nombre</label>
                                <input type="text" class="form-control" id="txtNombre" placeholder="Nombre" name="nombre" required>
                            </div>
                            <div class="form-group font-weight-bold">
                                <label for="txtClave ">Contraseña</label>
                                <p data-toggle="tooltip" class="d-inline" title="Las contraseñas deben tener 8 caracteres como mínimo y contener al menos dos de los siguientes elementos: mayúsculas, minúsculas, números y símbolos.">*</p>
                                <input type="password" class="form-control" id="txtClave" placeholder="Contraseña" name="clave" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>
                              </div>
                              <div class="form-group font-weight-bold">
                                <label for="txtClave ">Repita Contraseña</label> 
                                <input type="password" class="form-control" id="txtreClave" placeholder="Repita Contraseña" name="reClave" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>
                              </div>
                              
                              <div class="form-group font-weight-bold ">
                                <label for="dateFechaNac">Fecha</label>
                                <input type="date" class="form-control" id="dateFechaNac" placeholder="YYYY-MM-DD" name="fecha" required>
                            </div>
                              <div class="form-group text-center">
                                <button id="btnSubmit" type="submit"  class="btn btn-light ">Registrar</button>
                              </div>
                              
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- columnas de color -->
      <div class="col-1  col-lg-2"></div>
      <div class="col-1 col-lg-2 bg-danger bg-patron"></div>
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