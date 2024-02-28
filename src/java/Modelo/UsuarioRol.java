package Modelo;

public class UsuarioRol {
    private int IDUsuarioRol;
    private int IDUsuario;
    private int IDRol;

    public UsuarioRol() {
    }

    public UsuarioRol(int IDUsuarioRol, int IDUsuario, int IDRol) {
        this.IDUsuarioRol = IDUsuarioRol;
        this.IDUsuario = IDUsuario;
        this.IDRol = IDRol;
    }
    
    

    // Getters y Setters
    public int getIDUsuarioRol() {
        return IDUsuarioRol;
    }

    public void setIDUsuarioRol(int IDUsuarioRol) {
        this.IDUsuarioRol = IDUsuarioRol;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public int getIDRol() {
        return IDRol;
    }

    public void setIDRol(int IDRol) {
        this.IDRol = IDRol;
    }
}
