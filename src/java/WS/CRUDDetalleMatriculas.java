package WS;

import Modelo.DetalleMatriculas;
import ModeloDAO.DetalleMatriculasDAOImpl;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CRUDDetalleMatriculas")
public class CRUDDetalleMatriculas {

    DetalleMatriculasDAOImpl detalleMatriculasDAO = new DetalleMatriculasDAOImpl();

    @WebMethod(operationName = "listDetalleMatriculas")
    public List<DetalleMatriculas> listDetalleMatriculas() {
        return detalleMatriculasDAO.obtenerTodos();
    }

    @WebMethod(operationName = "listByIdDetalleMatriculas")
    public DetalleMatriculas listByIdDetalleMatriculas(@WebParam(name = "id") int id) {
        return detalleMatriculasDAO.obtenerPorId(id);
    }

    @WebMethod(operationName = "addDetalleMatriculas")
    public boolean addDetalleMatriculas(@WebParam(name = "idMatricula") int idMatricula, @WebParam(name = "idSSemestreMateria") int idSemestreMateria) {
        DetalleMatriculas detalleMatricula = new DetalleMatriculas();
        detalleMatricula.setIDMatricula(idMatricula);
        detalleMatricula.setIDSemestreMateria(idSemestreMateria);

        detalleMatriculasDAO.agregar(detalleMatricula);

        return true;
    }

    @WebMethod(operationName = "editDetalleMatriculas")
    public boolean editDetalleMatriculas(@WebParam(name = "id") int id, @WebParam(name = "idMatricula") int idMatricula, @WebParam(name = "idSemestreMateria") int idSemestreMateria) {
        DetalleMatriculas detalleMatricula = new DetalleMatriculas();
        detalleMatricula.setIDDetalle(id);
        detalleMatricula.setIDMatricula(idMatricula);
        detalleMatricula.setIDSemestreMateria(idSemestreMateria);

        detalleMatriculasDAO.actualizar(detalleMatricula);

        return true;
    }

    @WebMethod(operationName = "deleteDetalleMatriculas")
    public boolean deleteDetalleMatriculas(@WebParam(name = "id") int id) {
        detalleMatriculasDAO.eliminar(id);

        return true;
    }
}
