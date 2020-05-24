<%-- 
    Document   : administrador
    Created on : 20-mar-2020, 19:13:03
    Author     : ernesto
--%>

<%@page import="modelo.entidades.Serie"%>
<%@page import="modelo.entidades.Personal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Personal admin = (Personal)session.getAttribute("admin"); %>
<% Personal[] pers = (Personal[])session.getAttribute("personalseriecompleto");%>
<% Serie[] series = (Serie[])session.getAttribute("series"); %>
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
                <form action="VerMangasAdmin.htm" method="post" class="d-lg-none d-block">
                    <input type="submit" value="ADMINISTRACION" class="h5 mt-2 p-2"
                           style="color: yellow; font-family: fuente; 
                           background-color: black; border: black; font-size: 15px">
                </form>
                <form action="VerMangasAdmin.htm" method="post" class="d-lg-block d-none">
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
                        <li class="nav-item ml-2 ml-lg-0 mr-lg-5">
                            <form action="adminpersonal.jsp" method="post">
                                <input class="mt-1 p-1" type="submit" value="Personal"
                                       style="background-color: black; color: white; 
                                       border: black 2px solid">
                            </form>
                        </li>
                        <li class="nav-item mt-1">
                            <div class="dropdown">
                                <button class="btn btn-secondary dropdown-toggle foco" 
                                        type="button" id="dropdownMenuButton" 
                                        data-toggle="dropdown" aria-haspopup="true" 
                                        aria-expanded="false" style="background-color: black; border: black">
                                        <%= admin.getNombre() %>
                                </button>
                                <div id="divusuario" class="p-0 dropdown-menu dropdown-menu-right" 
                                     aria-labelledby="dropdownMenuButton" style="color: white; background-color: #1E1E1E">
                                    <form id="formperfil" action="VerPerfilAdmin.htm" method="post">
                                        <p class="pt-4 pt-lg-4 text-center" style="color: white; cursor: pointer;"
                                           onclick="document.querySelector('#formperfil').submit()">
                                            Perfil
                                        </p> 
                                    </form>
                                    <form id="formsesion" action="CerrarSesionAdmin.htm" method="post" style="background-color: #1E1E1E" 
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
            <h4 class="pt-4 pb-4 text-center titulo d-none d-sm-block" 
                style="font-size: 20px; color: white; font-family: fuente;">
                MANGAS DISPONIBLES
            </h4>
            <h5 class="pt-4 pb-4 text-center titulo d-block d-sm-none" 
                style="font-size: 15px; color: white; font-family: fuente;">
                DISPONIBLES
            </h5>
            <div class="d-flex justify-content-around flex-row flex-wrap
                 pt-sm-0 pb-4" max-width="240px">
                <div class="serie4 p-0 p-sm-0 mb-4 mb-sm-0 ml-sm-5 mr-sm-5 mb-sm-5">
                    <form action="AddManga.htm" method="post">
                        <input type="hidden" name="administrador" value="<%= admin.getDni() %>">
                        <div class="p-2">
                            <div class="input-group mt-2 mb-3">
                                <input name="nombre" type="text" class="form-control rounded-0" 
                                    aria-label="Default" required placeholder="Nombre"
                                    aria-describedby="inputGroup-sizing-default">
                            </div>
                            <div class="input-group mb-2">
                                <input name="autor" type="text" class="form-control rounded-0" 
                                    aria-label="Default" required placeholder="Autor"
                                    aria-describedby="inputGroup-sizing-default">
                            </div>
                            <div class="text-center">
                                <span class="rounded-0" 
                                    style="background-color: #1E1E1E; color: #D7D7D7">
                                    Categoria
                                </span>
                            </div>
                            <div class="form-group mb-0">
                                <select class="form-control rounded-0" name="categoria">
                                    <option value="kodomo">Kodomo</option>
                                    <option value="shonen">Shonen</option>
                                    <option value="shojo">Shojo</option>
                                    <option value="seinen">Seinen</option>
                                    <option value="josei">Josei</option>
                                </select>
                            </div>
                            <% if(pers.length != 0) { %>
                            <div class="text-center pt-2">
                                <span class="rounded-0" 
                                    style="background-color: #1E1E1E; color: #D7D7D7">
                                    Elija representante:
                                </span>
                            </div>
                            <div class="form-group text-center mb-0">
                                <select class="form-control rounded-0 mb-0" name="personal">
                            <% for(int i = 0; i < pers.length; i++) { %>
                                    <option value="<%= pers[i].getDni()%>">
                                        <%= pers[i].getDni()%>
                                    </option>
                            <% } %>
                                </select>
                            </div>
                            <% } else { %>
                            <p class="text-center mt-3 mt-lg-3 mb-0">
                                No hay personal
                            </p>
                            <% } %>
                        </div>
                        <% if(pers.length != 0) { %>
                        <hr class="m-1 mb-sm-3" style="background-color: #D7D7D7">
                        <div class="foco manga2 text-center pt-4 pt-sm-2 pb-4">
                            <input type="submit" 
                                class="btn col-8 col-sm-10 rounded-0"
                                style="font-size: 15px"
                                value="AÑADIR MANGA">
                        </div>
                        <% } else { %>
                        <hr class="m-1" style="background-color: #D7D7D7">
                        <br>
                        <br>
                        <div class="foco manga2 text-center pt-2 pb-4">
                            <input type="submit" disabled 
                                class="btn col-8 col-sm-10 rounded-0"
                                style="font-size: 12px"
                                value="AÑADIR MANGA">
                        </div>
                        <% } %>
                    </form>
                </div>
                    
                <% int contador = 0;%>
                <% for(int i = 0; i < series.length; i++) { %>
                <div class="serie4 p-0 p-sm-0 mb-4 mb-sm-0 ml-sm-5 mr-sm-5 mb-sm-5"
                     max-width="240px">
                    <form action="VerMangaAdmin.htm" method="post" id="formulario<%= contador %>" class="serie2"
                          onclick="document.querySelector('#formulario<%= contador %>').submit()">
                    <% if (series[i].getLogo2() == null) { %>
                        <h4 class="text-center pt-5 pb-5 pl-5 pr-5"
                            style="color: #D7D7D7">
                            <%= series[i].getNombre()%>
                        </h4>
                        <input type="hidden" name="nombre" 
                            value="<%= series[i].getNombre()%>">
                        <br>
                        <br>
                        <br>
                        <br>
                    <% } else { %>
                        <img class="d-block"
                            src="Estilos/Imagenes/<%= series[i].getLogo2()%>" 
                            width="225px" height="300px">
                        <div class="text-center">
                            <p class="pt-1" id="enviar" role="button" aria-label="submit form" 
                                href="javascript:void(0)" 
                                onclick="document.querySelector('#formulario<%= contador %>').submit()">
                                <%= series[i].getNombre()%>
                            </p>
                            <input type="hidden" name="nombre" 
                                value="<%= series[i].getNombre()%>">
                        </div>
                    <% } %>
                    </form>
                </div>
                <% contador++; %>
                <% } %> 
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
