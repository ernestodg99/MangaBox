<%-- 
    Document   : admincapitulo
    Created on : 14-abr-2020, 12:31:14
    Author     : ernesto
--%>

<%@page import="modelo.entidades.Personal"%>
<%@page import="modelo.entidades.Capitulo"%>
<%@page import="modelo.entidades.Imagen"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Personal admin = (Personal)session.getAttribute("admin"); %>
<% Capitulo capitulo = (Capitulo)session.getAttribute("cap"); %>
<% Imagen[] imgs = (Imagen[])session.getAttribute("imagenes"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no"/>
        <link rel="stylesheet" href="Estilos/CSS/font.css">
        
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
        
        <!-- SCRIPT PARA LA VISUALIZACIÓN DEL CAPÍTULO -->
        <script src="Estilos/JS/owlcarousel.js"></script>
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
            <p class="h4 text-center pt-5"><%= capitulo.getNombre()%></p>
            <p class="text-center pt-1"><%= capitulo.getDescripcion()%></p>
            
            <% if (imgs.length == 0) { %>
            <p class="h4 text-center" style="color:white">Aún no hay imágenes</p>
            <% } else { %>
            <div class="owl-carousel owl-theme 
                 text-center mt-4 pb-3 d-flex flex-column">
                <% for (int i = 0; i < imgs.length; i++) { %>
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

