package Modelo;

public class Roles {
    private int IDRol;
    private String Nombre;
    private String Departamento;

    public Roles() {
    }

    public Roles(int IDRol, String Nombre, String Departamento) {
        this.IDRol = IDRol;
        this.Nombre = Nombre;
        this.Departamento = Departamento;
    }
    
    

    // Getters y Setters
    public int getIDRol() {
        return IDRol;
    }

    public void setIDRol(int IDRol) {
        this.IDRol = IDRol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }
}
