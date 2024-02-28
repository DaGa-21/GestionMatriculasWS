package WS;

import Modelo.Usuarios;
import ModeloDAO.UsuariosDAOImpl;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CRUDUsuarios")
public class CRUDUsuarios {

    UsuariosDAOImpl usuariosDAO = new UsuariosDAOImpl();

    @WebMethod(operationName = "listUsuarios")
    public List<Usuarios> listUsuarios() {
        return usuariosDAO.obtenerTodos();
    }

    @WebMethod(operationName = "listByIdUsuarios")
    public Usuarios listByIdUsuarios(@WebParam(name = "id") int id) {
        return usuariosDAO.obtenerPorId(id);
    }

    @WebMethod(operationName = "addUsuarios")
    public boolean addUsuarios(@WebParam(name = "cedula") String cedula, @WebParam(name = "nombres") String nombres, @WebParam(name = "edad") int edad) {
        Usuarios usuario = new Usuarios();
        usuario.setCedula(cedula);
        usuario.setNombres(nombres);
        usuario.setEdad(edad);

        usuariosDAO.agregar(usuario);

        return true;
    }

    @WebMethod(operationName = "editUsuarios")
    public boolean editUsuarios(@WebParam(name = "id") int id, @WebParam(name = "cedula") String cedula, @WebParam(name = "nombres") String nombres, @WebParam(name = "edad") int edad) {
        Usuarios usuario = new Usuarios();
        usuario.setIDUsuario(id);
        usuario.setCedula(cedula);
        usuario.setNombres(nombres);
        usuario.setEdad(edad);

        usuariosDAO.actualizar(usuario);

        return true;
    }

    @WebMethod(operationName = "deleteUsuarios")
    public boolean deleteUsuarios(@WebParam(name = "id") int id) {
        usuariosDAO.eliminar(id);

        return true;
    }
}
