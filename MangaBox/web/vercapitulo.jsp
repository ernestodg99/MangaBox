<%-- 
    Document   : vercapitulo
    Created on : 20-abr-2020, 12:38:37
    Author     : ernesto
--%>

<%@page import="modelo.entidades.Comentario"%>
<%@page import="modelo.entidades.Usuario"%>
<%@page import="modelo.entidades.Capitulo"%>
<%@page import="modelo.entidades.Imagen"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Usuario us = (Usuario)session.getAttribute("usuario"); %>
<% Comentario coment = (Comentario)session.getAttribute("comentario"); %>
<% Capitulo capitulo = (Capitulo)session.getAttribute("usuariocap"); %>
<% Imagen[] imgs = (Imagen[])session.getAttribute("usuarioimagenes"); %>
<% Comentario[] comentarios = (Comentario[])session.getAttribute("usuariocomentarios"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no"/>
        <link rel="stylesheet" href="Estilos/CSS/font.css">
        <link rel="stylesheet" href="Estilos/CSS/estilos.css">
        
        <!-- OWL.CAROUSEL ESTILOS -->
        <link rel="stylesheet" href="https://owlcarousel2.github.io/OwlCarousel2/assets/owlcarousel/assets/owl.carousel.min.css">
        <link rel="stylesheet" href="https://owlcarousel2.github.io/OwlCarousel2/assets/owlcarousel/assets/owl.theme.default.min.css">
        
        <!-- OWL.CAROUSEL SCRIPTS -->
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://owlcarousel2.github.io/OwlCarousel2/assets/owlcarousel/owl.carousel.js"></script>
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
        <!-- SCRIPT PARA FUNCIONALIDAD DE AGREGAR COMENTARIOS -->
        <script src="Estilos/JS/addcomentario.js"></script>
        
        <!-- SCRIPT PARA LA VISUALIZACIÓN DEL CAPÍTULO -->
        <script src="Estilos/JS/owlcarousel.js"></script>
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
                                    Inicio
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
        <% if (capitulo != null) { %>
        <section class="mt-1" style="background-color: #1E1E1E; color: white;">
            <p class="h4 text-center pt-5"><%= capitulo.getNombre()%></p>
            <p class="text-center pt-1"><%= capitulo.getDescripcion()%></p>
            <% if (imgs.length != 0) { %>
            <div class="owl-carousel owl-theme text-center mt-4 pb-3 d-flex flex-column">
                <% for (int i = 0; i < imgs.length; i++) {%>
                <div class="p-2 p-xl-5">
                    <img class="d-block d-sm-none" 
                        src="Estilos/Imagenes/<%= imgs[i].getImagen()%>" 
                        style="margin: 0 auto; width: 350px">
                    <img class="d-none d-sm-block d-md-none" 
                        src="Estilos/Imagenes/<%= imgs[i].getImagen()%>" 
                        style="margin: 0 auto; width: 450px">
                    <img class="d-none d-md-block d-lg-none" 
                        src="Estilos/Imagenes/<%= imgs[i].getImagen()%>" 
                        style="margin: 0 auto; width: 550px">
                    <img class="d-none d-lg-block d-xl-none" 
                        src="Estilos/Imagenes/<%= imgs[i].getImagen()%>" 
                        style="margin: 0 auto; width: 650px">
                    <img class="d-none d-xl-block" 
                        src="Estilos/Imagenes/<%= imgs[i].getImagen()%>" 
                        style="margin: 0 auto; width: 750px">
                </div>
                <% } %>
            </div>
            <% } %>
        </section>
                        
        <section class="mt-1" style="background-color: #1E1E1E; color: white;">
            <div class="col-12 pt-3 pb-3" style="background-color: red">
                <form id="formulario" class="pt-3" action="AddComentario.htm" method="post">
                    <div class="d-flex pl-2 pr-2 col-xl-6 offset-xl-3 
                        col-lg-6 offset-lg-3 col-md-8 offset-md-2 col-sm-8 
                        offset-sm-2 col-10 offset-1">
                        <input id="usuario" type="hidden" 
                               name="usuario" value="<%= us.getDni() %>">
                        <input id="idcapitulo" type="hidden" name="idcapitulo" value="<%= capitulo.getId()%>">
                        <div class="input-group mb-3">
                            <input id="comentario" name="comentario" type="text" 
                                class="form-control rounded-0" 
                                aria-label="Default" required placeholder="Publica un comentario"
                                aria-describedby="inputGroup-sizing-default">
                        </div>
                        <i id="submit" class="comentario fa fa-play-circle" 
                           style="font-size: 40px;"></i>
                    </div>
                </form>
            </div>
            
            <% if (comentarios.length != 0) { %>
            <div class="col-12 text-center mt-4 pb-3 d-flex flex-column">
                <% for (int i = 0; i < comentarios.length; i++) { %>
                <div class="d-flex pl-2 pr-2 col-xl-6 offset-xl-3 
                    col-lg-6 offset-lg-3 col-md-8 offset-md-2 col-sm-8 
                    offset-sm-2 col-10 offset-1 mb-2" style="background-color: #292929">
                    <div>
                        <img class="d-block pt-2 pb-2 rounded-circle" 
                            src="<%= comentarios[i].getFoto() %>" 
                            width="80px" style="margin: 0 auto">
                    </div>
                    <div class=" pt-2">
                        <p class="text-left pl-3" style="font-size: 16px; color: red; font-weight: bold">
                            <%= comentarios[i].getUsuario() %>
                        </p>
                        <p class="pl-5">
                            <%= comentarios[i].getComentario() %>
                        </p>
                    </div>
                </div>
                <% } %>
                <div id="comentarios"></div>
            </div>
            <% } else { %>
            <div id="nocomentarios" class="pl-2 pr-2 col-xl-6 offset-xl-3 
                col-lg-6 offset-lg-3 col-md-8 offset-md-2 col-sm-8 
                offset-sm-2 col-10 offset-1 mt-2 mb-2" style="background-color: #292929">
                <p class="h5 text-center pt-5 pb-5">Aún no hay comentarios</p>
            </div>
            <div id="comentarios"></div>
                <% } %>
        </section>
        <% } else { %>
        <div class="pt-5 pb-5">
            <p class="h4 text-center pt-5 pb-5" style="color:#D7D7D7">
                Aún no hay capítulos disponibles
            </p>
        </div>
        <% } %>
        
        <section style="background-color: black; color: white;">
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
