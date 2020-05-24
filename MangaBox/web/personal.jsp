<%-- 
    Document   : personal.jsp
    Created on : 20-mar-2020, 18:08:22
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
        <title>Manga Box - Personal</title>
    </head>
    <body style="background-color: black">
        <div class="text-center pt-3 mb-3">
            <a class="navbar-brand" href="inicio.jsp" style="
             color: red; font-family: fuente;">MANGA BOX</a>
        </div>
        <div class="p-1 pt-5 pb-5" style="background-color: rgba(0,0,0,0.8)">
            <p class="h3 mt-2 mb-2 text-center" style="color:white">
                Inicio de sesión
            </p>
            <p class="mb-5 text-center" style="color:white">
                Este inicio de sesión sólo está habilitado para personales.
            <p>
            <div class="text-center col-10 offset-1 col-sm-8 offset-sm-2 
                 col-md-6 offset-md-3 col-lg-4 offset-lg-4 col-xl-4 offset-xl-4 
                 mb-4 mt-5" 
                 style="border: 1px #292929 solid">
                <div style="background-color: black; color: white">
                    <form action="IniciarSesionPersonal.htm" method="post">
                        <div style="border-bottom-color: grey">
                            <h5 class="pt-2 text-center">
                                Personal
                            </h5>
                        </div>
                        <div>
                            <div class="foco input-group mb-3">
                                <input name="dni" type="text" class="form-control rounded-0" 
                                       aria-label="Default" required placeholder="DNI"
                                       aria-describedby="inputGroup-sizing-default">
                            </div>
                            <div class="foco input-group mb-3">
                                <input name="password" type="password" 
                                       class="form-control rounded-0" 
                                       aria-label="Default" required placeholder="Contraseña"
                                       aria-describedby="inputGroup-sizing-default">
                            </div> 
                        </div>
                        <div class="foco foco2 text-center">
                            <input id="boton1" type="submit" 
                                class="btn mb-3 col-6 rounded-0" 
                                value="Iniciar sesión">
                            <br>
                        </div>
                    </form>
                </div>
            </div>
            <div class="text-center pt-3">
                <a href="index.jsp" style="color:white">Ir atrás</a>
            </div>
        </div>
        
        <script>
            document.getElementById("modalerror").style.display = "none";   
        </script>
        
        <% if (request.getAttribute("error") != null) { %>
        <section>
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
        
        <section style="background-color: black; color: white;">
            <footer>
                <div class="mt-4 pt-2 d-flex flex-column flex-md-row justify-content-around">
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
    </body>
</html>
