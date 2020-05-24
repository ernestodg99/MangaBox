<%-- 
    Document   : personalserie
    Created on : 30-mar-2020, 16:39:38
    Author     : ernesto
--%>

<%@page import="modelo.entidades.Capitulo"%>
<%@page import="modelo.entidades.Personal"%>
<%@page import="modelo.entidades.Serie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Personal personal = (Personal)session.getAttribute("personal"); %>
<% Serie serie = (Serie)session.getAttribute("seriepersonal"); %>
<% Capitulo[] caps = (Capitulo[])session.getAttribute("capitulos"); %>
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
                    <h1 class="text-center pt-2 d-sm-block d-none" 
                        style="color: #D7D7D7">
                        <%= serie.getNombre().toUpperCase() %>
                    </h1>
                    <p class="text-center d-sm-block d-none"><%= serie.getAutor()%></p>
                    <div class="d-block d-sm-none text-center" style="overflow: hidden">
                        <img src="Estilos/Imagenes/<%= serie.getLogo()%>" width="350px">
                    </div>
                    <h5 class="text-center pt-2 d-block d-sm-none" 
                        style="color: #D7D7D7">
                        <%= serie.getNombre().toUpperCase() %>
                    </h5>
                    <p class="text-center d-block d-sm-none"><%= serie.getAutor()%></p>
                    <% } %>
                </div>
                <div class="mt-sm-3 col-lg-4">
                    <% if (serie.getDescripcion() == null) { %>
                    <p class="mt-4">Sin descripción</p>
                    <hr style="background-color: #D7D7D7">
                    <% } else { %>
                    <p class="mt-4"><%= serie.getDescripcion()%></p>
                    <% } %>
                    <% if (serie.getFechaSerializacion() == null) { %>
                    <p>Sin fecha de serialización</p>
                    <% } else { %>
                    <p>Desde <%= serie.getFechaSerializacion()%></p>
                    <% } %>
                </div>
            </div>
        </section>  
                
        <section class="mt-1" style="background-color: #1E1E1E; color: white;">
            <div class="d-flex flex-column">
                <div class="col-sm-10 offset-sm-1 col-md-6 offset-md-3
                     col-lg-6 offset-lg-3 col-xl-4 offset-xl-4">
                    <form action="AddCapitulo.htm" method="post">
                        <input type="hidden" name="nombreserie" value="<%= serie.getNombre()%>">
                        <input type="hidden" name="personalserie" value="<%= personal.getDni()%>">
                        <p class="text-center mt-3">Capítulo Nº:</p>
                        <input name="capitulonumero" type="text" class="form-control rounded-0" 
                            aria-label="Default" required 
                            aria-describedby="inputGroup-sizing-default">
                        <p class="text-center mt-3">Nombre:</p>
                        <input name="nombre" type="text" class="form-control rounded-0" 
                            aria-label="Default" required 
                            aria-describedby="inputGroup-sizing-default">
                        <p class="text-center mt-3">Descripción:</p>
                        <textarea name="descripcion" class="form-control" 
                            id="texto" rows="2"></textarea>
                        <div class="foco manga2 text-center mt-4">
                            <input type="submit" 
                            class="btn col-xl-6 col-6 rounded-0 mb-4" 
                            value="AÑADIR CAPÍTULO">
                        </div>
                    </form>
                    <script>
                        document.getElementById("modalerror").style.display = "none";   
                    </script>
        
                    <% if (request.getAttribute("error") != null) { %>
                    <section class="mt-1">
                        <div id="modalerror" class="text-center p-2" 
                             style="border: 1px yellow solid; 
                             background-color: #1E1E1E; color: yellow">
                            <%= request.getAttribute("error")%>
                            <button type="button" onclick="cerrarDiv()" class="close">
                                <span aria-hidden="true" style="color:white">&times;</span>
                            </button>
                        </div>
                    </section>
                    <% } %>
        
                    <script>
                        function cerrarDiv() {
                            document.getElementById("modalerror").style.display = "none";   
                        }
                    </script>
                </div>
            </div>     
        </section>
                        
        <section class="mt-1" style="background-color: #1E1E1E; color: white;">
            <% if (caps != null) { %>
            <div class="d-flex flex-column flex-wrap justify-content-around p-5">
                <% for(int i = 0; i < caps.length; i++) { %>
                <div class="capitulo col-xl-6 offset-xl-3 col-lg-8 offset-lg-2 
                    col-10 offset-1 col-sm-10 offset-sm-1 col-md-8 offset-md-2
                    mb-4">
                    <form action="VerCapituloPersonal.htm" method="post">
                        <div class="d-flex flex-sm-row flex-column justify-content-between p-2">
                            <p class="text-center text-sm-left pt-1 pt-sm-3">
                                Capítulo <%= caps[i].getCapituloNumero()%>
                            </p>
                            <p class="text-center text-sm-left pt-1 pt-sm-3">
                                <%= caps[i].getNombre()%>
                            </p>
                            <input type="hidden" name="idcapitulo" value="<%= caps[i].getId()%>">
                            <input type="hidden" name="nombreserie" value="<%= serie.getNombre()%>">
                            <div class="foco manga2 text-center pt-2 pb-2 pb-sm-0">
                                <input type="submit" 
                                    class="btn col-xl-12 col-4 col-sm-12 rounded-0" 
                                    value="VER">
                            </div>
                        </div>
                    </form>
                </div>
                <% } %>
            </div>
            <% } else { %>
                <p class="text-center">Sin capítulos aún</p>
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
    </body>
</html>
