package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, shrink-to-fit=no\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"Estilos/CSS/font.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Estilos/CSS/estilos.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("\t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("\t<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <title>Manga Box - Inicio</title>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: #292929\">\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light pt-4 pb-4 d-flex \n");
      out.write("             justify-content-between foco2\" style=\"background-color: black\">\n");
      out.write("            <a class=\"d-lg-block d-none navbar-brand titulo\" href=\"inicio.jsp\" style=\"\n");
      out.write("                color: red; font-family: fuente;\">MANGA BOX</a>\n");
      out.write("            <a class=\"d-lg-none d-block\" href=\"inicio.jsp\" style=\"\n");
      out.write("                color: red; font-family: fuente; font-size: 15px\">MANGA BOX</a>\n");
      out.write("            <a id=\"boton1\" class=\"btn mr-2 rounded-0\" data-toggle=\"modal\" \n");
      out.write("               data-target=\"#modalLogin\" style=\"color: white\" \n");
      out.write("               >Iniciar sesión</a>\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("        <div class=\"modal fade pt-5\" id=\"modalLogin\" tabindex=\"-1\" role=\"dialog\" \n");
      out.write("             aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\" \n");
      out.write("             style=\"background-color: rgba(0,0,0,0.8)\">\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\" style=\"border: 2px #292929 solid\">\n");
      out.write("                <div class=\"modal-content\" style=\"background-color: black; color: white\">\n");
      out.write("                    <form action=\"IniciarSesion.htm\" method=\"post\">\n");
      out.write("                        <div class=\"modal-header\" style=\"border-bottom-color: grey\">\n");
      out.write("                            <h5 class=\"modal-title text-center\" id=\"exampleModalLabel\">\n");
      out.write("                                Iniciar sesión\n");
      out.write("                            </h5>\n");
      out.write("                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                <span aria-hidden=\"true\" style=\"color:white\">&times;</span>\n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <div class=\"input-group mb-3\">\n");
      out.write("                                <div class=\"input-group-prepend\">\n");
      out.write("                                    <span class=\"input-group-text rounded-0\" id=\"basic-addon1\" \n");
      out.write("                                          style=\"background-color: red\">\n");
      out.write("                                        <i class=\"fa fa-user\" aria-hidden=\"true\" \n");
      out.write("                                           style=\"color: white\"></i>\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("                                <input name=\"usuario\" type=\"text\" class=\"form-control rounded-0\" \n");
      out.write("                                       aria-label=\"Default\" required \n");
      out.write("                                       aria-describedby=\"inputGroup-sizing-default\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"input-group\">\n");
      out.write("                                <div class=\"input-group-prepend\">\n");
      out.write("                                    <span class=\"input-group-text rounded-0\" id=\"basic-addon1\" \n");
      out.write("                                          style=\"background-color: red\">\n");
      out.write("                                        <i class=\"fa fa-lock\" aria-hidden=\"true\" \n");
      out.write("                                           style=\"color: white\"></i>\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("                                <input name=\"password\" type=\"password\" class=\"form-control rounded-0\" \n");
      out.write("                                       aria-label=\"Default\" required \n");
      out.write("                                       aria-describedby=\"inputGroup-sizing-default\">\n");
      out.write("                            </div>     \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\" style=\"border-top-color: grey\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"foco foco2 text-center pb-2\">\n");
      out.write("                            <input id=\"boton3\" type=\"submit\" class=\"btn mb-4 col-6 rounded-0\" \n");
      out.write("                                   value=\"Iniciar sesión\">\n");
      out.write("                            <br>\n");
      out.write("                            <a href=\"registro.jsp\" style=\"color: red\">\n");
      out.write("                                ¿No tienes una cuenta? <b>Regístrate</b>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            document.getElementById(\"modalerror\").style.display = \"none\";   \n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        ");
 if (request.getAttribute("error") != null) { 
      out.write("\n");
      out.write("        <section class=\"mt-1\">\n");
      out.write("            <div id=\"modalerror\" class=\"text-center p-2\" style=\"background-color: black; color: red\">\n");
      out.write("                ");
      out.print( request.getAttribute("error"));
      out.write("\n");
      out.write("                <button type=\"button\" onclick=\"cerrarDiv()\" class=\"close\">\n");
      out.write("                <span aria-hidden=\"true\" style=\"color:white\">&times;</span>\n");
      out.write("            </button>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            function cerrarDiv() {\n");
      out.write("                document.getElementById(\"modalerror\").style.display = \"none\";   \n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        <section class=\"mt-1\" style=\"background-color: black; color: white; font-size: 22px\">\n");
      out.write("            <div class=\"\" style=\"height: 140px; background: url(Estilos/Imagenes/fondo.png);\">\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        \n");
      out.write("        <section class=\"mt-1\" style=\"background-color: black; color: white; font-size: 22px\">\n");
      out.write("            <div class=\"text-center pb-5\">\n");
      out.write("                <h5 class=\"pt-5 d-none d-md-block\" style=\"font-family: fuente\">BIENVENIDO A MANGA BOX</h5>\n");
      out.write("                <br>\n");
      out.write("                <div class=\"d-flex flex-column flex-md-row\">\n");
      out.write("                    <div class=\"d-block d-md-none d-lg-block col-xl-6 text-md-left text-center\">\n");
      out.write("                        <span class=\"offset-md-1 offset-xl-2\">\n");
      out.write("                            <i class=\"fa fa-check\" aria-hidden=\"true\" style=\"color: red\"></i>\n");
      out.write("                            Plataforma totalmente gratuita\n");
      out.write("                        </span>\n");
      out.write("                        <br>\n");
      out.write("                        <span class=\"offset-md-1 offset-xl-2\">\n");
      out.write("                            <i class=\"fa fa-check\" aria-hidden=\"true\" style=\"color: red\"></i>\n");
      out.write("                            Tus mangas favoritos\n");
      out.write("                        </span>\n");
      out.write("                        <br>\n");
      out.write("                        <span class=\"offset-md-1 offset-xl-2 d-block d-md-none d-xl-block\">\n");
      out.write("                            <i class=\"fa fa-check\" aria-hidden=\"true\" style=\"color: red\"></i>\n");
      out.write("                            Disponible en multitud de dispositivos\n");
      out.write("                        </span>\n");
      out.write("                        <span class=\"offset-md-1 offset-xl-2 d-none d-md-block d-xl-none\">\n");
      out.write("                            <i class=\"fa fa-check\" aria-hidden=\"true\" style=\"color: red\"></i>\n");
      out.write("                            En multitud de dispositivos\n");
      out.write("                        </span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"d-none d-md-block d-lg-none col-md-6 text-md-left text-center\">\n");
      out.write("                        <span class=\"offset-md-1\" style=\"font-size: 20px\">\n");
      out.write("                            <i class=\"fa fa-check\" aria-hidden=\"true\" style=\"color: red\"></i>\n");
      out.write("                            Plataforma totalmente gratuita\n");
      out.write("                        </span>\n");
      out.write("                        <br>\n");
      out.write("                        <span class=\"offset-md-1\" style=\"font-size: 20px\">\n");
      out.write("                            <i class=\"fa fa-check\" aria-hidden=\"true\" style=\"color: red\"></i>\n");
      out.write("                            Tus mangas favoritos\n");
      out.write("                        </span>\n");
      out.write("                        <br>\n");
      out.write("                        <span class=\"offset-md-1 d-none d-md-block d-xl-none\"\n");
      out.write("                              style=\"font-size: 20px\">\n");
      out.write("                            <i class=\"fa fa-check\" aria-hidden=\"true\" style=\"color: red\"></i>\n");
      out.write("                            En multitud de dispositivos\n");
      out.write("                        </span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"foco foco2 col-xl-6\">\n");
      out.write("                        <a id=\"boton2\" class=\"btn col-8 col-sm-6 col-lg-6 \n");
      out.write("                           col-md-6 col-xl-6 offset-xl-2 mt-4 rounded-0\" \n");
      out.write("                           href=\"registro.jsp\">Pruébanos</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        \n");
      out.write("        <section class=\"mt-1\" style=\"background-color: black; color: white\">\n");
      out.write("            <div class=\"d-flex flex-column flex-xl-row justify-content-around col-xl-12\">\n");
      out.write("                <div class=\"col-xl-7 pt-5\">\n");
      out.write("                    <h5 class=\"text-xl-center col-xl-12 pt-4 d-none d-xl-block\" \n");
      out.write("                        style=\"font-family: fuente\">\n");
      out.write("                        MANGA BOX EN TUS DISPOSITIVOS\n");
      out.write("                    </h5>\n");
      out.write("                    <p class=\"text-center d-block d-xl-none\" \n");
      out.write("                       style=\"font-family: fuente\">\n");
      out.write("                        DONDE QUIERAS\n");
      out.write("                    </p>\n");
      out.write("                    <br>\n");
      out.write("                    <div class=\"pt-xl-3 pl-xl-0 text-center text-xl-left\">\n");
      out.write("                        <span class=\"h5 col-12 offset-xl-1\">\n");
      out.write("                            <i class=\"fa fa-television\" aria-hidden=\"true\" \n");
      out.write("                               style=\"color: red; font-size: 25px\"></i>\n");
      out.write("                            Disfruta de Manga Box en cualquier dispositivo.\n");
      out.write("                        </span>\n");
      out.write("                        <br>\n");
      out.write("                        <span class=\"h5 col-12 offset-xl-1\">\n");
      out.write("                            <i class=\"fa fa-tablet\" aria-hidden=\"true\" \n");
      out.write("                               style=\"color: red; font-size: 25px\"></i>\n");
      out.write("                            Desde TV, pasando por consolas, hasta SmartPhones...\n");
      out.write("                        </span>\n");
      out.write("                        <br>\n");
      out.write("                        <span class=\"h5 col-12 offset-xl-1\">\n");
      out.write("                            <i class=\"fa fa-mobile\" aria-hidden=\"true\" \n");
      out.write("                               style=\"color: red; font-size: 25px\"></i>\n");
      out.write("                            ¡No te pierdas nada, únete ya!\n");
      out.write("                        </span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"d-none d-xl-block text-xl-center pt-4 pb-4 col-xl-5 col-12\">\n");
      out.write("                    <img class=\"d-none d-xl-block col-xl-12\" src=\"Estilos/Imagenes/manga.png\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"d-block d-xl-none text-center pt-4 pb-5\">\n");
      out.write("                    <img class=\"d-none d-lg-block d-xl-none col-lg-6 offset-lg-3\" \n");
      out.write("                         src=\"Estilos/Imagenes/manga.png\">\n");
      out.write("                    <img class=\"d-none d-md-block d-lg-none col-md-6 offset-md-3\" \n");
      out.write("                         src=\"Estilos/Imagenes/manga.png\">\n");
      out.write("                    <img class=\"d-none d-sm-block d-md-none col-sm-8 offset-sm-2\" \n");
      out.write("                         src=\"Estilos/Imagenes/manga.png\">\n");
      out.write("                    <img class=\"d-none d-block d-sm-none col-10 offset-1\" \n");
      out.write("                         src=\"Estilos/Imagenes/manga.png\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        \n");
      out.write("        <section class=\"mt-1\" style=\"background-color: black; color: white\">\n");
      out.write("            <div class=\"pt-5 pb-5\">\n");
      out.write("                <h5 class=\"text-xl-center col-xl-12 pt-4 d-none d-xl-block pb-3\" \n");
      out.write("                    style=\"font-family: fuente; font-size: 16px\">\n");
      out.write("                    CONTENIDO ORGANIZADO EN CATEGORIAS\n");
      out.write("                </h5>\n");
      out.write("                <p class=\"text-center d-block d-xl-none pt-4 pb-3\" \n");
      out.write("                    style=\"font-family: fuente\">\n");
      out.write("                    DIFERENTES CATEGORIAS\n");
      out.write("                </p>\n");
      out.write("                <div class=\"text-center pb-3\">\n");
      out.write("                    <span>\n");
      out.write("                        <b style=\"color: skyblue\">\n");
      out.write("                            Kodomo\n");
      out.write("                        </b> manga, dirigido a niños pequeños.</span><br>\n");
      out.write("                    <span>\n");
      out.write("                        <b style=\"color: blue\">\n");
      out.write("                            Shōnen\n");
      out.write("                        </b> manga, dirigido a chicos adolescentes.</span><br>\n");
      out.write("                    <span>\n");
      out.write("                        <b style=\"color: violet\">\n");
      out.write("                            Shōjo\n");
      out.write("                        </b> manga, dirigido a chicas adolescentes.</span><br>\n");
      out.write("                    <span>\n");
      out.write("                        <b style=\"color: purple\">\n");
      out.write("                            Seinen\n");
      out.write("                        </b> manga, dirigido a hombres jóvenes y adultos.</span><br>\n");
      out.write("                    <span>\n");
      out.write("                        <b style=\"color: #ff00f2\">\n");
      out.write("                            Josei\n");
      out.write("                        </b> manga, dirigido a mujeres jóvenes y adultas.</span>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        \n");
      out.write("        <section class=\"mt-1\" style=\"background-color: black; color: white;\">\n");
      out.write("            <div>\n");
      out.write("                <p class=\"pt-3 pb-3 pl-3 titulo text-light text-center\" \n");
      out.write("                   style=\"font-family: fuente\">\n");
      out.write("                    ENCUENTRANOS EN \n");
      out.write("                    <a href=\"https://facebook.com\" class=\"text-body mr-1\">\n");
      out.write("                        <i class=\"text-light fa fa-facebook titulo\" \n");
      out.write("                           style=\"font-size: 25px; color: red\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <a href=\"https://instagram.com\" class=\"text-body mr-1\">\n");
      out.write("                        <i class=\"text-light fa fa-instagram titulo\" \n");
      out.write("                           style=\"font-size: 25px; color: red\"></i>\n");
      out.write("                    </a>\n");
      out.write("                    <a href=\"https://twitter.com\" class=\"text-body mr-1\">\n");
      out.write("                        <i class=\"text-light fa fa-twitter titulo\" \n");
      out.write("                           style=\"font-size: 25px; color: red\"></i>\n");
      out.write("                    </a>\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("            <footer>\n");
      out.write("                <div class=\"d-flex flex-column flex-md-row justify-content-around\">\n");
      out.write("                    <div class=\"text-center text-md-left\">\n");
      out.write("                        <a href=\"#\" style=\"color: white;\">Preguntas frecuentes</a><br>\n");
      out.write("                        <a class=\"mt-3\" href=\"#\" style=\"color: white;\">Política de Privacidad</a><br>\n");
      out.write("                        <a class=\"mt-3\" href=\"#\" style=\"color: white;\">Contacta con nosotros</a><br>\n");
      out.write("                        <a class=\"mt-3\" href=\"personal.jsp\" style=\"color: white;\">Personal</a><br>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"pt-5 pt-md-0 text-center text-md-left\">\n");
      out.write("                        <a href=\"#\" style=\"color: white;\">Términos de uso</a><br>\n");
      out.write("                        <a class=\"mt-3\" href=\"#\" style=\"color: white;\">Cookies</a><br>\n");
      out.write("                        <a class=\"mt-3\" href=\"#\" style=\"color: white;\">Avisos legales</a><br>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <p class=\"text-center pb-3\" \n");
      out.write("                    style=\"font-size: 10px; font-family: fuente;\">\n");
      out.write("                    MANGA BOX \n");
      out.write("                    <i class=\"fa fa-copyright\" aria-hidden=\"true\" \n");
      out.write("                        style=\"font-size: 18px\"></i>\n");
      out.write("                </p>\n");
      out.write("                <br>\n");
      out.write("            </footer>\n");
      out.write("        </section>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
