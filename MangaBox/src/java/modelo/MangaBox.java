package modelo;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import modelo.entidades.Capitulo;
import modelo.entidades.Comentario;
import modelo.entidades.Favorito;
import modelo.entidades.Imagen;
import modelo.entidades.Personal;
import modelo.entidades.Serie;
import modelo.entidades.Usuario;
import mysql.ConexionBD;

/**
 *
 * @author ernesto
 */
public class MangaBox {
    public Usuario login(String login, String password) {
        String contraseña = "";
        try {
            contraseña = codificarSHA256(password);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error al cifrar contraseña");
        }
        String sql = "SELECT * FROM usuarios WHERE usuario = '" + login 
                + "' AND contraseña = '" + contraseña + "'";
        Connection con = ConexionBD.conecta();
        
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Usuario us = null;
        try {
            while (rs.next()) {
                us = new Usuario(rs.getString("dni"),
                        rs.getString("nombre"), rs.getString("apellidos"),
                        rs.getString("email"), rs.getDate("fechanacimiento"),
                        rs.getString("usuario"), rs.getString("contraseña"), 
                        rs.getString("foto"));
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        return us;
    }
    
    public Usuario getUsuario(String dni) {
        String sql = "SELECT * FROM usuarios WHERE dni = '" + dni + "'";
        Connection con = ConexionBD.conecta();
        
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Usuario usuario = null;
        try {
            while (rs.next()) {
                usuario = new Usuario(rs.getString("dni"),
                        rs.getString("nombre"), rs.getString("apellidos"),
                        rs.getString("email"), rs.getDate("fechanacimiento"),
                        rs.getString("usuario"), rs.getString("contraseña"), 
                        rs.getString("foto"));
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        return usuario;
    }
    
    public Usuario getUsuarioPorNick(String us) {
        String sql = "SELECT * FROM usuarios WHERE usuario = '" + us + "'";
        Connection con = ConexionBD.conecta();
        
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Usuario usuario = null;
        try {
            while (rs.next()) {
                usuario = new Usuario(rs.getString("dni"),
                        rs.getString("nombre"), rs.getString("apellidos"),
                        rs.getString("email"), rs.getDate("fechanacimiento"),
                        rs.getString("usuario"), rs.getString("contraseña"), 
                        rs.getString("foto"));
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        return usuario;
    }
    
    public Favorito getFavorito(Usuario usuario, String serie) {
        String sql = "SELECT * FROM favoritos WHERE usuario = '" 
                + usuario.getUsuario() + "' AND nombreserie = '" + serie + "'";
        Connection con = ConexionBD.conecta();
        
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Favorito favorito = null;
        Usuario us = null;
        Serie ser = null;
        try {
            while (rs.next()) {
                us = getUsuarioPorNick(rs.getString("usuario"));
                ser = getSerie(rs.getString("nombreserie"));
                favorito = new Favorito(us, ser);
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        return favorito;
    }
    
    public void registroUsuarios(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios VALUES ('" 
                + usuario.getDni() + "', '"
                + usuario.getNombre() + "', '"
                + usuario.getApellidos() + "', '"
                + usuario.getEmail() + "', '"
                + usuario.getFecha() + "', '"
                + usuario.getUsuario() + "', '"
                + usuario.getContraseña() + "', '"
                + usuario.getFoto() + "', "
                + true + ")";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void registrarCapitulo(Capitulo capitulo) throws SQLException {
        String sql = "INSERT INTO capitulos (capitulonumero, nombre, descripcion, nombreserie, "
                + "administrador, personalserie, visible) VALUES ("
                + capitulo.getCapituloNumero() + ", '"
                + capitulo.getNombre() + "', '"
                + capitulo.getDescripcion() + "', '"
                + capitulo.getNombreserie() + "', '"
                + capitulo.getAdministrador() + "', '"
                + capitulo.getPersonalserie() + "', "
                + capitulo.isVisible() + ")";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void registroPersonal(Personal per) throws SQLException {
        String sql = "INSERT INTO personal VALUES ('" 
                + per.getDni() + "', '"
                + per.getNombre() + "', '"
                + per.getRol() + "', '"
                + per.getContraseña() + "')";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void registrarSerie(Serie serie) throws SQLException {
        String sql = "INSERT INTO series VALUES ('" 
                + serie.getNombre() + "', '"
                + serie.getAutor() + "', '"
                + serie.getCategoria() + "', "
                + null + ", "
                + null + ", "
                + null + ", "
                + null + ", '"
                + serie.getAdministrador() + "', '"
                + serie.getPersonalserie() + "', "
                + serie.isVisible() + ")";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void registrarComentario(Comentario comentario) throws SQLException {
        String sql = "INSERT INTO comentarios (idcapitulo, usuario, comentario) "
                + "VALUES (" 
                + comentario.getCapitulo() + ", '"
                + comentario.getUsuario()+ "', '"
                + comentario.getComentario() + "')";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void registrarFavorito(Favorito favorito) throws SQLException {
        String sql = "INSERT INTO favoritos (nombreserie, usuario) "
                + "VALUES ('" 
                + favorito.getSerie() + "', '"
                + favorito.getUsuario()+ "')";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void eliminarFavorito(Favorito favorito) throws SQLException {
        String sql = "DELETE FROM favoritos WHERE nombreserie = '" 
                + favorito.getSerie() + "' AND usuario = '"
                + favorito.getUsuario() + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public Personal buscarPersonal(String dni, String password) {
        String sql = "SELECT * FROM personal WHERE dni = '" + dni 
                + "' AND contraseña = '" + password + "'";
        Connection con = ConexionBD.conecta();
        
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Personal per = null;
        try {
            while (rs.next()) {
                per = new Personal(rs.getString("dni"),
                        rs.getString("nombre"), rs.getString("rol"),
                        rs.getString("contraseña"));
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        return per;
    }
    
    public Personal buscarPersonalPorDni(String dni) {
        String sql = "SELECT * FROM personal WHERE dni = '" + dni + "'";
        Connection con = ConexionBD.conecta();
        
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Personal per = null;
        try {
            while (rs.next()) {
                per = new Personal(rs.getString("dni"),
                        rs.getString("nombre"), rs.getString("rol"),
                        rs.getString("contraseña"));
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        return per;
    }
    
    public ArrayList<String> buscarSeries(String nombre) throws SQLException {
        ArrayList<String> series = new ArrayList<>();
        String sql = "SELECT * FROM series WHERE nombre like '" 
                + nombre + "%' LIMIT 5";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        try {
            while (rs.next()) {
                series.add(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
            con.close();
        return series;
    }
    
    public Personal getAdministrador() {
        String sql = "SELECT * FROM personal WHERE rol = 'Administrador'";
        Connection con = ConexionBD.conecta();
        
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Personal administrador = null;
        try {
            while (rs.next()) {
                administrador = new Personal(rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("rol"), 
                        rs.getString("contraseña"));
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        return administrador;
    }
    
    public Personal getPersonal(String dni) {
        String sql = "SELECT * FROM personal WHERE dni = '" + dni + "'";
        Connection con = ConexionBD.conecta();
        
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Personal administrador = null;
        try {
            while (rs.next()) {
                administrador = new Personal(rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("rol"), 
                        rs.getString("contraseña"));
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        return administrador;
    }
    
    public Personal getPersonalSerie(String serie) throws SQLException {
        String sql = "SELECT personal.* FROM series JOIN personal ON "
                + "series.personalserie = personal.dni WHERE "
                + "series.nombre = '" + serie + "'";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Personal per = null;
        try {
            while (rs.next()) {
                per = new Personal(rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("rol"), 
                        rs.getString("contraseña"));
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
            con.close();
        return per;
    }
    
    public Personal[] getPersonalSerieCompleto() throws SQLException {
        String sql = "SELECT personal.* FROM personal WHERE dni NOT IN "
                + "(SELECT series.personalserie FROM series) "
                + "AND rol != 'Administrador'";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Personal[] pers = new Personal[100];
        Personal per = null;
        int contador = 0;
        try {
            while (rs.next()) {
                per = new Personal(rs.getString("dni"),
                        rs.getString("nombre"), rs.getString("rol"),
                        rs.getString("contraseña"));
                //vehiculo.setDueño(dni);
                pers[contador] = per;
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        pers = Arrays.copyOf(pers, contador);
            con.close();
        return pers;
    }
    
    public Serie[] getSeries() throws SQLException {
        String sql = "SELECT * FROM series WHERE visible = true";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Serie[] series = new Serie[100];
        Serie serie = null;
        Personal administrador = null;
        Personal personalserie = null;
        int contador = 0;
        try {
            while (rs.next()) {
                administrador = buscarPersonalPorDni(rs.getString("administrador"));
                personalserie = buscarPersonalPorDni(rs.getString("personalserie"));
                serie = new Serie(rs.getString("nombre"),
                        rs.getString("autor"),
                        rs.getString("categoria"), 
                        rs.getString("logo"),
                        rs.getString("logo2"),
                        rs.getString("descripcion"),
                        rs.getString("fechaserializacion"),
                        administrador,
                        personalserie,
                        rs.getBoolean("visible"));
                series[contador] = serie;
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        series = Arrays.copyOf(series, contador);
            con.close();
        return series;
    }
    
    public Serie[] getSeriesMenores() throws SQLException {
        String sql = "SELECT * FROM series WHERE categoria != 'josei' AND "
                + "categoria != 'seinen' AND visible = true";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Serie[] series = new Serie[100];
        Serie serie = null;
        Personal administrador = null;
        Personal personalserie = null;
        int contador = 0;
        try {
            while (rs.next()) {
                administrador = buscarPersonalPorDni(rs.getString("administrador"));
                personalserie = buscarPersonalPorDni(rs.getString("personalserie"));
                serie = new Serie(rs.getString("nombre"),
                        rs.getString("autor"),
                        rs.getString("categoria"), 
                        rs.getString("logo"),
                        rs.getString("logo2"),
                        rs.getString("descripcion"),
                        rs.getString("fechaserializacion"),
                        administrador,
                        personalserie,
                        rs.getBoolean("visible"));
                series[contador] = serie;
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        series = Arrays.copyOf(series, contador);
            con.close();
        return series;
    }
    
    public Serie[] buscarSeriesMenores(String nombre) throws SQLException {
        String sql = "SELECT * FROM series WHERE nombre LIKE '" + nombre 
                + "' AND categoria != 'josei' AND "
                + "categoria != 'seinen' AND visible = true";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Serie[] series = new Serie[100];
        Serie serie = null;
        Personal administrador = null;
        Personal personalserie = null;
        int contador = 0;
        try {
            while (rs.next()) {
                administrador = buscarPersonalPorDni(rs.getString("administrador"));
                personalserie = buscarPersonalPorDni(rs.getString("personalserie"));
                serie = new Serie(rs.getString("nombre"),
                        rs.getString("autor"),
                        rs.getString("categoria"), 
                        rs.getString("logo"),
                        rs.getString("logo2"),
                        rs.getString("descripcion"),
                        rs.getString("fechaserializacion"),
                        administrador,
                        personalserie,
                        rs.getBoolean("visible"));
                series[contador] = serie;
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        series = Arrays.copyOf(series, contador);
            con.close();
        return series;
    }
    
    public Serie[] buscarSeriesMayores(String nombre) throws SQLException {
        String sql = "SELECT * FROM series WHERE nombre LIKE '" + nombre 
                + "' AND visible = true";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Serie[] series = new Serie[100];
        Serie serie = null;
        Personal administrador = null;
        Personal personalserie = null;
        int contador = 0;
        try {
            while (rs.next()) {
                administrador = buscarPersonalPorDni(rs.getString("administrador"));
                personalserie = buscarPersonalPorDni(rs.getString("personalserie"));
                serie = new Serie(rs.getString("nombre"),
                        rs.getString("autor"),
                        rs.getString("categoria"), 
                        rs.getString("logo"),
                        rs.getString("logo2"),
                        rs.getString("descripcion"),
                        rs.getString("fechaserializacion"),
                        administrador,
                        personalserie,
                        rs.getBoolean("visible"));
                series[contador] = serie;
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        series = Arrays.copyOf(series, contador);
            con.close();
        return series;
    }
    
    public Serie[] getSeriesAdministrador() throws SQLException {
        String sql = "SELECT * FROM series";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Serie[] series = new Serie[100];
        Serie serie = null;
        Personal administrador = null;
        Personal personalserie = null;
        int contador = 0;
        try {
            while (rs.next()) {
                administrador = buscarPersonalPorDni(rs.getString("administrador"));
                personalserie = buscarPersonalPorDni(rs.getString("personalserie"));
                serie = new Serie(rs.getString("nombre"),
                        rs.getString("autor"),
                        rs.getString("categoria"), 
                        rs.getString("logo"),
                        rs.getString("logo2"),
                        rs.getString("descripcion"),
                        rs.getString("fechaserializacion"),
                        administrador,
                        personalserie,
                        rs.getBoolean("visible"));
                series[contador] = serie;
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        series = Arrays.copyOf(series, contador);
            con.close();
        return series;
    }
    
    public Serie getSerie(String nombre) throws SQLException {
        String sql = "SELECT * FROM series WHERE nombre = '" + nombre + "'";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Serie serie = null;
        Personal administrador = null;
        Personal personalserie = null;
        try {
            while (rs.next()) {
                administrador = buscarPersonalPorDni(rs.getString("administrador"));
                personalserie = buscarPersonalPorDni(rs.getString("personalserie"));
                serie = new Serie(rs.getString("nombre"),
                        rs.getString("autor"),
                        rs.getString("categoria"), 
                        rs.getString("logo"),
                        rs.getString("logo2"),
                        rs.getString("descripcion"),
                        rs.getString("fechaserializacion"),
                        administrador,
                        personalserie,
                        rs.getBoolean("visible"));
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        return serie;
    }
    
    public Serie getSeriePersonal(String dni) throws SQLException {
        String sql = "SELECT * FROM series WHERE personalserie = '" + dni + "'";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Serie serie = null;
        Personal administrador = null;
        Personal personalserie = null;
        try {
            while (rs.next()) {
                administrador = buscarPersonalPorDni(rs.getString("administrador"));
                personalserie = buscarPersonalPorDni(rs.getString("personalserie"));
                serie = new Serie(rs.getString("nombre"),
                        rs.getString("autor"),
                        rs.getString("categoria"), 
                        rs.getString("logo"),
                        rs.getString("logo2"),
                        rs.getString("descripcion"),
                        rs.getString("fechaserializacion"),
                        administrador,
                        personalserie,
                        rs.getBoolean("visible"));
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        return serie;
    }
    
    public Capitulo getCapitulo(int idcapitulo, String nombreserie) throws SQLException {
        String sql = "SELECT * FROM capitulos WHERE idcapitulo = " + idcapitulo
                + " AND nombreserie = '" + nombreserie + "'";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Capitulo capitulo = null;
        Serie serie = null;
        Personal administrador = null;
        Personal personalserie = null;
        int contador = 0;
        try {
            while (rs.next()) {
                serie = getSerie(rs.getString("nombreserie"));
                administrador = buscarPersonalPorDni(rs.getString("administrador"));
                personalserie = buscarPersonalPorDni(rs.getString("personalserie"));
                capitulo = new Capitulo(rs.getInt("idcapitulo"),
                        rs.getInt("capitulonumero"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        serie,
                        administrador,
                        personalserie,
                        rs.getBoolean("visible"));
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
            con.close();
        return capitulo;
    }
    
    public Capitulo getCapituloPorId(int idcapitulo) throws SQLException {
        String sql = "SELECT * FROM capitulos WHERE idcapitulo = " + idcapitulo;
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Capitulo capitulo = null;
        Serie serie = null;
        Personal administrador = null;
        Personal personalserie = null;
        int contador = 0;
        try {
            while (rs.next()) {
                serie = getSerie(rs.getString("nombreserie"));
                administrador = buscarPersonalPorDni(rs.getString("administrador"));
                personalserie = buscarPersonalPorDni(rs.getString("personalserie"));
                capitulo = new Capitulo(rs.getInt("idcapitulo"),
                        rs.getInt("capitulonumero"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        serie,
                        administrador,
                        personalserie,
                        rs.getBoolean("visible"));
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
            con.close();
        return capitulo;
    }
    
    public Capitulo getUltimoCapitulo(String ser) throws SQLException {
        String sql = "SELECT * FROM capitulos WHERE nombreserie = '" + ser 
                + "' AND visible = true ORDER BY idcapitulo DESC LIMIT 1 ";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Capitulo capitulo = null;
        Serie serie = null;
        Personal administrador = null;
        Personal personalserie = null;
        try {
            while (rs.next()) {
                serie = getSerie(rs.getString("nombreserie"));
                administrador = buscarPersonalPorDni(rs.getString("administrador"));
                personalserie = buscarPersonalPorDni(rs.getString("personalserie"));
                capitulo = new Capitulo(rs.getInt("idcapitulo"),
                        rs.getInt("capitulonumero"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        serie,
                        administrador,
                        personalserie,
                        rs.getBoolean("visible"));
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
            con.close();
        return capitulo;
    }
    
    public Capitulo[] getCapitulosAdmin(String nombre) throws SQLException {
        String sql = "SELECT * FROM capitulos WHERE nombreserie = '" + nombre + "'";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Capitulo[] capitulos = new Capitulo[300];
        Capitulo capitulo = null;
        int contador = 0;
        Serie serie = null;
        Personal administrador = null;
        Personal personalserie = null;
        try {
            while (rs.next()) {
                serie = getSerie(rs.getString("nombreserie"));
                administrador = buscarPersonalPorDni(rs.getString("administrador"));
                personalserie = buscarPersonalPorDni(rs.getString("personalserie"));
                capitulo = new Capitulo(rs.getInt("idcapitulo"),
                        rs.getInt("capitulonumero"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        serie,
                        administrador,
                        personalserie,
                        rs.getBoolean("visible"));
                capitulos[contador] = capitulo;
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        capitulos = Arrays.copyOf(capitulos, contador);
            con.close();
        return capitulos;
    }
    
    public Capitulo[] getCapitulosPersonal(String nombre) throws SQLException {
        String sql = "SELECT * FROM capitulos WHERE nombreserie = '" + nombre + "'";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Capitulo[] capitulos = new Capitulo[300];
        Capitulo capitulo = null;
        int contador = 0;
        Serie serie = null;
        Personal administrador = null;
        Personal personalserie = null;
        try {
            while (rs.next()) {
                serie = getSerie(rs.getString("nombreserie"));
                administrador = buscarPersonalPorDni(rs.getString("administrador"));
                personalserie = buscarPersonalPorDni(rs.getString("personalserie"));
                capitulo = new Capitulo(rs.getInt("idcapitulo"),
                        rs.getInt("capitulonumero"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        serie,
                        administrador,
                        personalserie,
                        rs.getBoolean("visible"));
                capitulos[contador] = capitulo;
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        capitulos = Arrays.copyOf(capitulos, contador);
            con.close();
        return capitulos;
    }
    
    public Capitulo[] getCapitulos(String serie) throws SQLException {
        String sql = "SELECT * FROM capitulos WHERE nombreserie = '" + serie 
                + "' AND visible = true";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Capitulo[] capitulos = new Capitulo[10];
        Capitulo capitulo = null;
        int contador = 0;
        Serie ser = null;
        Personal administrador = null;
        Personal personalserie = null;
        try {
            while (rs.next()) {
                ser = getSerie(rs.getString("nombreserie"));
                administrador = buscarPersonalPorDni(rs.getString("administrador"));
                personalserie = buscarPersonalPorDni(rs.getString("personalserie"));
                capitulo = new Capitulo(rs.getInt("idcapitulo"),
                        rs.getInt("capitulonumero"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"), 
                        ser,
                        administrador,
                        personalserie,
                        rs.getBoolean("visible"));
                capitulos[contador] = capitulo;
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        capitulos = Arrays.copyOf(capitulos, contador);
            con.close();
        return capitulos;
    }
    
    public Capitulo comprobarCapitulo(String nombreserie, int capitulonumero) throws SQLException {
        String sql = "SELECT * FROM capitulos WHERE capitulonumero = " + capitulonumero
                + " AND nombreserie = '" + nombreserie + "'";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Capitulo capitulo = null;
        Serie serie = null;
        Personal administrador = null;
        Personal personalserie = null;
        int contador = 0;
        try {
            while (rs.next()) {
                serie = getSerie(rs.getString("nombreserie"));
                administrador = buscarPersonalPorDni(rs.getString("administrador"));
                personalserie = buscarPersonalPorDni(rs.getString("personalserie"));
                capitulo = new Capitulo(rs.getInt("idcapitulo"),
                        rs.getInt("capitulonumero"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        serie,
                        administrador,
                        personalserie,
                        rs.getBoolean("visible"));
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
            con.close();
        return capitulo;
    }
    
    public Imagen[] getImagenes(int idcapitulo) throws SQLException {
        String sql = "SELECT * FROM imagenes WHERE idcapitulo = " + idcapitulo;
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Imagen[] imgs = new Imagen[100];
        Imagen img = null;
        int contador = 0;
        Capitulo cap = null;
        try {
            while (rs.next()) {
                cap = getCapituloPorId(rs.getInt("idcapitulo"));
                img = new Imagen(rs.getString("imagen"), cap);
                imgs[contador] = img;
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        imgs = Arrays.copyOf(imgs, contador);
            con.close();
        return imgs;
    }
    
    public Comentario[] getComentarios(int idcapitulo) throws SQLException {
        String sql = "SELECT * FROM comentarios WHERE idcapitulo = " + idcapitulo;
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Comentario[] comentarios = new Comentario[100];
        Comentario comentario = null;
        Usuario usuario = null;
        Capitulo cap = null;
        int contador = 0;

        try {
            while (rs.next()) {
                //Fallo aquí porque no busco a usuario por dni, sino por su nombre de usuario
                usuario = getUsuarioPorNick(rs.getString("usuario"));
                cap = getCapituloPorId(rs.getInt("idcapitulo"));
                comentario = new Comentario(cap, usuario, rs.getString("comentario"));
                comentarios[contador] = comentario;
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        comentarios = Arrays.copyOf(comentarios, contador);
            con.close();
        return comentarios;
    }
    
    public Comentario getComentario(int idcapitulo, Usuario us) throws SQLException {
        String sql = "SELECT * FROM comentarios WHERE idcapitulo = " 
                + idcapitulo + " AND usuario = '" + us.getUsuario() 
                + "' ORDER BY id DESC limit 1";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Comentario comentario = null;
        Usuario usuario = null;
        Capitulo cap = null;
        int contador = 0;

        try {
            while (rs.next()) {
                //Fallo aquí porque no busco a usuario por dni, sino por su nombre de usuario
                usuario = getUsuarioPorNick(rs.getString("usuario"));
                cap = getCapituloPorId(rs.getInt("idcapitulo"));
                comentario = new Comentario(cap, usuario, rs.getString("comentario"));
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
            con.close();
        return comentario;
    }
    
    public Serie[] getFavoritos(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM series JOIN favoritos ON series.nombre = "
                + "favoritos.nombreserie WHERE favoritos.usuario = '" 
                + usuario.getUsuario() + "'";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        Serie[] series = new Serie[100];
        Serie serie = null;
        Personal administrador = null;
        Personal personalserie = null;
        int contador = 0;
        try {
            while (rs.next()) {
                administrador = buscarPersonalPorDni(rs.getString("administrador"));
                personalserie = buscarPersonalPorDni(rs.getString("personalserie"));
                serie = new Serie(rs.getString("nombre"),
                        rs.getString("autor"),
                        rs.getString("categoria"), 
                        rs.getString("logo"),
                        rs.getString("logo2"),
                        rs.getString("descripcion"),
                        rs.getString("fechaserializacion"),
                        administrador,
                        personalserie,
                        rs.getBoolean("visible"));
                series[contador] = serie;
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        series = Arrays.copyOf(series, contador);
            con.close();
        return series;
    }
    
    public String[] getEmailsFavoritos(String serie) throws SQLException {
        String sql = "SELECT usuarios.email AS 'email' FROM favoritos JOIN usuarios ON "
                + "favoritos.usuario = usuarios.usuario WHERE favoritos.nombreserie = '" 
                + serie + "'";
        Connection con = ConexionBD.conecta();
        ResultSet rs = ConexionBD.ejecutar(con, sql);
        String[] emails = new String[100];
        String email = "";
        int contador = 0;
        try {
            while (rs.next()) {
                email = rs.getString("email");
                emails[contador] = email;
                contador++;
            }
        } catch (SQLException ex) {
            System.out.println("Algo mal.");
        }
        emails = Arrays.copyOf(emails, contador);
            con.close();
        return emails;
    }
    
    public void setFoto(String nombre, String foto) throws SQLException {
        String sql = "UPDATE series SET logo = '" + foto 
                + "' WHERE nombre = '" + nombre + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setFoto2(String nombre, String foto) throws SQLException {
        String sql = "UPDATE series SET logo2 = '" + foto 
                + "' WHERE nombre = '" + nombre + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void eliminarLogo(String nombre) throws SQLException {
        String sql = "UPDATE series SET logo = null "
                + "WHERE nombre = '" + nombre + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void eliminarLogo2(String nombre) throws SQLException {
        String sql = "UPDATE series SET logo2 = null "
                + "WHERE nombre = '" + nombre + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void eliminarDescripcion(String nombre) throws SQLException {
        String sql = "UPDATE series SET descripcion = null "
                + "WHERE nombre = '" + nombre + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void eliminarFecha(String nombre) throws SQLException {
        String sql = "UPDATE series SET fechaserializacion = null "
                + "WHERE nombre = '" + nombre + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void eliminarSerie(String nombre) throws SQLException {
        String sql = "DELETE FROM series WHERE nombre = '" + nombre + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void eliminarCapitulo(int idcapitulo) throws SQLException {
        String sql = "DELETE FROM capitulos WHERE idcapitulo = " + idcapitulo;
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setImagen(int idcapitulo, String imagen) throws SQLException {
        String sql = "INSERT INTO imagenes (imagen, idcapitulo) VALUES ('"
                + imagen + "', " 
                + idcapitulo + ")";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setDescripcion(String descripcion, String nombreserie) throws SQLException {
        String sql = "UPDATE series SET descripcion = '" + descripcion 
                + "' WHERE nombre = '" + nombreserie + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setFecha(String fecha, String nombreserie) throws SQLException {
        String sql = "UPDATE series SET fechaserializacion = '" + fecha 
                + "' WHERE nombre = '" + nombreserie + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setNombreUsuario(String nombre, String dni) throws SQLException {
        String sql = "UPDATE usuarios SET nombre = '" + nombre 
                + "' WHERE dni = '" + dni + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setNombreAdmin(String nombre, String dni) throws SQLException {
        String sql = "UPDATE personal SET nombre = '" + nombre 
                + "' WHERE dni = '" + dni + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setNombrePersonal(String nombre, String dni) throws SQLException {
        String sql = "UPDATE personal SET nombre = '" + nombre 
                + "' WHERE dni = '" + dni + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setApellidosUsuario(String apellidos, String dni) throws SQLException {
        String sql = "UPDATE usuarios SET apellidos = '" + apellidos 
                + "' WHERE dni = '" + dni + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setEmailUsuario(String email, String dni) throws SQLException {
        String sql = "UPDATE usuarios SET email = '" + email 
                + "' WHERE dni = '" + dni + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setContraseñaUsuario(String contraseña, String dni) throws SQLException {
        String sql = "UPDATE usuarios SET contraseña = '" + contraseña 
                + "' WHERE dni = '" + dni + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setContraseñaAdmin(String contraseña, String dni) throws SQLException {
        String sql = "UPDATE personal SET contraseña = '" + contraseña 
                + "' WHERE dni = '" + dni + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setContraseñaPersonal(String contraseña, String dni) throws SQLException {
        String sql = "UPDATE personal SET contraseña = '" + contraseña 
                + "' WHERE dni = '" + dni + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setFotoUsuario(String foto, String dni) throws SQLException {
        String sql = "UPDATE usuarios SET foto = '" + foto 
                + "' WHERE dni = '" + dni + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setVisible(String nombreserie) throws SQLException {
        String sql = "UPDATE series SET visible = true WHERE nombre = '" 
                + nombreserie + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setNoVisible(String nombreserie) throws SQLException {
        String sql = "UPDATE series SET visible = false WHERE nombre = '" 
                + nombreserie + "'";
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setVisibleCapitulo(int id) throws SQLException {
        String sql = "UPDATE capitulos SET visible = true WHERE idcapitulo = " 
                + id;
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public void setNoVisibleCapitulo(int id) throws SQLException {
        String sql = "UPDATE capitulos SET visible = false WHERE idcapitulo = " 
                + id;
        Connection con = ConexionBD.conecta();
        ConexionBD.ejecutaUpdate(con, sql); 
        con.close();
    }
    
    public String codificarSHA256(String mensaje) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(mensaje.getBytes(StandardCharsets.UTF_8));
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(hash[i] & 0xff);
            if (hex.length() == 1) {
                hexString.append("0");
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
