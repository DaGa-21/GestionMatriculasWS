package Modelo;

public class Usuarios {
    private int IDUsuario;
    private String Cedula;
    private String Nombres;
    private int Edad;

    public Usuarios() {
    }

    public Usuarios(int IDUsuario, String Cedula, String Nombres, int Edad) {
        this.IDUsuario = IDUsuario;
        this.Cedula = Cedula;
        this.Nombres = Nombres;
        this.Edad = Edad;
    }
    
    

    // Getters y Setters
    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }
}
