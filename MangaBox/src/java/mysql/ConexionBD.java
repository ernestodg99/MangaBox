package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.TimeZone;

/**
 *
 * @author ernesto
 */
public class ConexionBD {
    
    public static Connection conecta() {
    Connection conecta=null; 
        try {
            //jdbc:mysql://127.0.0.1/db?serverTimezone="+TimeZone.getDefault().getID()
            Class.forName("com.mysql.jdbc.Driver"); 
            String servidor="jdbc:mysql://localhost/mangabox?serverTimezone="+TimeZone.getDefault().getID();
            String usuario="root";
            String contrasenia="";
            conecta=(Connection)DriverManager.getConnection(servidor, usuario, contrasenia);
        } catch(ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch(Exception ex) {
            System.out.println(ex.getMessage());                
        } finally {
            return conecta;
        }
    }
    
    public static ResultSet ejecutar(Connection con, String sql) {
        ResultSet rs = null;

        Statement sentencia;
        try {
            sentencia = con.createStatement();
            rs = sentencia.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println("Error SQL");
            System.out.println(ex);
        }

        return rs;
    }

    public static void ejecutaUpdate(Connection con, String sql) {
        Statement sentencia;

        try {
            sentencia = con.createStatement();
            sentencia.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("Error SQL");
            System.out.println(ex);
        }
    }
}

