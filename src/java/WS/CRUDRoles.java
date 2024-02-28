package WS;

import Modelo.Roles;
import ModeloDAO.RolesDAOImpl;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CRUDRoles")
public class CRUDRoles {

    RolesDAOImpl rolesDAO = new RolesDAOImpl();

    @WebMethod(operationName = "listRoles")
    public List<Roles> listRoles() {
        return rolesDAO.obtenerTodos();
    }

    @WebMethod(operationName = "listByIdRoles")
    public Roles listByIdRoles(@WebParam(name = "id") int id) {
        return rolesDAO.obtenerPorId(id);
    }

    @WebMethod(operationName = "addRoles")
    public boolean addRoles(@WebParam(name = "nombre") String nombre, @WebParam(name = "departamento") String departamento) {
        Roles rol = new Roles();
        rol.setNombre(nombre);
        rol.setDepartamento(departamento);

        rolesDAO.agregar(rol);

        return true;
    }

    @WebMethod(operationName = "editRoles")
    public boolean editRoles(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "departamento") String departamento) {
        Roles rol = new Roles();
        rol.setIDRol(id);
        rol.setNombre(nombre);
        rol.setDepartamento(departamento);

        rolesDAO.actualizar(rol);

        return true;
    }

    @WebMethod(operationName = "deleteRoles")
    public boolean deleteRoles(@WebParam(name = "id") int id) {
        rolesDAO.eliminar(id);

        return true;
    }
}
