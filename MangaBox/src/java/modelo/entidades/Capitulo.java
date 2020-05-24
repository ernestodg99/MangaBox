package modelo.entidades;

import java.io.Serializable;

/**
 *
 * @author ernesto
 */
public class Capitulo implements Serializable {
    private int id;
    private int capitulonumero;
    private String nombre;
    private String descripcion;
    private Serie nombreserie;
    private Personal administrador;
    private Personal personalserie;
    private boolean visible;

    public Capitulo(int id, int capitulonumero, String nombre, String descripcion, 
            Serie nombreserie, Personal administrador, Personal personalserie, 
            boolean visible) {
        this.id = id;
        this.capitulonumero = capitulonumero;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nombreserie = nombreserie;
        this.administrador = administrador;
        this.personalserie = personalserie;
        this.visible = visible;
    }

    public Capitulo(int capitulonumero, String nombre, String descripcion, Serie nombreserie, 
            Personal administrador, Personal personalserie, 
            boolean visible) {
        this.capitulonumero = capitulonumero;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nombreserie = nombreserie;
        this.administrador = administrador;
        this.personalserie = personalserie;
        this.visible = visible;
    }
    
    public Capitulo() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapituloNumero() {
        return capitulonumero;
    }

    public void setCapituloNumero(int capitulonumero) {
        this.capitulonumero = capitulonumero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreserie() {
        return nombreserie.getNombre();
    }

    public void setNombreserie(Serie nombreserie) {
        this.nombreserie = nombreserie;
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
