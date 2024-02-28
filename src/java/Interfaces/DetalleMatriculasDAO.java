package Interfaces;

import Modelo.DetalleMatriculas;
import java.util.List;

public interface DetalleMatriculasDAO {
    DetalleMatriculas obtenerPorId(int id);
    List<DetalleMatriculas> obtenerTodos();
    void agregar(DetalleMatriculas detalleMatricula);
    void actualizar(DetalleMatriculas detalleMatricula);
    void eliminar(int id);
}
