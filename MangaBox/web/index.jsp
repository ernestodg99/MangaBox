<%-- 
    Document   : inicio.jsp
    Created on : 09-mar-2020, 8:52:22
    Author     : ernesto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no"/>
        <link rel="stylesheet" href="Estilos/CSS/font.css">
        <link rel="stylesheet" href="Estilos/CSS/estilos.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>Manga Box - Inicio</title>
    </head>
    <body style="background-color: #292929">
        <nav class="navbar navbar-expand-lg navbar-light pt-4 pb-4 d-flex 
             justify-content-between foco2" style="background-color: black">
            <a class="d-lg-block d-none navbar-brand titulo" href="inicio.jsp" style="
                color: red; font-family: fuente;">MANGA BOX</a>
            <a class="d-lg-none d-block" href="inicio.jsp" style="
                color: red; font-family: fuente; font-size: 15px">MANGA BOX</a>
            <a id="boton1" class="btn mr-2 rounded-0" data-toggle="modal" 
               data-target="#modalLogin" style="color: white" 
               >Iniciar sesión</a>
        </nav>
        
        <div class="modal fade pt-5" id="modalLogin" tabindex="-1" role="dialog" 
             aria-labelledby="exampleModalLabel" aria-hidden="true" 
             style="background-color: rgba(0,0,0,0.8)">
            <div class="modal-dialog" role="document" style="border: 2px #292929 solid">
                <div class="modal-content" style="background-color: black; color: white">
                    <form action="IniciarSesion.htm" method="post">
                        <div class="modal-header" style="border-bottom-color: grey">
                            <h5 class="modal-title text-center" id="exampleModalLabel">
                                Iniciar sesión
                            </h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true" style="color:white">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text rounded-0" id="basic-addon1" 
                                          style="background-color: red">
                                        <i class="fa fa-user" aria-hidden="true" 
                                           style="color: white"></i>
                                    </span>
                                </div>
                                <input name="usuario" type="text" class="form-control rounded-0" 
                                       aria-label="Default" required 
                                       aria-describedby="inputGroup-sizing-default">
                            </div>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text rounded-0" id="basic-addon1" 
                                          style="background-color: red">
                                        <i class="fa fa-lock" aria-hidden="true" 
                                           style="color: white"></i>
                                    </span>
                                </div>
                                <input name="password" type="password" class="form-control rounded-0" 
                                       aria-label="Default" required 
                                       aria-describedby="inputGroup-sizing-default">
                            </div>     
                        </div>
                        <div class="modal-footer" style="border-top-color: grey">
                        </div>
                        <div class="foco foco2 text-center pb-2">
                            <input id="boton3" type="submit" class="btn mb-4 col-6 rounded-0" 
                                   value="Iniciar sesión">
                            <br>
                            <a href="registro.jsp" style="color: red">
                                ¿No tienes una cuenta? <b>Regístrate</b>
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        <script>
            document.getElementById("modalerror").style.display = "none";   
        </script>
        
        <% if (request.getAttribute("error") != null) { %>
        <section class="mt-1">
            <div id="modalerror" class="text-center p-2" style="background-color: black; color: red">
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
        
        <section class="mt-1" style="background-color: black; color: white; font-size: 22px">
            <div class="" style="height: 140px; background: url(Estilos/Imagenes/fondo.png);">
            </div>
        </section>
        
        <section class="mt-1" style="background-color: black; color: white; font-size: 22px">
            <div class="text-center pb-5">
                <h5 class="pt-5 d-none d-md-block" style="font-family: fuente">BIENVENIDO A MANGA BOX</h5>
                <br>
                <div class="d-flex flex-column flex-md-row">
                    <div class="d-block d-md-none d-lg-block col-xl-6 text-md-left text-center">
                        <span class="offset-md-1 offset-xl-2">
                            <i class="fa fa-check" aria-hidden="true" style="color: red"></i>
                            Plataforma totalmente gratuita
                        </span>
                        <br>
                        <span class="offset-md-1 offset-xl-2">
                            <i class="fa fa-check" aria-hidden="true" style="color: red"></i>
                            Tus mangas favoritos
                        </span>
                        <br>
                        <span class="offset-md-1 offset-xl-2 d-block d-md-none d-xl-block">
                            <i class="fa fa-check" aria-hidden="true" style="color: red"></i>
                            Disponible en multitud de dispositivos
                        </span>
                        <span class="offset-md-1 offset-xl-2 d-none d-md-block d-xl-none">
                            <i class="fa fa-check" aria-hidden="true" style="color: red"></i>
                            En multitud de dispositivos
                        </span>
                    </div>
                    <div class="d-none d-md-block d-lg-none col-md-6 text-md-left text-center">
                        <span class="offset-md-1" style="font-size: 20px">
                            <i class="fa fa-check" aria-hidden="true" style="color: red"></i>
                            Plataforma totalmente gratuita
                        </span>
                        <br>
                        <span class="offset-md-1" style="font-size: 20px">
                            <i class="fa fa-check" aria-hidden="true" style="color: red"></i>
                            Tus mangas favoritos
                        </span>
                        <br>
                        <span class="offset-md-1 d-none d-md-block d-xl-none"
                              style="font-size: 20px">
                            <i class="fa fa-check" aria-hidden="true" style="color: red"></i>
                            En multitud de dispositivos
                        </span>
                    </div>
                    <div class="foco foco2 col-xl-6">
                        <a id="boton2" class="btn col-8 col-sm-6 col-lg-6 
                           col-md-6 col-xl-6 offset-xl-2 mt-4 rounded-0" 
                           href="registro.jsp">Pruébanos</a>
                    </div>
                </div>
            </div>
        </section>
        
        <section class="mt-1" style="background-color: black; color: white">
            <div class="d-flex flex-column flex-xl-row justify-content-around col-xl-12">
                <div class="col-xl-7 pt-5">
                    <h5 class="text-xl-center col-xl-12 pt-4 d-none d-xl-block" 
                        style="font-family: fuente">
                        MANGA BOX EN TUS DISPOSITIVOS
                    </h5>
                    <p class="text-center d-block d-xl-none" 
                       style="font-family: fuente">
                        DONDE QUIERAS
                    </p>
                    <br>
                    <div class="pt-xl-3 pl-xl-0 text-center text-xl-left">
                        <span class="h5 col-12 offset-xl-1">
                            <i class="fa fa-television" aria-hidden="true" 
                               style="color: red; font-size: 25px"></i>
                            Disfruta de Manga Box en cualquier dispositivo.
                        </span>
                        <br>
                        <span class="h5 col-12 offset-xl-1">
                            <i class="fa fa-tablet" aria-hidden="true" 
                               style="color: red; font-size: 25px"></i>
                            Desde TV, pasando por consolas, hasta SmartPhones...
                        </span>
                        <br>
                        <span class="h5 col-12 offset-xl-1">
                            <i class="fa fa-mobile" aria-hidden="true" 
                               style="color: red; font-size: 25px"></i>
                            ¡No te pierdas nada, únete ya!
                        </span>
                    </div>
                </div>
                <div class="d-none d-xl-block text-xl-center pt-4 pb-4 col-xl-5 col-12">
                    <img class="d-none d-xl-block col-xl-12" src="Estilos/Imagenes/manga.png">
                </div>
                <div class="d-block d-xl-none text-center pt-4 pb-5">
                    <img class="d-none d-lg-block d-xl-none col-lg-6 offset-lg-3" 
                         src="Estilos/Imagenes/manga.png">
                    <img class="d-none d-md-block d-lg-none col-md-6 offset-md-3" 
                         src="Estilos/Imagenes/manga.png">
                    <img class="d-none d-sm-block d-md-none col-sm-8 offset-sm-2" 
                         src="Estilos/Imagenes/manga.png">
                    <img class="d-none d-block d-sm-none col-10 offset-1" 
                         src="Estilos/Imagenes/manga.png">
                </div>
            </div>
        </section>
        
        <section class="mt-1" style="background-color: black; color: white">
            <div class="pt-5 pb-5">
                <h5 class="text-xl-center col-xl-12 pt-4 d-none d-xl-block pb-3" 
                    style="font-family: fuente; font-size: 16px">
                    CONTENIDO ORGANIZADO EN CATEGORIAS
                </h5>
                <p class="text-center d-block d-xl-none pt-4 pb-3" 
                    style="font-family: fuente">
                    DIFERENTES CATEGORIAS
                </p>
                <div class="text-center pb-3">
                    <span>
                        <b style="color: skyblue">
                            Kodomo
                        </b> manga, dirigido a niños pequeños.</span><br>
                    <span>
                        <b style="color: blue">
                            Shōnen
                        </b> manga, dirigido a chicos adolescentes.</span><br>
                    <span>
                        <b style="color: violet">
                            Shōjo
                        </b> manga, dirigido a chicas adolescentes.</span><br>
                    <span>
                        <b style="color: purple">
                            Seinen
                        </b> manga, dirigido a hombres jóvenes y adultos.</span><br>
                    <span>
                        <b style="color: #ff00f2">
                            Josei
                        </b> manga, dirigido a mujeres jóvenes y adultas.</span>
                </div>
            </div>
        </section>
        
        <section class="mt-1" style="background-color: black; color: white;">
            <div>
                <p class="pt-3 pb-3 pl-3 titulo text-light text-center" 
                   style="font-family: fuente">
                    ENCUENTRANOS EN 
                    <a href="https://facebook.com" class="text-body mr-1">
                        <i class="text-light fa fa-facebook titulo" 
                           style="font-size: 25px; color: red"></i>
                    </a>
                    <a href="https://instagram.com" class="text-body mr-1">
                        <i class="text-light fa fa-instagram titulo" 
                           style="font-size: 25px; color: red"></i>
                    </a>
                    <a href="https://twitter.com" class="text-body mr-1">
                        <i class="text-light fa fa-twitter titulo" 
                           style="font-size: 25px; color: red"></i>
                    </a>
                </p>
            </div>
            <footer>
                <div class="d-flex flex-column flex-md-row justify-content-around">
                    <div class="text-center text-md-left">
                        <a href="#" style="color: white;">Preguntas frecuentes</a><br>
                        <a class="mt-3" href="#" style="color: white;">Política de Privacidad</a><br>
                        <a class="mt-3" href="#" style="color: white;">Contacta con nosotros</a><br>
                        <a class="mt-3" href="personal.jsp" style="color: white;">Personal</a><br>
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
