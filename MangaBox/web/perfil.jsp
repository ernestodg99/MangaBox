<%-- 
    Document   : perfil
    Created on : 29-abr-2020, 17:52:00
    Author     : ernesto
--%>
<%@page import="modelo.entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Usuario us = (Usuario)session.getAttribute("usuario"); %>
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
                <form action="VerMangas.htm" method="post" class="d-lg-none d-block">
                    <input type="submit" value="MANGABOX" class="h5 mt-2 p-2"
                           style="color: red; font-family: fuente; 
                           background-color: black; border: black; font-size: 15px">
                </form>
                <form action="VerMangas.htm" method="post" class="d-lg-block d-none">
                    <input type="submit" value="MANGABOX" class="h5 mt-2 p-2"
                           style="color: red; font-family: fuente; 
                           background-color: black; border: black;">
                </form>
                <button class="navbar-toggler text-white" 
                        style="background-color: red" type="button" 
                        data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false"
                        aria-label="Toggle navigaton">
                    <span class="navbar-toggler-icon"></span> 
		</button>
                <div class="collapse navbar-collapse justify-content-end" 
                     id="navbarSupportedContent" style="color: white">
                    <ul class="nav navbar-nav">
                        <li class="nav-item mr-lg-5">
                            <form id="inicio" action="VerMangas.htm" method="post">
                               <p class="pt-2" style="color: white; cursor: pointer;"
                                  onclick="document.querySelector('#inicio').submit()">
                                    Inicio <span class="sr-only">(current)</span>
                                </p> 
                            </form> 
                        </li>
                        <li class="nav-item mr-lg-5">
                            <form id="formmanga" action="VerMangas2.htm" method="post">
                               <p class="pt-2" style="color: white; cursor: pointer;"
                                  onclick="document.querySelector('#formmanga').submit()">
                                    Mangas
                                </p> 
                            </form>
                        </li>
                        <li class="nav-item mr-lg-5">
                            <form id="formfav" action="VerFavoritos.htm" method="post">
                               <p class="pt-2" style="color: white; cursor: pointer;"
                                  onclick="document.querySelector('#formfav').submit()">
                                    Favoritos
                                </p> 
                            </form>
                        </li>
                        <li class="nav-item">
                            <div class="dropdown">
                                <button class="btn btn-secondary dropdown-toggle foco" 
                                        type="button" id="dropdownMenuButton" 
                                        data-toggle="dropdown" aria-haspopup="true" 
                                        aria-expanded="false" style="background-color: black; border: black">
                                    <img class="foco" src="<%= us.getFoto() %>" style="width: 40px">
                                </button>
                                <div id="divusuario" class="p-0 dropdown-menu dropdown-menu-right" 
                                     aria-labelledby="dropdownMenuButton" style="color: white; background-color: #1E1E1E">
                                    <form id="formperfil" action="VerPerfil.htm" method="post">
                                        <p class="pt-4 pt-lg-4 text-center" style="color: white; cursor: pointer;"
                                            onclick="document.querySelector('#formperfil').submit()">
                                            Perfil
                                        </p> 
                                    </form>
                                    <form id="formsesion" action="CerrarSesion.htm" method="post" style="background-color: #1E1E1E" 
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
            <div class="pt-4 pb-3 col-12 d-flex flex-column flex-md-row">
                <div class="text-center p-2 pb-3 col-md-6">
                    <p class="text-center">Foto de perfil actual:</p>
                    <img src="<%= us.getFoto() %>" width="200px">
                </div>
                <div class="p-2 pb-3 col-10 offset-1 col-md-6 offset-md-0 d-flex
                     flex-column">
                    <p class="text-center">Elije una foto de perfil:</p>
                    <div class="pb-3 d-flex flex-row justify-content-around ">
                        <img id="img1" src="Estilos/Imagenes/onepiece.png" 
                            style="width: 100px; height: 100px">
                        <img id="img2" src="Estilos/Imagenes/naruto.png" 
                            style="width: 100px; height: 100px">
                        <img id="img3" src="Estilos/Imagenes/bola.png" 
                            style="width: 100px; height: 100px">
                    </div>
                    <div class="d-flex flex-row justify-content-around">
                        <img id="img4" src="Estilos/Imagenes/law.jpg" 
                            style="width: 100px; height: 100px">
                        <img id="img5" src="Estilos/Imagenes/snaruto.png" 
                            style="width: 100px; height: 100px">
                        <img id="img6" src="Estilos/Imagenes/db.jpg" 
                            style="width: 100px; height: 100px">
                    </div>
                </div>
            </div>
                
            <div class="col-xl-6 offset-xl-3 col-lg-4 offset-lg-4 col-md-6 
                 offset-md-3 col-sm-8 offset-sm-2 col-10 offset-1">
                <form action="ActualizarUsuario.htm" method="post">
                    <input id="foto" type="hidden" name="foto" value="<%= us.getFoto() %>">
                    <div class="input-group mt-3 mb-3">
                        <input name="nombre" type="text" value="<%= us.getNombre()%>"
                            class="form-control rounded-0" 
                            aria-label="Default" required placeholder="Nombre" 
                            aria-describedby="inputGroup-sizing-default">
                    </div>
                    <div class="input-group mb-3">
                        <input name="apellidos" type="text" value="<%= us.getApellidos()%>"
                            class="form-control rounded-0" 
                            aria-label="Default" required placeholder="Apellidos" 
                            aria-describedby="inputGroup-sizing-default">
                    </div>
                    <div class="input-group mb-3">
                        <input name="email" type="email" value="<%= us.getEmail()%>"
                            class="form-control rounded-0" 
                            aria-label="Default" required placeholder="Email"
                            aria-describedby="inputGroup-sizing-default">
                    </div>
                    <p class="text-center">¿Nueva contraseña?</p>
                    <div class="input-group mb-4">
                        <input name="password" type="password" 
                            class="form-control rounded-0" 
                            aria-label="Default" placeholder="Contraseña" 
                            aria-describedby="inputGroup-sizing-default">
                    </div>  
                    <div class="manga2 text-center pt-2 pb-2 pb-sm-0 mb-5">
                        <input type="submit" 
                            class="foco btn col-xl-6 col-8 col-sm-8 rounded-0" 
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
                        <br>
                    </div>
                </div>
                <p class="text-center pb-3" 
                    style="font-size: 10px; font-family: fuente;">
                    MANGA BOX 
                    <i class="fa fa-copyright" aria-hidden="true" 
                        style="font-size: 18px"></i>
                </p>
                <br>
            </footer>
        </section>   
        <!-- SCRIPT PARA PONER BORDE A LAS IMAGENES SELECCIONADAS, 
        MÁS INFO EN CÓDIGO JS -->
        <script src="Estilos/JS/imgborder.js"></script>
    </body>
</html>
