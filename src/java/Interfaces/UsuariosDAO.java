package Interfaces;

import Modelo.Usuarios;
import java.util.List;

public interface UsuariosDAO {
    Usuarios obtenerPorId(int id);
    List<Usuarios> obtenerTodos();
    void agregar(Usuarios usuario);
    void actualizar(Usuarios usuario);
    void eliminar(int id);
}
