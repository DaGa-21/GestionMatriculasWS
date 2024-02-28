package WS;

import Modelo.SemestreMateria;
import ModeloDAO.SemestreMateriaDAOImpl;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CRUDSemestreMateria")
public class CRUDSemestreMateria {

    SemestreMateriaDAOImpl semestreMateriaDAO = new SemestreMateriaDAOImpl();

    @WebMethod(operationName = "listSemestreMateria")
    public List<SemestreMateria> listSemestreMateria() {
        return semestreMateriaDAO.obtenerTodos();
    }

    @WebMethod(operationName = "listByIdSemestreMateria")
    public SemestreMateria listByIdSemestreMateria(@WebParam(name = "id") int id) {
        return semestreMateriaDAO.obtenerPorId(id);
    }

    @WebMethod(operationName = "addSemestreMateria")
    public boolean addSemestreMateria(@WebParam(name = "idSemestre") int idSemestre, @WebParam(name = "idMateria") int idMateria) {
        SemestreMateria semestreMateria = new SemestreMateria();
        semestreMateria.setIDSemestre(idSemestre);
        semestreMateria.setIDMateria(idMateria);

        semestreMateriaDAO.agregar(semestreMateria);

        return true;
    }

    @WebMethod(operationName = "editSemestreMateria")
    public boolean editSemestreMateria(@WebParam(name = "id") int id, @WebParam(name = "idSemestre") int idSemestre, @WebParam(name = "idMateria") int idMateria) {
        SemestreMateria semestreMateria = new SemestreMateria();
        semestreMateria.setIDSemestre(idSemestre);
        semestreMateria.setIDMateria(idMateria);

        semestreMateriaDAO.actualizar(semestreMateria);

        return true;
    }

    @WebMethod(operationName = "deleteSemestreMateria")
    public boolean deleteSemestreMateria(@WebParam(name = "id") int id) {
        semestreMateriaDAO.eliminar(id);

        return true;
    }
}
