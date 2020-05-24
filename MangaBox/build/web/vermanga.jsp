<%-- 
    Document   : vermanga
    Created on : 20-abr-2020, 12:00:10
    Author     : ernesto
--%>

<%@page import="modelo.entidades.Favorito"%>
<%@page import="modelo.entidades.Capitulo"%>
<%@page import="modelo.entidades.Serie"%>
<%@page import="modelo.entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Usuario us = (Usuario)session.getAttribute("usuario"); %>
<% Serie serie = (Serie)session.getAttribute("usuarioserie"); %>
<% Capitulo[] caps = (Capitulo[])session.getAttribute("usuariocapitulos"); %>
<% Favorito fav = (Favorito)session.getAttribute("favorito"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no"/>
        <link rel="stylesheet" href="Estilos/CSS/font.css">
        <link rel="stylesheet" href="Estilos/CSS/estilos.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
        <!-- SCRIPT PARA FUNCIONALIDAD DE FAVORITOS (ESTRELLITA) -->
        <script src="Estilos/JS/favoritos.js"></script>
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
                                
        <section style="background-color: #1E1E1E; color: white;">
            <div class="d-flex justify-content-around flex-column flex-lg-row flex-nowrap
                 p-3 pt-sm-0 pt-3 pb-4">
                <div class="d-flex flex-column mt-5">
                    <% if (serie.getLogo() == null) { %>
                    <h4 class="text-center pt-5 pb-5 d-sm-block d-none" 
                        style="font-family: fuente; color: yellow">
                        <%= serie.getNombre().toUpperCase() %>
                    </h4>
                    <h5 class="text-center pt-5 pb-5 d-block d-sm-none" 
                        style="font-family: fuente; color: yellow">
                        <%= serie.getNombre().toUpperCase() %>
                    </h5>
                    <% } else { %>
                    <div class="d-sm-block d-none text-center" style="overflow: hidden">
                        <img class="text-center" 
                             src="Estilos/Imagenes/<%= serie.getLogo()%>" width="600px">
                    </div>
                    <form>
                        <input id="usuario" type="hidden" 
                               name="usuario" value="<%= us.getDni() %>">
                        <input id="serie" type="hidden" 
                               name="serie" value="<%= serie.getNombre() %>">
                        <h1 class="text-center pt-2 d-sm-block d-none" 
                            style="color: #D7D7D7">
                            <%= serie.getNombre().toUpperCase() %>
                            <i id="nofavorito" class="fa fa-star" aria-hidden="true"></i>
                            <i id="favorito" class="fa fa-star-o" aria-hidden="true"></i>
                        </h1>
                    </form>
                    <p class="text-center d-sm-block d-none"><%= serie.getAutor()%></p>
                    <div class="d-block d-sm-none text-center" style="overflow: hidden">
                        <img src="Estilos/Imagenes/<%= serie.getLogo()%>" width="350px">
                    </div>
                    <h4 class="text-center pt-2 d-block d-sm-none" 
                        style="color: #D7D7D7">
                        <%= serie.getNombre().toUpperCase() %>
                        <i id="nofavorito2" class="fa fa-star" aria-hidden="true"></i>
                        <i id="favorito2" class="fa fa-star-o" aria-hidden="true"></i>
                    </h4>
                    <p class="text-center d-block d-sm-none"><%= serie.getAutor()%></p>
                    <% } %>
                </div>
                <div class="mt-sm-3 col-lg-4">
                    <% if (serie.getDescripcion() != null) { %>
                    <p class="mt-4"><%= serie.getDescripcion()%></p>
                    <% } %>
                    <% if (serie.getFechaSerializacion() != null) { %>
                    <p>Desde <%= serie.getFechaSerializacion()%></p>
                    <% } %>
                </div>
            </div>
        </section>  
                
        <section style="color: white;">
            <hr class="ml-5 mr-5" style="background-color: white">
            <% if (caps.length != 0) { %>
            <div class="d-flex flex-column flex-wrap justify-content-around p-5">
                <% for(int i = 0; i < caps.length; i++) { %>
                <div class="capitulo col-xl-6 offset-xl-3 col-lg-8 offset-lg-2 
                    col-10 offset-1 col-sm-10 offset-sm-1 col-md-8 offset-md-2
                    mb-4">
                    <form action="VerCapitulo.htm" method="post">
                        <div class="d-flex flex-sm-row flex-column justify-content-between p-2">
                            <p class="text-center text-sm-left pt-1 pt-sm-3">
                                Capítulo <%= caps[i].getCapituloNumero()%>
                            </p>
                            <p class="text-center text-sm-left pt-1 pt-sm-3">
                                <%= caps[i].getNombre()%>
                            </p>
                            <input type="hidden" name="idcapitulo" value="<%= caps[i].getId()%>">
                            <input type="hidden" name="nombreserie" value="<%= serie.getNombre()%>">
                            <div class="manga2 text-center pt-2 pb-2 pb-sm-0">
                                <input type="submit" 
                                    class="foco btn col-xl-12 col-4 col-sm-12 rounded-0" 
                                    value="VER">
                            </div>
                        </div>
                    </form>
                </div>
                <% } %>
            </div>
            <% } else { %>
            <p class="text-center h5 pt-5 pb-5" style="color: #D7D7D7">Sin capítulos aún</p>
            <% } %>
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
        
        <script>
            $(document).ready(function() {
                //Si tengo la serie de favorita muestro la estrella coloreada
                //Y si no muestro la estrella vacía
                <% if (fav != null) { %>
                    $('#favorito').hide();
                    $('#nofavorito').show();            
                <% } else { %>
                    $('#favorito').show();
                    $('#nofavorito').hide();
                <% } %>
                
                //Aquí se hace lo mismo que arriba sólo que cuando el texto es 
                //más pequeño debido al tamaño de pantalla
                //Si tengo la serie de favorita muestro la estrella coloreada
                //Y si no muestro la estrella vacía
                <% if (fav != null) { %>
                    $('#favorito2').hide();
                    $('#nofavorito2').show();            
                <% } else { %>
                    $('#favorito2').show();
                    $('#nofavorito2').hide();
                <% } %>
            });
        </script>
    </body>
</html>
