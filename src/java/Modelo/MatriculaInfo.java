
package Modelo;

import java.util.Date;

public class MatriculaInfo {
    private int IDMatricula;
    private int IDUsuario;
    private int IDSemestre;
    private Date FechaMatricula;
    private String NombreMateria;
    private String NombreProfesor;
    private String DescripcionSemestre;
    private String NombreUsuario;

    public MatriculaInfo() {
    }

    public MatriculaInfo(int IDMatricula, int IDUsuario, int IDSemestre, Date FechaMatricula, String NombreMateria, String NombreProfesor, String DescripcionSemestre, String NombreUsuario) {
        this.IDMatricula = IDMatricula;
        this.IDUsuario = IDUsuario;
        this.IDSemestre = IDSemestre;
        this.FechaMatricula = FechaMatricula;
        this.NombreMateria = NombreMateria;
        this.NombreProfesor = NombreProfesor;
        this.DescripcionSemestre = DescripcionSemestre;
        this.NombreUsuario = NombreUsuario;
    }
    
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

    public String getNombreMateria() {
        return NombreMateria;
    }

    public void setNombreMateria(String NombreMateria) {
        this.NombreMateria = NombreMateria;
    }

    public String getNombreProfesor() {
        return NombreProfesor;
    }

    public void setNombreProfesor(String NombreProfesor) {
        this.NombreProfesor = NombreProfesor;
    }

    public String getDescripcionSemestre() {
        return DescripcionSemestre;
    }

    public void setDescripcionSemestre(String DescripcionSemestre) {
        this.DescripcionSemestre = DescripcionSemestre;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }
      
}
