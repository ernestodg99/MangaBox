<%-- 
    Document   : registro.jsp
    Created on : 16-mar-2020, 11:52:38
    Author     : ernesto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no"/>
        
        <!-- ESTILOS -->
        <link rel="stylesheet" href="Estilos/CSS/font.css">
        <link rel="stylesheet" href="Estilos/CSS/estilos.css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
        <title>Manga Box - Inicio</title>
    </head>
    <body style="background-color: black">
        <div class="text-center pt-3">
            <a class="navbar-brand" href="inicio.jsp" style="
             color: red; font-family: fuente;">MANGA BOX</a>
        </div>
        <div class="col-12 col-md-12 pt-5 pb-5 d-md-flex justify-content-md-around" style="background-color: rgba(0,0,0,0.8)">
            <div class="text-center col-10 offset-1 col-sm-8 offset-sm-2 
                 col-md-5 offset-md-0 col-lg-5 col-xl-5" style="border: 1px #292929 solid">
                <div style="background-color: black; color: white">
                    <form action="RegistroUsuarios.htm" method="post">
                        <div style="border-bottom-color: grey">
                            <h5 class="pt-2 text-center" id="exampleModalLabel">
                                Registro
                            </h5>
                        </div>
                        <div>
                            <div class="foco input-group mb-3">
                                <input name="dni" type="text" 
                                       class="form-control rounded-0" 
                                       aria-label="Default" required placeholder="DNI"
                                       aria-describedby="inputGroup-sizing-default">
                            </div>
                            <div class="foco input-group mb-3">
                                <input name="nombre" type="text" 
                                       class="form-control rounded-0" 
                                       aria-label="Default" required placeholder="Nombre" 
                                       aria-describedby="inputGroup-sizing-default">
                            </div>
                            <div class="foco input-group mb-3">
                                <input name="apellidos" type="text" 
                                       class="form-control rounded-0" 
                                       aria-label="Default" required placeholder="Apellidos" 
                                       aria-describedby="inputGroup-sizing-default">
                            </div>
                            <div class="foco input-group mb-3">
                                <input name="email" type="email" 
                                       class="form-control rounded-0" 
                                       aria-label="Default" required placeholder="Email"
                                       aria-describedby="inputGroup-sizing-default">
                            </div>
                            <div class="foco input-group mb-3">
                                <input name="fecha" type="text" onfocus="(this.type='date')" 
                                       class="form-control rounded-0"
                                       aria-label="Default" required placeholder="Fecha"
                                       aria-describedby="inputGroup-sizing-default">
                            </div>
                            <div class="foco input-group mb-3">
                                <input name="usuario" type="text" 
                                       class="form-control rounded-0" 
                                       aria-label="Default" required placeholder="Usuario" 
                                       aria-describedby="inputGroup-sizing-default">
                            </div>
                            <div class="foco input-group mb-4">
                                <input name="password" type="password" 
                                       class="form-control rounded-0" 
                                       aria-label="Default" required placeholder="Contraseña" 
                                       aria-describedby="inputGroup-sizing-default">
                            </div> 
                            <div id="divfoto" class="input-group mb-3">
                                <div style="margin: 0 auto">
                                    <p class="text-center">Seleccione foto de perfil:</p>
                                    <img id="img1" src="Estilos/Imagenes/onepiece.png" style="width: 100px;" 
                                         >
                                    <img id="img2" src="Estilos/Imagenes/naruto.png" style="width: 100px;" 
                                         >
                                    <input id="foto" type="hidden" name="foto" value="">
                                </div>
                            </div> 
                        </div>
                        <div class="foco registro text-center">
                            <input type="submit" class="btn mb-3 
                                   col-6 rounded-0" value="Registrarse">
                            <br>
                        </div>
                    </form>
                </div>
            </div>
            <div class="d-none text-center d-md-flex flex-column 
                 
                 col-md-5 col-lg-5 col-xl-4">
                <h4 class="h5 mt-2 mb-5 text-center" 
                    style="color: white; font-family: fuente">
                    LA MEJOR <br><br> SELECCION
                </h4>
                <div class="d-flex justify-content-around">
                    <p class="text-center">
                        <img class="d-md-none d-lg-block mt-4 mb-4" 
                            src="Estilos/Imagenes/dbs.png" width="350px">
                        <img class="d-md-block d-lg-none mt-4 mb-4" 
                            src="Estilos/Imagenes/dbs.png" width="275px">
                    </p>
                </div>
                <div class="d-flex justify-content-around">
                    <p class="text-center">
                        <img class="d-md-none d-lg-block mb-5" 
                            src="Estilos/Imagenes/op.png" width="350px">
                        <img class="d-md-block d-lg-none mb-5" 
                            src="Estilos/Imagenes/op.png" width="275px">
                    </p>
                </div>
                <div class="d-flex justify-content-around">
                    <img src="Estilos/Imagenes/mha.png" width="175px">
                    <img src="Estilos/Imagenes/n.png" width="175px">
                </div>
            </div>
        </div>
        
        <section class="mt-1" style="background-color: black; color: white; border-top: solid #292929">
            <footer>
                <div class="pt-2 d-flex flex-column flex-md-row justify-content-around">
                    <div class="text-center text-md-left">
                        <a href="#" style="color: white;">Preguntas frecuentes</a><br>
                        <a class="mt-3" href="#" style="color: white;">Política de Privacidad</a><br>
                        <a class="mt-3" href="#" style="color: white;">¿Dónde ver?</a><br>
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
        
        <!-- SCRIPT PARA BORDER DE ICONOS DE PERFIL -->
        <script src="Estilos/JS/imgborderregistro.js"></script>
    </body>
</html>
