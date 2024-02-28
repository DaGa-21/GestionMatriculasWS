package Interfaces;

import Modelo.MatriculaInfo;
import Modelo.Matriculas;
import java.util.List;

public interface MatriculasDAO {
    Matriculas obtenerPorId(int id);
    List<Matriculas> obtenerTodos();
    int agregar(Matriculas matricula);
    void actualizar(Matriculas matricula);
    void eliminar(int id);
    
    List<MatriculaInfo> obtenerMatriculasPorCedula(String cedula);
}
