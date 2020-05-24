package modelo.entidades;

import java.io.Serializable;

/**
 *
 * @author ernesto
 */
public class Serie implements Serializable {
    private String nombre;
    private String autor;
    private String categoria;
    private String logo;
    private String logo2;
    private String descripcion;
    private String fechaserializacion;
    private Personal administrador;
    private Personal personalserie;
    private boolean visible;

    public Serie(String nombre, String autor, String categoria, String logo, 
            String logo2, String descripcion, String fechaserializacion, Personal administrador,
            Personal personalserie, boolean visible) {
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.logo = logo;
        this.logo2 = logo2;
        this.descripcion = descripcion;
        this.fechaserializacion = fechaserializacion;
        this.administrador = administrador;
        this.personalserie = personalserie;
        this.visible = visible;
    }
    
    public Serie() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    public String getLogo2() {
        return logo2;
    }

    public void setLogo2(String logo2) {
        this.logo2 = logo2;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaSerializacion() {
        return fechaserializacion;
    }

    public void setFechaSerializacion(String fechaserializacion) {
        this.fechaserializacion = fechaserializacion;
    }

    public String getAdministrador() {
        return administrador.getDni();
    }

    public void setAdministrador(Personal administrador) {
        this.administrador = administrador;
    }

    public String getPersonalserie() {
        return personalserie.getDni();
    }

    public void setPersonalserie(Personal personalserie) {
        this.personalserie = personalserie;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
