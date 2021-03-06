<%-- 
    Document   : favoritos.jsp
    Created on : 24-abr-2020, 17:12:07
    Author     : ernesto
--%>

<%@page import="modelo.entidades.Serie"%>
<%@page import="modelo.entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Usuario us = (Usuario) session.getAttribute("usuario"); %>
<% Serie[] series = (Serie[]) session.getAttribute("mangas3"); %>
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
                                    Favoritos <span class="sr-only">(current)</span>
                                </p> 
                            </form>
                        </li>
                        <li class="nav-item">
                            <div class="dropdown">
                                <button class="btn btn-secondary dropdown-toggle foco" 
                                        type="button" id="dropdownMenuButton" 
                                        data-toggle="dropdown" aria-haspopup="true" 
                                        aria-expanded="false" style="background-color: black; border: black">
                                    <img class="foco" src="<%= us.getFoto()%>" style="width: 40px">
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
            <% if (series.length != 0) { %>
            <% int contador = 0; %>
            <% int contador2 = 0; %>
            <div class="d-flex justify-content-around flex-row flex-wrap
                 pt-sm-0 pb-4">
                <% for (int i = 0; i < series.length; i++) {%>
                <div class="serie p-0 p-sm-0 mt-4 ml-sm-5 mr-sm-5" max-width="240px">
                    <form action="VerManga.htm" method="post" id="formulario<%= contador%>" class="serie2"
                          onclick="document.querySelector('#formulario<%= contador%>').submit()">
                        <% if (series[i].getLogo2() == null) {%>
                        <h4 class="text-center pt-5 pb-5" style="color: #D7D7D7">
                            <%= series[i].getNombre()%>
                        </h4>
                        <input type="hidden" name="nombre" 
                               value="<%= series[i].getNombre()%>">
                        <br>
                        <br>
                        <br>
                        <br>
                        <% } else {%>
                        <img class="d-block"
                             src="Estilos/Imagenes/<%= series[i].getLogo2()%>" 
                             width="225px" height="300px">
                        <div class="text-center">
                            <p class="pt-1" id="enviar" role="button" aria-label="submit form" 
                               href="javascript:void(0)" 
                               onclick="document.querySelector('#formulario<%= contador%>').submit()">
                                <%= series[i].getNombre()%>
                            </p>
                            <input type="hidden" name="nombre" 
                                   value="<%= series[i].getNombre()%>">
                        </div>
                        <% }%>
                    </form>
                    <hr class="m-1 mb-sm-3" style="background-color: #D7D7D7">
                    <form action="VerUltimoCapitulo.htm" method="post" class="serie3" id="fomulario2<%= contador2%>">
                        <p class="pt-2 text-center" style="font-size: 12px">
                            Lea el capítulo más reciente
                        </p>
                        <input type="hidden" name="serie" value="<%= series[i].getNombre()%>">
                        <div class="manga2 text-center">
                            <input type="submit" 
                                   class="mb-3 mb-sm-0 foco btn col-8 rounded-0" 
                                   style="font-size: 12px" value="VER">
                        </div>
                    </form>
                </div>
                <% contador++; %>
                <% contador2++; %>
                <% } %>
            </div>
            <% } else { %>
            <div class="pt-5 pb-5">
                <p class="h2 pt-5 pb-3 text-center">Aún no tienes series favoritas</p>
                <p class="h5 p-4 pt-3 pb-5 text-center">
                    Para tener series favoritas ve a 
                    <b onclick="document.querySelector('#formmanga').submit()"
                       style="text-decoration: underline; cursor: pointer">
                        Mangas</b>, elige una serie y pulsa en el icono: 
                    <i class="fa fa-star-o" aria-hidden="true"
                       style="color:yellow"></i>
                </p>
            </div>
            <% }%>
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
    </body>
</html>
