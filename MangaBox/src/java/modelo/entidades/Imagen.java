package modelo.entidades;

import java.io.Serializable;

/**
 *
 * @author ernesto
 */
public class Imagen implements Serializable {
    private String imagen;
    private Capitulo capitulo;

    public Imagen(String imagen, Capitulo capitulo) {
        this.imagen = imagen;
        this.capitulo = capitulo;
    }
    
    public Imagen() {
        
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCapitulo() {
        return capitulo.getId();
    }

    public void setIdcapitulo(Capitulo capitulo) {
        this.capitulo = capitulo;
    }

    @Override
    public String toString() {
        return imagen;
    }
}
