<%-- 
    Document   : personalperfil
    Created on : 24-may-2020, 11:13:28
    Author     : ernesto
--%>

<%@page import="modelo.entidades.Personal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Personal personal = (Personal)session.getAttribute("personal"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no"/>
        <link rel="stylesheet" href="Estilos/CSS/font.css">
        <link rel="stylesheet" href="Estilos/CSS/estilos.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>Manga Box - Principal</title>
    </head>
    <body style="background-color: #1E1E1E">
        <nav class="navbar navbar-expand-lg navbar-light pt-4 pb-xl-4 pb-2" style="background-color: black">
            <div class="container-fluid pb-2 pb-xl-0" style="color: white">
                <form action="SeriePersonal.htm" method="post" class="d-lg-none d-block">
                    <input type="submit" value="ADMINISTRACION" class="h5 mt-2 p-2"
                           style="color: yellow; font-family: fuente; 
                           background-color: black; border: black; font-size: 15px">
                </form>
                <form action="SeriePersonal.htm" method="post" class="d-lg-block d-none">
                    <input type="submit" value="ADMINISTRACION" class="h5 mt-2 p-2"
                           style="color: yellow; font-family: fuente; 
                           background-color: black; border: black;">
                </form>
                <button class="navbar-toggler text-white rounded-0" style="background-color: yellow" type="button" 
                        data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false"
                        aria-label="Toggle navigaton">
                    <span class="navbar-toggler-icon"></span> 
		</button>
                <div class="collapse navbar-collapse justify-content-end" 
                     id="navbarSupportedContent" style="color: white">
                    <ul class="nav navbar-nav">
                        <li class="nav-item">
                            <div class="dropdown">
                                <button class="btn btn-secondary dropdown-toggle foco" 
                                        type="button" id="dropdownMenuButton" 
                                        data-toggle="dropdown" aria-haspopup="true" 
                                        aria-expanded="false" style="background-color: black; border: black">
                                        <%= personal.getNombre() %>
                                </button>
                                <div id="divusuario" class="p-0 dropdown-menu dropdown-menu-right" 
                                     aria-labelledby="dropdownMenuButton" style="color: white; background-color: #1E1E1E">
                                    <form id="formperfil" action="VerPerfilPersonal.htm" method="post">
                                        <p class="pt-4 pt-lg-4 text-center" style="color: white; cursor: pointer;"
                                           onclick="document.querySelector('#formperfil').submit()">
                                            Perfil
                                        </p> 
                                    </form>
                                    <form id="formsesion" action="CerrarSesionPersonal.htm" method="post" style="background-color: #1E1E1E" 
                                          class="dropdown-item form-inline my-2 my-lg-0">
                                        <p class="pt-2 pt-lg-0 pb-lg-2 text-center" style="color: white; cursor: pointer;"
                                           onclick="document.querySelector('#formsesion').submit()">
                                            Cerrar sesión
                                        </p>
                                    </form> 
                                </div>
                            </div>  
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
                                
        <section class="mt-1" style="background-color: #1E1E1E; color: white;">
            <p class="h3 mt-5 mb-2 text-center">Perfil personal</p>
            <p class="mb-5 text-center">Sólo podrá modificar los campos habilitados a continuación.<p>
            <div class="col-xl-6 offset-xl-3 col-lg-4 offset-lg-4 col-md-6 
                 offset-md-3 col-sm-8 offset-sm-2 col-10 offset-1">
                <form action="ActualizarPersonal.htm" method="post">
                    <input id="foto" type="hidden" name="passwordadmin" value="<%= personal.getContraseña() %>">
                    <div class="input-group mt-3 mb-3">
                        <input name="nombre" type="text" value="<%= personal.getNombre()%>"
                            class="form-control rounded-0" 
                            aria-label="Default" required placeholder="Nombre" 
                            aria-describedby="inputGroup-sizing-default">
                    </div>
                    <p class="text-center">¿Nueva contraseña?</p>
                    <div class="input-group mb-4">
                        <input name="passwordpersonal" type="password" 
                            class="form-control rounded-0" 
                            aria-label="Default" placeholder="Contraseña" 
                            aria-describedby="inputGroup-sizing-default">
                    </div>  
                    <div class="foco manga3 text-center pt-2 pb-2 pb-sm-0 mb-5">
                        <input type="submit" 
                            class="btn col-xl-6 col-8 col-sm-8 rounded-0" 
                            value="ACTUALIZAR DATOS">
                    </div>
                </form>
            </div>
        </section>                        
        
        <section class="mt-1" style="background-color: black; color: white;">
            <footer>
                <div class="pt-5 d-flex flex-column flex-md-row justify-content-around">
                    <div class="text-center text-md-left">
                        <a href="#" style="color: white;">Preguntas frecuentes</a><br>
                        <a class="mt-3" href="#" style="color: white;">Política de Privacidad</a><br>
                        <a class="mt-3" href="#" style="color: white;">¿Dónde ver?</a><br>
                        <a class="mt-3" href="#" style="color: white;">Contacta con nosotros</a><br>
                    </div>
                    <div class="pt-5 pt-md-0 text-center text-md-left">
                        <a href="#" style="color: white;">Términos de uso</a><br>
                        <a class="mt-3" href="#" style="color: white;">Cookies</a><br>
                        <a class="mt-3" href="#" style="color: white;">Avisos legales</a><br>
                    </div>
                </div>
                <p class="text-center pt-5 pb-3" 
                    style="font-size: 10px; font-family: fuente;">
                    MANGA BOX 
                    <i class="fa fa-copyright" aria-hidden="true" 
                        style="font-size: 18px"></i>
                </p>
                <br>
            </footer>
        </section>
    </body>
</html>
