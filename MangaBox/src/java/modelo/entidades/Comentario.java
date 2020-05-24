package modelo.entidades;

/**
 *
 * @author ernesto
 */
public class Comentario {
    private Capitulo capitulo;
    private Usuario usuario;
    private String comentario;

    public Comentario(Capitulo capitulo, Usuario usuario, String comentario) {
        this.capitulo = capitulo;
        this.usuario = usuario;
        this.comentario = comentario;
    }

    public int getCapitulo() {
        return capitulo.getId();
    }

    public void setCapitulo(Capitulo capitulo) {
        this.capitulo = capitulo;
    }

    public String getUsuario() {
        String us = usuario.getUsuario();
        return us;
    }
    
    public String getDniUsuario() {
        return usuario.getDni();
    }
    
    public String getFoto() {
        String fo = usuario.getFoto();
        return fo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
}
