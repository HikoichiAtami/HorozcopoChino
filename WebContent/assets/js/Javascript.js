$(document).ready(function () {

        $("#btnSubmit").click(function () {
        	 var regex = /(([1][0-2]|[0][0-9])[-.\/]([0-2][0-9]|[3][0-1])[-.\/][1-9]([0-9]{3}))|([1-9]([0-9]{3})[-.\/]([1][0-2]|[0][0-9])[-.\/]([0-2][0-9]))/
            if ($("#txtClave").val() != $("#txtreClave").val()) {
                $("#alertas").text("Las contraseñas no coinciden");
                $("#txtreClave").val("");
            }
            if(!regex.test($("#dateFechaNac").val())){
                	alert("La fecha ingresada no es valida");
                	return false;
                }
        });
        
        $("#cambioClave").click(function(){
        	 if ($("#txtClave").val() != $("#txtreClave").val()) {
                 $("#alertas").text("Las claves no coinciden");
                 $("#txtreClave").val("");
             }
        	$('#newClave').attr({action:"Clave", method:"post"});
        	$('#newClave').submit();
        });
        
        $("#linkListar").click(function(){
        	$('#formNavBar').attr({action:"ListarUsuarios", method:"post"});
        	//action="ListadoPerfiles.jsp";
        	$('#formNavBar').submit();
        });
        
        $("#linkEstadisticas").click(function(){
        	$('#formNavBar').attr({action:"GraficoHoroscopo", method:"post"});
        	$('#formNavBar').submit();
        });
        
        $("#linkHome").click(function(){
        	$('#formNavBar').attr('action','Perfil_Inicio.jsp');
        	//action="ListadoPerfiles.jsp";
        	$('#formNavBar').submit();
        });
        
        $("#linkMiZodiaco").click(function(){
        	$('#formNavBar').attr({action:"Signo", method:"post"});
        	//action="ListadoPerfiles.jsp";
        	$('#formNavBar').submit();
        });
        
        $("#linkBuscarPerfil").click(function(){
        	$('#formNavBar').attr('action','Buscar.jsp');
        	//action="Buscar.jsp";
        	$('#formNavBar').submit();
        });
        
        $("#linkModificar").click(function(){
        	$('#formNavBar').attr('action','Buscar_Modificar.jsp');
        	//action="Buscar_modificar.jsp";
        	$('#formNavBar').submit();
        });
        
        $("#linkEliminar").click(function(){
        	$('#formNavBar').attr('action','Buscar_Eliminar.jsp');
        	//action="Buscar_Eliminar.jsp";
        	$('#formNavBar').submit();
        });
        
        $("#linkSignos").click(function(){
        		$('#formNavBar').attr('action','BuscarSigno.jsp');
            	$('#formNavBar').submit();     	
        });
        
        $("#linkLogOut").click(function(){
        	var opcion = confirm("Esta Seguro de Abandonar su Sesion")
        	if(opcion == true){
        		$('#formNavBar').attr({action:"LogOut", method:"post"});
        		$('#formNavBar').submit();
        	}
        });
        
       
        
        $('.nav-link').css('cursor', 'pointer');
    });


    function toRegistrar(){
	  	document.formulario.action="Registro.jsp";
	   	document.formulario.submit();
  }
   
    $("#yearSearch").click(function(){
    	var regex = /(([1][0-2]|[0][0-9])[-.\/]([0-2][0-9]|[3][0-1])[-.\/][1-9]([0-9]{3}))|([1-9]([0-9]{3})[-.\/]([1][0-2]|[0][0-9])[-.\/]([0-2][0-9]))/
        if(regex.test($("#txtUsuario").val())){
        	$("#buscaSigno").submit();
        }else{
        	alert("La fecha ingresada no es valida");
        	return false;
        }
    });
    
    
    
    
    