package Modelo;

public class Materias {
    private int IDMateria;
    private String Nombre;
    private String Abreviatura;
    private int IDUsuario;

    public Materias() {
    }

    public Materias(int IDMateria, String Nombre, String Abreviatura, int IDUsuario) {
        this.IDMateria = IDMateria;
        this.Nombre = Nombre;
        this.Abreviatura = Abreviatura;
        this.IDUsuario = IDUsuario;
    }
    
    

    // Getters y Setters
    public int getIDMateria() {
        return IDMateria;
    }

    public void setIDMateria(int IDMateria) {
        this.IDMateria = IDMateria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getAbreviatura() {
        return Abreviatura;
    }

    public void setAbreviatura(String Abreviatura) {
        this.Abreviatura = Abreviatura;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }
}
