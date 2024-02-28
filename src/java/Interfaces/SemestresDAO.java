package Interfaces;

import Modelo.Semestres;
import java.util.List;

public interface SemestresDAO {
    Semestres obtenerPorId(int id);
    List<Semestres> obtenerTodos();
    void agregar(Semestres semestre);
    void actualizar(Semestres semestre);
    void eliminar(int id);
}
