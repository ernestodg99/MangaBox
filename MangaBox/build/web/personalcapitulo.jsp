<%-- 
    Document   : personalcapitulo
    Created on : 10-abr-2020, 12:18:59
    Author     : ernesto
--%>

<%@page import="modelo.entidades.Serie"%>
<%@page import="modelo.entidades.Imagen"%>
<%@page import="modelo.entidades.Capitulo"%>
<%@page import="modelo.entidades.Personal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Personal personal = (Personal)session.getAttribute("personal"); %>
<% Serie serie = (Serie)session.getAttribute("seriepersonal"); %>
<% Capitulo capitulo = (Capitulo)session.getAttribute("cap"); %>
<% Imagen[] imgs = (Imagen[])session.getAttribute("imagenes"); %>
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
        
        <!-- SCRIPT PARA GESTIONAR LA PUBLICACIÓN/DESPUBLICACIÓN DE LOS CAPÍTULOS POR AJAX -->
        <script src="Estilos/JS/publicacioncapitulos.js"></script>
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
                                <div class="foco p-0 dropdown-menu dropdown-menu-right" 
                                     aria-labelledby="dropdownMenuButton" style="color: #D7D7D7; 
                                     background-color: #1E1E1E">
                                    <a class="dropdown-item" 
                                       style="color: #D7D7D7; background-color: #1E1E1E"
                                       href="#">
                                        Perfil
                                    </a>
                                    <form action="CerrarSesionPersonal.htm" method="post" 
                                          style="background-color: #1E1E1E" 
                                          class="foco dropdown-item form-inline my-2 my-lg-0">
                                        <input type="submit" class="btn p-0" 
                                        style="color: #D7D7D7;"
                                        value="Cerrar sesión">
                                    </form> 
                                </div>
                            </div>  
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
                                
        <script>
            document.getElementById("modalerror").style.display = "none";   
        </script>
        
        <% if (request.getAttribute("error") != null) { %>
        <section class="mt-1">
            <div id="modalerror" class="text-center p-2" style="background-color: #1E1E1E; color: red">
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
                                
        <section class="mt-1" style="background-color: #1E1E1E; color: white;">
            <p class="h4 text-center pt-5"><%= capitulo.getNombre()%></p>
            <p class="text-center pt-1"><%= capitulo.getDescripcion()%></p>
            <form action="BorrarCapitulo.htm" method="post">
                <input type="hidden" name="idcapitulo" value="<%= capitulo.getId() %>">
                <div class="foco manga3 text-center pt-2 pb-2 mb-3 pb-sm-0">
                    <input type="submit" 
                        class="btn col-xl-2 col-md-2 col-3 rounded-0" 
                        value="BORRAR">
                </div>        
            </form>
            
            <div id="divfotos" class="col-xl-8 offset-xl-2 col-lg-10 offset-lg-1 
                 col-md-10 offset-md-1 col-sm-10 offset-sm-1 col-12">
            <form action="UploadStream2.htm" method="POST" enctype="multipart/form-data" 
                class="col-xl-6 offset-xl-3 col-lg-6 offset-lg-3 
                col-md-8 offset-md-2 col-sm-10 offset-sm-1 col-12 pt-4">
                <input type="hidden" name="idcapitulo" 
                    value="<%= capitulo.getId() %>">
                <div class="input-group mb-3">
                    <div class="custom-file">
                        <input type="file" name="fichero" class="custom-file-input" 
                            id="imagen" aria-describedby="imagenfa">
                        <label class="custom-file-label rounded-0"
                            for="imagen">
                            Elegir Imagen
                        </label>
                    </div>
                </div>
                <div class="foco manga2 text-center mt-4">
                    <input type="submit" class="btn col-xl-6 col-lg-6
                        col-md-6 col-sm-6 col-6 rounded-0 mb-3" value="SUBIR IMÁGEN">
                </div>
            </form>
            </div> 
            <% if (imgs.length == 0) { %>
            <hr class="ml-5 mr-5" style="background-color: #D7D7D7">
            <p class="h4 text-center pt-5 pb-5" style="color:white">Aún no hay imágenes</p>
            <% } else { %>
            <div class="text-center mt-4 pb-5 d-flex flex-column">
                <% for (int i = 0; i < imgs.length; i++) {%>
                    <img class="mb-1 d-block d-sm-none" 
                        src="Estilos/Imagenes/<%= imgs[i].getImagen()%>" 
                        width="350px" style="margin: 0 auto">
                    <img class="mb-1 d-none d-sm-block d-md-none" 
                        src="Estilos/Imagenes/<%= imgs[i].getImagen()%>" 
                        width="450px" style="margin: 0 auto">
                    <img class="mb-1 d-none d-md-block d-lg-none" 
                        src="Estilos/Imagenes/<%= imgs[i].getImagen()%>" 
                        width="550px" style="margin: 0 auto">
                    <img class="mb-1 d-none d-lg-block d-xl-none" 
                        src="Estilos/Imagenes/<%= imgs[i].getImagen()%>" 
                        width="650px" style="margin: 0 auto">
                    <img class="mb-1 d-none d-xl-block" 
                        src="Estilos/Imagenes/<%= imgs[i].getImagen()%>" 
                        width="750px" style="margin: 0 auto">
                <% } %>
            </div>
            <% } %>
            <% if (serie.isVisible() == true && (imgs.length != 0)) { %> 
            <input id='idcap' name="cap" type="hidden" value="<%= capitulo.getId() %>">
            <div class="foco manga2 text-center mb-4">
                <input id="visible" type="submit" 
                            class="btn col-4 col-sm-4 col-md-2 col-lg-2 col-xl-2 rounded-0" 
                            value="Publicar"> 
                <input id="novisible" type="submit" 
                            class="btn col-6 col-sm-4 col-lg-3 col-xl-2 rounded-0" 
                            value="Deshacer publicación"> 
            </div> 
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
            //Si el capítulo está publicado, hacemos visible el botón de 
            //deshacer publicación y ocultamos el formulario de subir imágenes
            //y sino hacemos lo mismo al contrario.
            $(document).ready(function() {
                <% if (capitulo.isVisible() != false) { %>
                    $('#visible').hide();
                    $('#divfotos').hide();
                    $('#novisible').show();            
                <% } else { %>
                    $('#visible').show();
                    $('#divfotos').show();
                    $('#novisible').hide();
                <% } %>
            });
        </script>
    </body>
</html>
