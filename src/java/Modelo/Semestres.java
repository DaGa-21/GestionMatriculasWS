package Modelo;

public class Semestres {
    private int IDSemestre;
    private String Descripcion;
    private String Malla;

    public Semestres() {
    }

    public Semestres(int IDSemestre, String Descripcion, String Malla) {
        this.IDSemestre = IDSemestre;
        this.Descripcion = Descripcion;
        this.Malla = Malla;
    }
    
    

    // Getters y Setters
    public int getIDSemestre() {
        return IDSemestre;
    }

    public void setIDSemestre(int IDSemestre) {
        this.IDSemestre = IDSemestre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getMalla() {
        return Malla;
    }

    public void setMalla(String Malla) {
        this.Malla = Malla;
    }
}
