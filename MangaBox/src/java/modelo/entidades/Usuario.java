package modelo.entidades;

import java.io.Serializable;

/**
 *
 * @author ernesto
 */
public class Usuario implements Serializable{
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private java.sql.Date fecha;
    private String usuario;
    private String contraseña;
    private String foto;

    public Usuario(String dni, String nombre, String apellidos, String email, 
            java.sql.Date fecha, String usuario, String contraseña, String foto) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fecha = fecha;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.foto = foto;
    }
    
    public Usuario() {
        
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.sql.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
