package Modelo;

public class SemestreMateria {
    private int IDSemestreMateria;
    private int IDSemestre;
    private int IDMateria;

    public SemestreMateria() {
    }

    public SemestreMateria(int IDSemestreMateria, int IDSemestre, int IDMateria) {
        this.IDSemestreMateria = IDSemestreMateria;
        this.IDSemestre = IDSemestre;
        this.IDMateria = IDMateria;
    }
    
    

    // Getters y Setters
    public int getIDSemestreMateria() {
        return IDSemestreMateria;
    }

    public void setIDSemestreMateria(int IDSemestreMateria) {
        this.IDSemestreMateria = IDSemestreMateria;
    }

    public int getIDSemestre() {
        return IDSemestre;
    }

    public void setIDSemestre(int IDSemestre) {
        this.IDSemestre = IDSemestre;
    }

    public int getIDMateria() {
        return IDMateria;
    }

    public void setIDMateria(int IDMateria) {
        this.IDMateria = IDMateria;
    }
}
