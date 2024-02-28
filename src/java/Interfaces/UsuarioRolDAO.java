package Interfaces;

import Modelo.UsuarioRol;
import java.util.List;

public interface UsuarioRolDAO {
    UsuarioRol obtenerPorId(int id);
    List<UsuarioRol> obtenerTodos();
    void agregar(UsuarioRol usuarioPerfil);
    void actualizar(UsuarioRol usuarioPerfil);
    void eliminar(int id);
}
