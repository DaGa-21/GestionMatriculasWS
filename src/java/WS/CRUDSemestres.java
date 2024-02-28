package WS;

import Modelo.Semestres;
import ModeloDAO.SemestresDAOImpl;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CRUDSemestres")
public class CRUDSemestres {

    SemestresDAOImpl semestresDAO = new SemestresDAOImpl();

    @WebMethod(operationName = "listSemestres")
    public List<Semestres> listSemestres() {
        return semestresDAO.obtenerTodos();
    }

    @WebMethod(operationName = "listByIdSemestres")
    public Semestres listByIdSemestres(@WebParam(name = "id") int id) {
        return semestresDAO.obtenerPorId(id);
    }

    @WebMethod(operationName = "addSemestres")
    public boolean addSemestres(@WebParam(name = "descripcion") String descripcion, @WebParam(name = "malla") String malla) {
        Semestres semestre = new Semestres();
        semestre.setDescripcion(descripcion);
        semestre.setMalla(malla);

        semestresDAO.agregar(semestre);

        return true;
    }

    @WebMethod(operationName = "editSemestres")
    public boolean editSemestres(@WebParam(name = "id") int id, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "malla") String malla) {
        Semestres semestre = new Semestres();
        semestre.setIDSemestre(id);
        semestre.setDescripcion(descripcion);
        semestre.setMalla(malla);

        semestresDAO.actualizar(semestre);

        return true;
    }

    @WebMethod(operationName = "deleteSemestres")
    public boolean deleteSemestres(@WebParam(name = "id") int id) {
        semestresDAO.eliminar(id);

        return true;
    }
}
