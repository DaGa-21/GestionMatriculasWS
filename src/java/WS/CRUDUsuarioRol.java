package WS;

import Modelo.UsuarioRol;
import ModeloDAO.UsuarioRolDAOImpl;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CRUDUsuarioRol")
public class CRUDUsuarioRol {

    UsuarioRolDAOImpl usuarioRolDAO = new UsuarioRolDAOImpl();

    @WebMethod(operationName = "listUsuarioRol")
    public List<UsuarioRol> listUsuarioRol() {
        return usuarioRolDAO.obtenerTodos();
    }

    @WebMethod(operationName = "listByIdUsuarioRol")
    public UsuarioRol listByIdUsuarioRol(@WebParam(name = "id") int id) {
        return usuarioRolDAO.obtenerPorId(id);
    }

    @WebMethod(operationName = "addUsuarioRol")
    public boolean addUsuarioRol(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "idRol") int idRol) {
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setIDUsuario(idUsuario);
        usuarioRol.setIDRol(idRol);

        usuarioRolDAO.agregar(usuarioRol);

        return true;
    }

    @WebMethod(operationName = "editUsuarioRol")
    public boolean editUsuarioRol(@WebParam(name = "id") int id, @WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "idRol") int idRol) {
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setIDUsuarioRol(id);
        usuarioRol.setIDUsuario(idUsuario);
        usuarioRol.setIDRol(idRol);

        usuarioRolDAO.actualizar(usuarioRol);

        return true;
    }

    @WebMethod(operationName = "deleteUsuarioRol")
    public boolean deleteUsuarioRol(@WebParam(name = "id") int id) {
        usuarioRolDAO.eliminar(id);

        return true;
    }
}
