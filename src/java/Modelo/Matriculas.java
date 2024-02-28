package Modelo;

import java.util.Date;

public class Matriculas {
    private int IDMatricula;
    private int IDUsuario;
    private int IDSemestre;
    private Date FechaMatricula;

    public Matriculas() {
    }

    public Matriculas(int IDMatricula, int IDUsuario, int IDSemestre, Date FechaMatricula) {
        this.IDMatricula = IDMatricula;
        this.IDUsuario = IDUsuario;
        this.IDSemestre = IDSemestre;
        this.FechaMatricula = FechaMatricula;
    }
    
    

    // Getters y Setters
    public int getIDMatricula() {
        return IDMatricula;
    }

    public void setIDMatricula(int IDMatricula) {
        this.IDMatricula = IDMatricula;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public int getIDSemestre() {
        return IDSemestre;
    }

    public void setIDSemestre(int IDSemestre) {
        this.IDSemestre = IDSemestre;
    }

    public Date getFechaMatricula() {
        return FechaMatricula;
    }

    public void setFechaMatricula(Date FechaMatricula) {
        this.FechaMatricula = FechaMatricula;
    }
}
