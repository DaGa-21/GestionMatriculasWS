package WS;

import Modelo.Materias;
import ModeloDAO.MateriasDAOImpl;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CRUDMaterias")
public class CRUDMaterias {

    MateriasDAOImpl materiasDAO = new MateriasDAOImpl();

    @WebMethod(operationName = "listMaterias")
    public List<Materias> listMaterias() {
        return materiasDAO.obtenerTodos();
    }

    @WebMethod(operationName = "listByIdMaterias")
    public Materias listByIdMaterias(@WebParam(name = "id") int id) {
        return materiasDAO.obtenerPorId(id);
    }

    @WebMethod(operationName = "addMaterias")
    public boolean addMaterias(@WebParam(name = "nombre") String nombre, @WebParam(name = "abreviatura") String abreviatura, @WebParam(name = "idUsuario") int idUsuario) {
        Materias materia = new Materias();
        materia.setNombre(nombre);
        materia.setAbreviatura(abreviatura);
        materia.setIDUsuario(idUsuario);

        materiasDAO.agregar(materia);

        return true;
    }

    @WebMethod(operationName = "editMaterias")
    public boolean editMaterias(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "abreviatura") String abreviatura, @WebParam(name = "idUsuario") int idUsuario) {
        Materias materia = new Materias();
        materia.setIDMateria(id);
        materia.setNombre(nombre);
        materia.setAbreviatura(abreviatura);
        materia.setIDUsuario(idUsuario);

        materiasDAO.actualizar(materia);

        return true;
    }

    @WebMethod(operationName = "deleteMaterias")
    public boolean deleteMaterias(@WebParam(name = "id") int id) {
        materiasDAO.eliminar(id);

        return true;
    }
}
