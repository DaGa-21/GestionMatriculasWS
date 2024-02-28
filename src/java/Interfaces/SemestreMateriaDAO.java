package Interfaces;

import Modelo.SemestreMateria;
import java.util.List;

public interface SemestreMateriaDAO {
    SemestreMateria obtenerPorId(int id);
    List<SemestreMateria> obtenerTodos();
    void agregar(SemestreMateria semestreMateria);
    void actualizar(SemestreMateria semestreMateria);
    void eliminar(int id);
}
