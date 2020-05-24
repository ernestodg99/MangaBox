package controlador;

import com.google.gson.Gson;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.MangaBox;
import modelo.entidades.Capitulo;
import modelo.entidades.Comentario;
import modelo.entidades.Email;
import modelo.entidades.Favorito;
import modelo.entidades.Imagen;
import modelo.entidades.Personal;
import modelo.entidades.Serie;
import modelo.entidades.Usuario;
import modelo.entidades.Utilidades;

/**
 *
 * @author ernesto
 */
@MultipartConfig(fileSizeThreshold = 1000000000,
        maxFileSize = 1000000000,
        maxRequestSize = 1000000000)
public class Controller extends HttpServlet {
    public static final int TAM_BUFFER = 4 * 1024;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Request.setCharacterEncoding( "UTF-8" ) resuelve el problema de las tildes
        request.setCharacterEncoding( "UTF-8" );
        Usuario sesionusuario = (Usuario)request.getSession().getAttribute("usuario");
        Personal sesionadmin = (Personal)request.getSession().getAttribute("admin"); 
        Personal sesionpersonal = (Personal)request.getSession().getAttribute("personal");
        String accion = request.getServletPath();
        
        //********************Administrador: Actualizar descripción de una serie 
        if (accion.equals("/ActualizarDescripcionSerie.htm")) {
            if (sesionadmin != null) {
                String descripcion = request.getParameter("descripcion");
                String nombreserie = request.getParameter("nombre");
                MangaBox mb = new MangaBox();
                try {
                    mb.setDescripcion(descripcion, nombreserie);
                    request.getRequestDispatcher("/VerMangaAdmin.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Administrador: Actualizar fecha de la serie
        }else if (accion.equals("/ActualizarFechaSerie.htm")) {
            if (sesionadmin != null) {
                String fecha = request.getParameter("fecha");
                String nombreserie = request.getParameter("nombre");
                MangaBox mb = new MangaBox();
                try {
                    mb.setFecha(fecha, nombreserie);
                    request.getRequestDispatcher("/VerMangaAdmin.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Actualizar datos
        }else if (accion.equals("/ActualizarUsuario.htm")) {
            if (sesionusuario != null) {       
                Usuario usuario2 = null;
                MangaBox mb = new MangaBox();
                String nombre = "";
                String apellidos = "";
                String email = "";
                String password = "";
                String passwordcifrado = null;
                String foto = "";
        
                if (!sesionusuario.getNombre().equals(request.getParameter("nombre"))) {
                    nombre = request.getParameter("nombre");
                    try {
                        mb.setNombreUsuario(nombre, sesionusuario.getDni());
                    } catch (SQLException ex) {
                        System.out.println("Error SQL");
                    }
                }
                if (!sesionusuario.getApellidos().equals(request.getParameter("apellidos"))) {
                    apellidos = request.getParameter("apellidos");
                    try {
                        mb.setApellidosUsuario(apellidos, sesionusuario.getDni());
                    } catch (SQLException ex) {
                        System.out.println("Error SQL");
                    }
                }
                if (!sesionusuario.getEmail().equals(request.getParameter("email"))) {
                    email = request.getParameter("email");
                    try {
                        mb.setEmailUsuario(email, sesionusuario.getDni());
                    } catch (SQLException ex) {
                        System.out.println("Error SQL");
                    }
                }
                if (!request.getParameter("password").equals("")) {
                    if (!sesionusuario.getContraseña().equals(request.getParameter("password"))) {
                        password = request.getParameter("password");
                        //Ciframos la contraseña
                        try {
                            passwordcifrado = mb.codificarSHA256(password);
                            mb.setContraseñaUsuario(passwordcifrado, sesionusuario.getDni());
                        } catch (NoSuchAlgorithmException ex) {
                            System.out.println("Error al cifrar");
                        } catch (SQLException ex) {
                            System.out.println("Error SQL");
                        }
                    }
                }
                if (!sesionusuario.getFoto().equals(request.getParameter("foto"))) {
                    foto = request.getParameter("foto");
                    try {
                        mb.setFotoUsuario(foto, sesionusuario.getDni());
                    } catch (SQLException ex) {
                        System.out.println("Error SQL");
                    }
                } else {
                    foto = "";
                }    
        
                usuario2 = mb.getUsuario(sesionusuario.getDni());
                request.getSession().setAttribute("usuario", usuario2);
                request.getRequestDispatcher("perfil.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }   
            
        //********************Administrador: Actualizar datos    
        }else if (accion.equals("/ActualizarAdministrador.htm")) {
            if (sesionadmin != null) {       
                Personal administrador = null;
                MangaBox mb = new MangaBox();
                String nombre = "";
                String password = "";
                String passwordcifrado = null;
        
                if (!sesionadmin.getNombre().equals(request.getParameter("nombre"))) {
                    nombre = request.getParameter("nombre");
                    try {
                        mb.setNombreAdmin(nombre, sesionadmin.getDni());
                    } catch (SQLException ex) {
                        System.out.println("Error SQL");
                    }
                }
                if (!request.getParameter("passwordadmin").equals("")) {
                    if (!sesionadmin.getContraseña().equals(request.getParameter("passwordadmin"))) {
                        password = request.getParameter("passwordadmin");
                        //Ciframos la contraseña
                        try {
                            passwordcifrado = mb.codificarSHA256(password);
                            mb.setContraseñaAdmin(passwordcifrado, sesionadmin.getDni());
                        } catch (NoSuchAlgorithmException ex) {
                            System.out.println("Error al cifrar");
                        } catch (SQLException ex) {
                            System.out.println("Error SQL");
                        }
                    }
                }    
        
                administrador = mb.getAdministrador();
                request.getSession().setAttribute("admin", administrador);
                request.getRequestDispatcher("adminperfil.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }   
            
        //********************Personal: Actualizar datos   
        }else if (accion.equals("/ActualizarPersonal.htm")) {
            if (sesionpersonal != null) {       
                Personal personal = null;
                MangaBox mb = new MangaBox();
                String nombre = "";
                String password = "";
                String passwordcifrado = null;
        
                if (!sesionpersonal.getNombre().equals(request.getParameter("nombre"))) {
                    nombre = request.getParameter("nombre");
                    try {
                        mb.setNombrePersonal(nombre, sesionpersonal.getDni());
                    } catch (SQLException ex) {
                        System.out.println("Error SQL");
                    }
                }
                if (!request.getParameter("passwordpersonal").equals("")) {
                    if (!sesionpersonal.getContraseña().equals(request.getParameter("passwordpersonal"))) {
                        password = request.getParameter("passwordpersonal");
                        //Ciframos la contraseña
                        try {
                            passwordcifrado = mb.codificarSHA256(password);
                            mb.setContraseñaPersonal(passwordcifrado, sesionpersonal.getDni());
                        } catch (NoSuchAlgorithmException ex) {
                            System.out.println("Error al cifrar");
                        } catch (SQLException ex) {
                            System.out.println("Error SQL");
                        }
                    }
                }    
        
                personal = mb.getPersonal(sesionpersonal.getDni());
                request.getSession().setAttribute("personal", personal);
                request.getRequestDispatcher("personalperfil.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }   
            
        //********************Personal: Añadir capítulo    
        }else if(accion.equals("/AddCapitulo.htm")) {
            if (sesionpersonal != null) {
                Capitulo cap = null;
                int capitulonumero = Integer.parseInt(request.getParameter("capitulonumero"));
                String nombreserie = request.getParameter("nombreserie");
                String dnipersonal = request.getParameter("personalserie");
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                boolean visible = false;
                Serie serie = null;
                Personal administrador = null;
                Personal personalserie = null;
           
                MangaBox mb = new MangaBox();
                try {
                    cap = mb.comprobarCapitulo(nombreserie, capitulonumero);
                    if (cap == null) {
                        try {
                            administrador = mb.getAdministrador();
                            personalserie = mb.buscarPersonalPorDni(dnipersonal);
                            serie = mb.getSerie(nombreserie);
                        } catch (SQLException ex) {
                            System.out.println("Error SQL");
                        }
                
                        Capitulo capitulo = new Capitulo(capitulonumero, nombre, descripcion, serie,
                            administrador, personalserie, visible);
                
                        try {
                            mb.registrarCapitulo(capitulo);
                            request.getRequestDispatcher("/VerCapitulosPersonal.htm").forward(request, response);
                        } catch (SQLException ex) {
                            System.out.println("Error SQL");
                        }
                    } else {
                        request.setAttribute("error", "El número de capítulo para esta serie ya existe");
                        request.getRequestDispatcher("personalserie.jsp").forward(request, response);
                    }
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Añadir comentario
        }else if(accion.equals("/AddComentario.htm")) {
            if (sesionusuario != null) {
                String dniusuario = request.getParameter("usuario");
                int capitulo = Integer.parseInt(request.getParameter("idcapitulo"));
                String comentario = request.getParameter("comentario");
                Usuario usuario = null;
                Capitulo cap = null;
                Comentario coment = null;
                Comentario[] comentarios = null;
                MangaBox mb = new MangaBox();
                try {
                    usuario = mb.getUsuario(dniusuario);
                    cap = mb.getCapituloPorId(capitulo);
                    coment = new Comentario(cap, usuario, comentario);
                    mb.registrarComentario(coment);
                    comentarios = mb.getComentarios(capitulo);
                    request.getSession().setAttribute("usuariocomentarios", comentarios);
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<div class=\"d-flex pl-2 pr-2 col-xl-6 offset-xl-3 \n" +
                        "col-lg-6 offset-lg-3 col-md-8 offset-md-2 col-sm-8 \n" +
                        "offset-sm-2 col-10 offset-1 mb-2\" style=\"background-color: #292929\">");
                        out.println("<div>");
                        out.println("<img class=\"d-block pt-2 pb-2 rounded-circle\" src=\"" 
                                + coment.getFoto() 
                                + "\" width=\"80px\" style=\"margin: 0 auto\">");
                        out.println("</div>");            
                        out.println("<div class=\" pt-2\">");
                        out.println("<p class=\"text-left pl-3\" style=\"font-size: 16px;"
                                + " color: red; font-weight: bold\">" +
                        " " + coment.getUsuario()+ "</p>");
                        out.println("<p class=\"pl-5\">\n" + comentario + "</p>");
                        out.println("</div>");
                        out.println("</div>");
                    }
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Añadir favorito
        }else if(accion.equals("/AddFavorito.htm")) {
            if (sesionusuario != null) {
                String dniusuario = request.getParameter("usuario");
                String serie = request.getParameter("serie");
                Usuario usuario = null;
                Serie ser = null;
                Favorito fav = null;
                MangaBox mb = new MangaBox();
                try {
                    usuario = mb.getUsuario(dniusuario);
                    ser = mb.getSerie(serie);
                    fav = new Favorito(usuario, ser);
                    mb.registrarFavorito(fav);
                    request.getSession().setAttribute("favorito", fav);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Administrador: Añadir manga
        }else if(accion.equals("/AddManga.htm")) {
            if (sesionadmin != null) {
                String nombre = request.getParameter("nombre");
                String categoria = request.getParameter("categoria");
                String autor = request.getParameter("autor");
                String personal = request.getParameter("personal");
                String admin = request.getParameter("administrador");
                Personal administrador = null;
                Personal personalserie = null;
        
                MangaBox mb = new MangaBox();
                administrador = mb.buscarPersonalPorDni(admin);
                personalserie = mb.buscarPersonalPorDni(personal);
                Serie serie = new Serie(nombre, autor, categoria, null, null, null, null, 
                    administrador, personalserie, false); 
        
                try {
                    mb.registrarSerie(serie);
                    request.getRequestDispatcher("/VerMangasAdmin.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Administrador: Añadir personal
        }else if(accion.equals("/AddPersonal.htm")) {
            if (sesionadmin != null) {
                String dni = request.getParameter("dni");
                String nombre = request.getParameter("nombre");
                String contraseña = request.getParameter("password");
                String rol = "serie";
                String password = "";
                MangaBox mb = new MangaBox();
                try {
                    password = mb.codificarSHA256(contraseña);
                } catch (NoSuchAlgorithmException ex) {
                    System.out.println("Error al cifrar la contraseña");
                }
                Personal per = new Personal(dni, nombre, rol, password);
                try {
                    mb.registroPersonal(per);
                    request.getRequestDispatcher("adminpersonal.jsp").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Erro SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Usuario: Autocompletado del input buscar
        }else if(accion.equals("/AutoComplete.htm")) {
            if (sesionusuario != null) {
                String nombre = request.getParameter("nombre");
                MangaBox mb = new MangaBox();
                ArrayList<String> series = null;
                String json = "";
                try {
                    series = mb.buscarSeries(nombre);
                    json = new Gson().toJson(series);
                    response.setContentType("text/html;charset=UTF-8");
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Administrador: Autocompletado del input Buscar
        }else if(accion.equals("/AutoComplete2.htm")) {
            if (sesionadmin != null) {
                String nombre = request.getParameter("nombre");
                MangaBox mb = new MangaBox();
                ArrayList<String> series = null;
                String json = "";
                try {
                    series = mb.buscarSeries(nombre);
                    json = new Gson().toJson(series);
                    response.setContentType("text/html;charset=UTF-8");
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Personal: Borrar capítulo
        } else if(accion.equals("/BorrarCapitulo.htm")) {
            if (sesionpersonal != null) {
                int capitulo = Integer.parseInt(request.getParameter("idcapitulo"));
                MangaBox mb = new MangaBox();
                try {
                    mb.eliminarCapitulo(capitulo);
                    request.getRequestDispatcher("/SeriePersonal.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Usuario: Buscar serie
        }else if(accion.equals("/BuscarSerie.htm")) {
            if (sesionusuario != null) {
                String ser = request.getParameter("serie");
                MangaBox mb = new MangaBox();
                Serie[] series = null;
                LocalDate fechaNac = sesionusuario.getFecha().toLocalDate();
                LocalDate ahora = LocalDate.now();
                Period periodo = Period.between(fechaNac, ahora);
                if (periodo.getYears() >= 18) {
                    try {
                        series = mb.buscarSeriesMayores(ser);
                        request.getSession().setAttribute("buscarserie", series);
                        request.getRequestDispatcher("/VerMangas2.htm").forward(request, response);
                    } catch (SQLException ex) {
                        System.out.println("Error");
                    }
                } else {
                    try {
                        series = mb.buscarSeriesMenores(ser);
                        request.getSession().setAttribute("buscarserie", series);
                        request.getRequestDispatcher("/VerMangas2.htm").forward(request, response);
                    } catch (SQLException ex) {
                        System.out.println("Error");
                    }
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Usuario: Cerrar sesión
        }else if(accion.equals("/CerrarSesion.htm")) {
            if (sesionusuario != null) {
                request.getSession().invalidate();
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Administrador: Cerrar sesión personal
        }else if(accion.equals("/CerrarSesionAdmin.htm")) {
            if (sesionadmin != null) {
                request.getSession().invalidate();
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Personal: Cerrar sesión personal
        }else if(accion.equals("/CerrarSesionPersonal.htm")) {
            if (sesionpersonal != null) {
                request.getSession().invalidate();
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Usuario: Eliminar favorito
        }else if(accion.equals("/EliminarFavorito.htm")) {
            if (sesionusuario != null) {
                String dniusuario = request.getParameter("usuario");
                String serie = request.getParameter("serie");
                Usuario usuario = null;
                Serie ser = null;
                Favorito fav = null;
                MangaBox mb = new MangaBox();
                try {
                    usuario = mb.getUsuario(dniusuario);
                    ser = mb.getSerie(serie);
                    fav = new Favorito(usuario, ser);
                    mb.eliminarFavorito(fav);
                    request.getSession().setAttribute("favorito", null);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Administrador: Eliminar logo serie
        }else if(accion.equals("/EliminarLogoSerie.htm")) {
            if (sesionadmin != null) {
                String nombreserie = request.getParameter("nombre1");
                MangaBox mb = new MangaBox();
                try {
                    mb.eliminarLogo(nombreserie);
                    request.getRequestDispatcher("/VerMangaAdmin.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Administrador: Eliminar logo serie
        }else if(accion.equals("/EliminarLogoSerie2.htm")) {
            if (sesionadmin != null) {
                String nombreserie = request.getParameter("nombre2");
                MangaBox mb = new MangaBox();
                try {
                    mb.eliminarLogo2(nombreserie);
                    request.getRequestDispatcher("/VerMangaAdmin.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Administrador: Eliminar descripción serie
        }else if(accion.equals("/EliminarDescripcionSerie.htm")) {
            if (sesionadmin != null) {
                String nombreserie = request.getParameter("nombre3");
                MangaBox mb = new MangaBox();
                try {
                    mb.eliminarDescripcion(nombreserie);
                    request.getRequestDispatcher("/VerMangaAdmin.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Administrador: Eliminar fecha serie
        }else if(accion.equals("/EliminarFechaSerie.htm")) {
            if (sesionadmin != null) {
                String nombreserie = request.getParameter("nombre4");
                MangaBox mb = new MangaBox();
                try {
                    mb.eliminarFecha(nombreserie);
                    request.getRequestDispatcher("/VerMangaAdmin.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Administrador: Eliminar serie
        }else if(accion.equals("/EliminarSerie.htm")) {
            if (sesionadmin != null) {
                String nombreserie = request.getParameter("nombreserie");
                MangaBox mb = new MangaBox();
                try {
                    mb.eliminarSerie(nombreserie);
                    request.getRequestDispatcher("/VerMangasAdmin.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Iniciar sesión
        } else if(accion.equals("/IniciarSesion.htm")) {
            String login = request.getParameter("usuario");
            String password = request.getParameter("password");
            MangaBox mb = new MangaBox();
            Usuario us = mb.login(login, password);
            if (us != null) {
                request.getSession().setAttribute("usuario", us);
                request.getRequestDispatcher("/VerMangas.htm").forward(request, response);
            } else {
                request.setAttribute("error", "Usuario o contraseña incorrectos");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Administrador y Personal: Iniciar sesión
        }else if(accion.equals("/IniciarSesionPersonal.htm")) {
            String dni = request.getParameter("dni");
            String password = request.getParameter("password");
            String pass = "";
            String rol = "";
            MangaBox mb = new MangaBox();
            if (password.equals("jhonadmin")) {
                pass = "jhonadmin";
            } else {
                try {
                    pass = mb.codificarSHA256(password);
                } catch (NoSuchAlgorithmException ex) {
                    System.out.println("Error al cifrar");
                }
            }
            Personal per = mb.buscarPersonal(dni, pass);
            if (per != null) {
                rol = per.getRol().toLowerCase();
                switch (rol) {
                    case "administrador":
                        request.getSession().setAttribute("admin", per);
                        request.getRequestDispatcher("/VerMangasAdmin.htm").forward(request, response);
                        break;
                    case "serie":
                        request.getSession().setAttribute("personal", per);
                        request.getRequestDispatcher("/SeriePersonal.htm").forward(request, response);
                        break;
                }
            } else {
                request.setAttribute("error", "Usuario o contraseña incorrectos");
                request.getRequestDispatcher("personal.jsp").forward(request, response);
            }
        
        //********************Usuario: Registro usuarios
        }else if(accion.equals("/RegistroUsuarios.htm")) {
            Usuario usuario = null;
            MangaBox mb = new MangaBox();
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String email = request.getParameter("email");
            java.sql.Date fecha = Date.valueOf(request.getParameter("fecha"));
            String login = request.getParameter("usuario");
            String password = request.getParameter("password");
            String passwordcifrado = null;
            String foto = "";
            if (request.getParameter("foto") != null) {
                foto = request.getParameter("foto");
            } else if (request.getParameter("foto2") != null) {
                foto = request.getParameter("foto2");
            }
            //Ciframos la contraseña
            try {
                passwordcifrado = mb.codificarSHA256(password);
            } catch (NoSuchAlgorithmException ex) {
                System.out.println("Error al cifrar");
            }
        
            usuario = new Usuario(dni, nombre, apellidos, email, fecha, login, passwordcifrado, foto);
            //Registramos el usuario
            try {
                mb.registroUsuarios(usuario);
                request.setAttribute("error", null);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (SQLException ex) {
                System.out.println("Error SQL");
            }
        
        //********************Personal: Serie personal
        }else if(accion.equals("/SeriePersonal.htm")) {
            if (sesionpersonal != null) {
                Personal per = (Personal)request.getSession().getAttribute("personal");
                Serie serie = null;
                MangaBox mb = new MangaBox();
                try {
                    serie = mb.getSeriePersonal(per.getDni());
                    request.getSession().setAttribute("seriepersonal", serie);            
                    request.getRequestDispatcher("/VerCapitulosPersonal.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Administrador: Set no visible
        }else if(accion.equals("/SetNoVisible.htm")) {
            if (sesionadmin != null) {
                String nombreserie = request.getParameter("serie");
                Serie serie = null;
                MangaBox mb = new MangaBox();
                try {
                    mb.setNoVisible(nombreserie);
                    serie = mb.getSerie(nombreserie);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
                request.getSession().setAttribute("serie", serie);
                request.getRequestDispatcher("/VerCapitulosAdministrador.htm").forward(request, response);
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Personal: Set no visible capitulo
        }else if(accion.equals("/SetNoVisibleCapitulo.htm")) {
            if (sesionpersonal != null) {
                int idcap = Integer.parseInt(request.getParameter("capit"));
                Capitulo capitulo = null;
                MangaBox mb = new MangaBox();
                try {
                    mb.setNoVisibleCapitulo(idcap);
                    capitulo = mb.getCapituloPorId(idcap);
                    request.getSession().setAttribute("cap", capitulo);
                    request.getRequestDispatcher("/VerImagenesCapitulo.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Administrador: Set visible
        }else if(accion.equals("/SetVisible.htm")) {
            if (sesionadmin != null) {
                String nombreserie = request.getParameter("serie");
                Serie serie = null;
                MangaBox mb = new MangaBox();
                try {
                    mb.setVisible(nombreserie);
                    serie = mb.getSerie(nombreserie);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
                request.getSession().setAttribute("serie", serie);
                request.getRequestDispatcher("/VerCapitulosAdministrador.htm").forward(request, response);
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Personal: Set visible capitulo
        }else if(accion.equals("/SetVisibleCapitulo.htm")) {
            if (sesionpersonal != null) {
                Serie seriepersonal = (Serie)request.getSession().getAttribute("seriepersonal");
                int idcap = Integer.parseInt(request.getParameter("capit"));
                Capitulo capitulo = null;
                MangaBox mb = new MangaBox();
                Email email = new Email();
                String correo = "";
                String[] emails = new String[100];
                try {
                    mb.setVisibleCapitulo(idcap);
                    capitulo = mb.getCapituloPorId(idcap);
                    emails = mb.getEmailsFavoritos(seriepersonal.getNombre());
                    email.setFrom("mangabox20@gmail.com");
                    for (int i = 0; i < emails.length; i ++) {
                        correo = emails[i];
                        email.setTo(correo);
                        email.setSubject("Nuevo capítulo de " + seriepersonal.getNombre());
                        email.setText("Ha llegado a MangaBox un nuevo capítulo de su serie"
                        + " favorita " + seriepersonal.getNombre() + ". Puedes leerlo "
                        + "desde ya, en la plataforma de MangaBox :)");
                        Utilidades u = new Utilidades();
                        u.enviarEmail(email);
                    }
                    request.getSession().setAttribute("cap", capitulo);
                    request.getRequestDispatcher("/VerImagenesCapitulo.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Administrador: Upload stream
        }else if(accion.equals("/UploadStream.htm")) {
            if (sesionadmin != null) {
                Part parte = request.getPart("fichero");
                if (parte.getSize() == 0) {
                    request.setAttribute("error", "No ha seleccionado una imagen");
                    request.getRequestDispatcher("vermangaadmin.jsp").forward(request, response); 
                } else {
                    String nombreFichero = parte.getSubmittedFileName();
                    InputStream entrada = parte.getInputStream();
                    String ruta = getServletContext().getRealPath("/Estilos/Imagenes") + "/" + nombreFichero;
                    FileOutputStream salida = new FileOutputStream(ruta);
                    byte[] buffer = new byte[TAM_BUFFER];
                    while (entrada.available() > 0) {
                        int tam = entrada.read(buffer);
                        salida.write(buffer, 0, tam);
                    }
                    salida.close();
                    entrada.close();
        
                    String nombreManga = request.getParameter("nombre");
                    MangaBox mb = new MangaBox();
                    try {
                        mb.setFoto(nombreManga, nombreFichero);
                        request.getRequestDispatcher("/VerMangaAdmin.htm").forward(request, response);
                    } catch (SQLException ex) {
                        System.out.println("Error SQL");
                    }
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Administrador: Upload stream 1
        }else if(accion.equals("/UploadStream1.htm")) {
            if (sesionadmin != null) {
                Part parte = request.getPart("fichero2");
                if (parte.getSize() == 0) {
                    request.setAttribute("error", "No ha seleccionado una imagen");
                    request.getRequestDispatcher("vermangaadmin.jsp").forward(request, response); 
                } else {
                    String nombreFichero = parte.getSubmittedFileName();
                    InputStream entrada = parte.getInputStream();
                    String ruta = getServletContext().getRealPath("/Estilos/Imagenes") + "/" + nombreFichero;
                    FileOutputStream salida = new FileOutputStream(ruta);
                    byte[] buffer = new byte[TAM_BUFFER];
                    while (entrada.available() > 0) {
                        int tam = entrada.read(buffer);
                        salida.write(buffer, 0, tam);
                    }
                    salida.close();
                    entrada.close();
        
                    String nombreManga = request.getParameter("nombre");
                    MangaBox mb = new MangaBox();
                    try {
                        mb.setFoto2(nombreManga, nombreFichero);
                        request.getRequestDispatcher("/VerMangaAdmin.htm").forward(request, response);
                    } catch (SQLException ex) {
                        System.out.println("Error SQL");
                    }
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
        //********************Personal: Upload stream 2
        }else if(accion.equals("/UploadStream2.htm")) {
            if (sesionpersonal != null) {
                Part parte = request.getPart("fichero");
                if (parte.getSize() == 0) {
                    request.setAttribute("error", "No ha seleccionado una imagen");
                    request.getRequestDispatcher("personalcapitulo.jsp").forward(request, response); 
                } else {
                    String nombreFichero = parte.getSubmittedFileName();
                    InputStream entrada = parte.getInputStream();
                    String ruta = getServletContext().getRealPath("/Estilos/Imagenes") + "/" + nombreFichero;
                    FileOutputStream salida = new FileOutputStream(ruta);
                    byte[] buffer = new byte[TAM_BUFFER];
                    while (entrada.available() > 0) {
                        int tam = entrada.read(buffer);
                        salida.write(buffer, 0, tam);
                    }
                    salida.close();
                    entrada.close();
        
                    int idcapitulo = Integer.parseInt(request.getParameter("idcapitulo"));
                    MangaBox mb = new MangaBox();
                    try {
                        mb.setImagen(idcapitulo, nombreFichero);
                        request.getRequestDispatcher("/VerImagenesCapitulo.htm").forward(request, response);
                    } catch (SQLException ex) {
                        System.out.println("Error SQL");
                    }
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Ver capítulo
        }else if(accion.equals("/VerCapitulo.htm")) {
            if (sesionusuario != null) {
                int idcapitulo = Integer.parseInt(request.getParameter("idcapitulo"));
                String nombreserie = request.getParameter("nombreserie");
                Capitulo capitulo = null;
                MangaBox mb = new MangaBox();
                try {
                    capitulo = mb.getCapitulo(idcapitulo, nombreserie);
                    request.getSession().setAttribute("usuariocap", capitulo);
                    request.getRequestDispatcher("/VerImagenes.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Administrador: Ver capítulo
        }else if(accion.equals("/VerCapituloAdministrador.htm")) {
            if (sesionadmin != null) {
                int idcapitulo = Integer.parseInt(request.getParameter("idcapitulo"));
                String nombreserie = request.getParameter("nombreserie");
                Capitulo capitulo = null;
                MangaBox mb = new MangaBox();
                try {
                    capitulo = mb.getCapitulo(idcapitulo, nombreserie);
                    request.getSession().setAttribute("cap", capitulo);
                    request.getRequestDispatcher("/VerImagenesCapituloAdministrador.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Personal: Ver capítulo
        }else if(accion.equals("/VerCapituloPersonal.htm")) {
            if (sesionpersonal != null) {
                int idcapitulo = Integer.parseInt(request.getParameter("idcapitulo"));
                String nombreserie = request.getParameter("nombreserie");
                Capitulo capitulo = null;
                MangaBox mb = new MangaBox();
                try {
                    capitulo = mb.getCapitulo(idcapitulo, nombreserie);
                    request.getSession().setAttribute("cap", capitulo);
                    request.getRequestDispatcher("/VerImagenesCapitulo.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Ver capítulos
        }else if(accion.equals("/VerCapitulos.htm")) {
            if (sesionusuario != null) {
                Serie serie = (Serie)request.getSession().getAttribute("usuarioserie");
                MangaBox mb = new MangaBox();
                Capitulo[] capitulos = null;
                try {
                    capitulos = mb.getCapitulos(serie.getNombre());
                    request.getSession().setAttribute("usuariocapitulos", capitulos);
                    request.getRequestDispatcher("/VerFavorito.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Personal: Ver capítulos
        }else if(accion.equals("/VerCapitulosPersonal.htm")) {
            if (sesionpersonal != null) {
                Serie seriepersonal = (Serie)request.getSession().getAttribute("seriepersonal");
                String nombre = seriepersonal.getNombre();
                MangaBox mb = new MangaBox();
                Capitulo[] capitulos = null;
                try {
                    capitulos = mb.getCapitulosPersonal(nombre);
                    request.getSession().setAttribute("capitulos", capitulos);
                    request.getRequestDispatcher("personalserie.jsp").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Ver comentarios de un capítulo
        }else if(accion.equals("/VerComentariosCapitulo.htm")) {
            if (sesionusuario != null) {
                int idcapitulo = Integer.parseInt(request.getParameter("idcapitulo"));  
                MangaBox mb = new MangaBox();
                Comentario[] comentarios = null;
                try {
                    comentarios = mb.getComentarios(idcapitulo);
                    request.getSession().setAttribute("usuariocomentarios", comentarios);
                    request.getRequestDispatcher("vercapitulo.jsp").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Ver comentarios del ultimo capítulo publicado
        }else if(accion.equals("/VerComentariosUltimoCapitulo.htm")) {
            if (sesionusuario != null) {
                Capitulo cap = (Capitulo)request.getSession().getAttribute("usuariocap");
                MangaBox mb = new MangaBox();
                Comentario[] comentarios = null;
                try {
                    comentarios = mb.getComentarios(cap.getId());
                    request.getSession().setAttribute("usuariocomentarios", comentarios);
                    request.getRequestDispatcher("vercapitulo.jsp").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }    
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Ver favorito
        }else if(accion.equals("/VerFavorito.htm")) {
            if (sesionusuario != null) {
                String serie = request.getParameter("nombre");
                MangaBox mb = new MangaBox();
                Favorito favorito = null;
                favorito = mb.getFavorito(sesionusuario, serie);
                request.getSession().setAttribute("favorito", favorito);
                request.getRequestDispatcher("vermanga.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Ver favoritos
        }else if(accion.equals("/VerFavoritos.htm")) {
            if (sesionusuario != null) {
                MangaBox mb = new MangaBox();
                Serie[] series = null;
                try {
                    series = mb.getFavoritos(sesionusuario);
                    request.getSession().setAttribute("mangas3", series);
                    request.getRequestDispatcher("favoritos.jsp").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Ver imágenes de un capítulo
        }else if(accion.equals("/VerImagenes.htm")) {
            if (sesionusuario != null) {
                int idcapitulo = Integer.parseInt(request.getParameter("idcapitulo"));
                MangaBox mb = new MangaBox();
                Imagen[] imgs = null;
                try {
                    imgs = mb.getImagenes(idcapitulo);
                    request.getSession().setAttribute("usuarioimagenes", imgs);
                    request.getRequestDispatcher("/VerComentariosCapitulo.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Personal: Ver imágenes de un capítulo
        }else if(accion.equals("/VerImagenesCapitulo.htm")) {
            if (sesionpersonal != null) {
                int idcapitulo = Integer.parseInt(request.getParameter("idcapitulo"));
                MangaBox mb = new MangaBox();
                Imagen[] imgs = null;
                try {
                    imgs = mb.getImagenes(idcapitulo);
                    request.getSession().setAttribute("imagenes", imgs);
                    request.getRequestDispatcher("personalcapitulo.jsp").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                } 
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Administrador: Ver imágenes de un capítulo
        }else if(accion.equals("/VerImagenesCapituloAdministrador.htm")) {
            if (sesionadmin != null) {
                int idcapitulo = Integer.parseInt(request.getParameter("idcapitulo"));
                MangaBox mb = new MangaBox();
                Imagen[] imgs = null;
                try {
                    imgs = mb.getImagenes(idcapitulo);
                    request.getSession().setAttribute("imagenes", imgs);
                    request.getRequestDispatcher("admincapitulo.jsp").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Ver imágenes del último capítulo publicado
        }else if(accion.equals("/VerImagenesUltimoCapitulo.htm")) {
            if (sesionusuario != null) {
                Capitulo cap = (Capitulo)request.getSession().getAttribute("usuariocap");
                MangaBox mb = new MangaBox();
                Imagen[] imgs = null;
                try {
                    imgs = mb.getImagenes(cap.getId());
                    request.getSession().setAttribute("usuarioimagenes", imgs);
                    request.getRequestDispatcher("/VerComentariosUltimoCapitulo.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Ver manga
        }else if(accion.equals("/VerManga.htm")) {
            if (sesionusuario != null) {
                String nombre = request.getParameter("nombre");
                MangaBox mb = new MangaBox();
                Serie serie = null;
                try {
                    serie = mb.getSerie(nombre);
                    request.getSession().setAttribute("usuarioserie", serie);
                    request.getRequestDispatcher("/VerCapitulos.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Administrador: Ver manga
        }else if(accion.equals("/VerMangaAdmin.htm")) {
            if (sesionadmin != null) {
                String nombre = null;
                if (request.getParameter("nombre") != null) {
                    nombre = request.getParameter("nombre");
                } else if (request.getParameter("nombre1") != null) {
                    nombre = request.getParameter("nombre1");
                } else if (request.getParameter("nombre2") != null) {
                    nombre = request.getParameter("nombre2");
                } else if (request.getParameter("nombre3") != null) {
                    nombre = request.getParameter("nombre3");
                } else if (request.getParameter("nombre4") != null) {
                    nombre = request.getParameter("nombre4");
                }
                MangaBox mb = new MangaBox();
                Serie serie = null;
                Capitulo[] capitulos = null;
                try {
                    serie = mb.getSerie(nombre);
                    request.getSession().setAttribute("serie", serie);
                    capitulos = mb.getCapitulosAdmin(nombre);
                    request.getSession().setAttribute("capitulos", capitulos);
                    request.getRequestDispatcher("vermangaadmin.jsp").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Ver mangas
        }else if(accion.equals("/VerMangas.htm")) {
            if (sesionusuario != null) {
                MangaBox mb = new MangaBox();
                Serie[] series = null;
                LocalDate fechaNac = sesionusuario.getFecha().toLocalDate();
                LocalDate ahora = LocalDate.now();
                Period periodo = Period.between(fechaNac, ahora);
                if (periodo.getYears() >= 18) {
                    try {
                        series = mb.getSeries();
                        request.getSession().setAttribute("mangas", series);
                        request.getRequestDispatcher("principal.jsp").forward(request, response);
                    } catch (SQLException ex) {
                        System.out.println("Error");
                    }
                } else {
                    try {
                        series = mb.getSeriesMenores();
                        request.getSession().setAttribute("mangas", series);
                        request.getRequestDispatcher("principal.jsp").forward(request, response);
                    } catch (SQLException ex) {
                        System.out.println("Error");
                    }
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Ver mangas 2
        }else if(accion.equals("/VerMangas2.htm")) {
            if (sesionusuario != null) {
                MangaBox mb = new MangaBox();
                Serie[] series = null;
                LocalDate fechaNac = sesionusuario.getFecha().toLocalDate();
                LocalDate ahora = LocalDate.now();
                Period periodo = Period.between(fechaNac, ahora);
                if (periodo.getYears() >= 18) {
                    try {
                        series = mb.getSeries();
                        request.getSession().setAttribute("mangas2", series);
                        request.getRequestDispatcher("mangas.jsp").forward(request, response);
                    } catch (SQLException ex) {
                        System.out.println("Error");
                    }
                } else {
                    try {
                        series = mb.getSeriesMenores();
                        request.getSession().setAttribute("mangas2", series);
                        request.getRequestDispatcher("mangas.jsp").forward(request, response);
                    } catch (SQLException ex) {
                        System.out.println("Error");
                    }
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Administrador: Ver mangas
        }else if(accion.equals("/VerMangasAdmin.htm")) {
            if (sesionadmin != null) {
                MangaBox mb = new MangaBox();
                Serie[] series = null;
                try {
                    series = mb.getSeriesAdministrador();
                    request.getSession().setAttribute("series", series);
                    request.getRequestDispatcher("/VerPersonalSeries.htm").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Ver perfil
        }else if(accion.equals("/VerPerfil.htm")) {
            if (sesionusuario != null) {
                request.getRequestDispatcher("perfil.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Adminsitrador: Ver perfil
        }else if(accion.equals("/VerPerfilAdmin.htm")) {
            if (sesionadmin != null) {
                request.getRequestDispatcher("adminperfil.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Personal: Ver perfil
        }else if(accion.equals("/VerPerfilPersonal.htm")) {
            if (sesionpersonal != null) {
                request.getRequestDispatcher("personalperfil.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Adminsitrador: Ver personal de una serie
        }else if(accion.equals("/VerPersonalSerie.htm")) {
            if (sesionadmin != null) {
                MangaBox mb = new MangaBox();
                String serie = request.getParameter("serie");
                Personal per = null;
                try {
                    per = mb.getPersonalSerie(serie);
                    request.getSession().setAttribute("personalserie", per);
                    request.getRequestDispatcher("adminpersonal.jsp").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Adminsitrador: Lista de personal para desplegable de añadir series
        }else if(accion.equals("/VerPersonalSeries.htm")) {
            if (sesionadmin != null) {
                Personal[] pers = null;
                MangaBox mb = new MangaBox();
                try {
                    pers = mb.getPersonalSerieCompleto();
                    request.getSession().setAttribute("personalseriecompleto", pers);
                    request.getRequestDispatcher("administrador.jsp").forward(request, response);
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
        //********************Usuario: Ver último capítulo 
        }else if(accion.equals("/VerUltimoCapitulo.htm")) {
            if (sesionusuario != null) {
                String serie = request.getParameter("serie");
                Capitulo capitulo = null;
                MangaBox mb = new MangaBox();
                try {
                    capitulo = mb.getUltimoCapitulo(serie);
                    if (capitulo != null) {
                        request.getSession().setAttribute("usuariocap", capitulo);
                        request.getRequestDispatcher("/VerImagenesUltimoCapitulo.htm").forward(request, response);
                    } else {
                        request.getSession().setAttribute("usuariocap", null);
                        request.getRequestDispatcher("vercapitulo.jsp").forward(request, response);
                    }
                } catch (SQLException ex) {
                    System.out.println("Error SQL");
                }
            } else {
                request.setAttribute("error", "Acción no permitida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
