package modelo.entidades;

/**
 *
 * @author ernesto
 */
public class Favorito {
    private Usuario usuario;
    private Serie serie;

    public Favorito(Usuario usuario, Serie serie) {
        this.usuario = usuario;
        this.serie = serie;
    }

    public String getUsuario() {
        String us = usuario.getUsuario();
        return us;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getSerie() {
        String nombre = serie.getNombre();
        return nombre;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
}
