package modelo.entidades;

import java.io.Serializable;

/**
 *
 * @author ernesto
 */
public class Personal implements Serializable {
    private String dni;
    private String nombre;
    private String rol;
    private String contraseña;

    public Personal(String dni, String nombre, String rol, String contraseña) {
        this.dni = dni;
        this.nombre = nombre;
        this.rol = rol;
        this.contraseña = contraseña;
    }
    
    public Personal() {
        
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
