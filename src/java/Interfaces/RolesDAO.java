package Interfaces;

import Modelo.Roles;
import java.util.List;

public interface RolesDAO {
    Roles obtenerPorId(int id);
    List<Roles> obtenerTodos();
    void agregar(Roles rol);
    void actualizar(Roles rol);
    void eliminar(int id);
}
