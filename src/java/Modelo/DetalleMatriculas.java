package Modelo;

public class DetalleMatriculas {
    private int IDDetalle;
    private int IDMatricula;
    private int IDSemestreMateria;

    public DetalleMatriculas(int IDDetalle, int IDMatricula, int IDSemestreMateria) {
        this.IDDetalle = IDDetalle;
        this.IDMatricula = IDMatricula;
        this.IDSemestreMateria = IDSemestreMateria;
    }

    public DetalleMatriculas() {
    }    
    
    // Getters y Setters
    public int getIDDetalle() {
        return IDDetalle;
    }

    public void setIDDetalle(int IDDetalle) {
        this.IDDetalle = IDDetalle;
    }

    public int getIDMatricula() {
        return IDMatricula;
    }

    public void setIDMatricula(int IDMatricula) {
        this.IDMatricula = IDMatricula;
    }

    public int getIDSemestreMateria() {
        return IDSemestreMateria;
    }

    public void setIDSemestreMateria(int IDSemestreMateria) {
        this.IDSemestreMateria = IDSemestreMateria;
    }

}
