package Interfaces;

import Modelo.Materias;
import java.util.List;

public interface MateriasDAO {
    Materias obtenerPorId(int id);
    List<Materias> obtenerTodos();
    void agregar(Materias materia);
    void actualizar(Materias materia);
    void eliminar(int id);
}
