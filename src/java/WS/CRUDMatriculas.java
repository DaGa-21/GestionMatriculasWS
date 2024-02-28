package WS;

import Modelo.DetalleMatriculas;
import Modelo.MatriculaInfo;
import Modelo.Matriculas;
import ModeloDAO.MatriculasDAOImpl;
import ModeloDAO.DetalleMatriculasDAOImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "CRUDMatriculas")
public class CRUDMatriculas {

    MatriculasDAOImpl matriculasDAO = new MatriculasDAOImpl();
    DetalleMatriculasDAOImpl detalleMatriculasDAO = new DetalleMatriculasDAOImpl();

    @WebMethod(operationName = "listMatriculas")
    public List<Matriculas> listMatriculas() {
        return matriculasDAO.obtenerTodos();
    }

    @WebMethod(operationName = "listByIdMatriculas")
    public Matriculas listByIdMatriculas(@WebParam(name = "id") int id) {
        return matriculasDAO.obtenerPorId(id);
    }
    /*
    @WebMethod(operationName = "addMatriculas")
    public boolean addMatriculas(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "idSemestre") int idSemestre, @WebParam(name = "fechaMatricula") String fechaMatricula) {
        Matriculas matricula = new Matriculas();
        matricula.setIDUsuario(idUsuario);
        matricula.setIDSemestre(idSemestre);
        // Aquí debes convertir la fecha de String a Date, dependiendo de tu implementación
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = sdf.parse(fechaMatricula);
        } catch (ParseException e) {
            e.printStackTrace(); // Manejo de la excepción, dependiendo de tu implementación
            return false; // Opcional: si la conversión falla, puedes retornar false
        }

        matricula.setFechaMatricula(fecha);

        matriculasDAO.agregar(matricula);

        return true;
    }
    
    @WebMethod(operationName = "addMatricula")
    public boolean addMatricula(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "idSemestre") int idSemestre, @WebParam(name = "fechaMatricula") String fechaMatricula, @WebParam(name = "idSemestreMateria") int idSemestreMateria) {
        Matriculas matricula = new Matriculas();
        matricula.setIDUsuario(idUsuario);
        matricula.setIDSemestre(idSemestre);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        
        try {
            fecha = sdf.parse(fechaMatricula);
        } catch (ParseException e) {
            e.printStackTrace(); // Manejo de la excepción, dependiendo de tu implementación
            return false; // Opcional: si la conversión falla, puedes retornar false
        }
        matricula.setFechaMatricula(fecha);
       

        int idMatricula = matriculasDAO.agregar(matricula); // Obtiene el ID generado
        System.out.println(idMatricula);
        
        if (idMatricula != -1) {
            DetalleMatriculas detallesMatriculas = new DetalleMatriculas();
            
            detallesMatriculas.setIDMatricula(idMatricula);
            detallesMatriculas.setIDSemestreMateria(idSemestreMateria);

            detalleMatriculasDAO.agregar(detallesMatriculas);

            return true;
        }
        

        return false;
    }
    */
    @WebMethod(operationName = "addMatricula")
    public boolean addMatricula(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "idSemestre") int idSemestre, @WebParam(name = "fechaMatricula") String fechaMatricula, @WebParam(name = "idSemestreMaterias") List<Integer> idSemestreMaterias) {
        Matriculas matricula = new Matriculas();
        matricula.setIDUsuario(idUsuario);
        matricula.setIDSemestre(idSemestre);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;

        try {
            fecha = sdf.parse(fechaMatricula);
        } catch (ParseException e) {
            e.printStackTrace(); // Manejo de la excepción, dependiendo de tu implementación
            return false; // Opcional: si la conversión falla, puedes retornar false
        }
        matricula.setFechaMatricula(fecha);

        int idMatricula = matriculasDAO.agregar(matricula); // Obtiene el ID generado
        System.out.println(idMatricula);

        if (idMatricula != -1) {
            for (int idSemestreMateria : idSemestreMaterias) {
                DetalleMatriculas detallesMatriculas = new DetalleMatriculas();

                detallesMatriculas.setIDMatricula(idMatricula);
                detallesMatriculas.setIDSemestreMateria(idSemestreMateria);
             
                detalleMatriculasDAO.agregar(detallesMatriculas);
            }

            System.out.println(idSemestreMaterias);
            return true;
        }

        return false;
    }

    @WebMethod(operationName = "editMatriculas")
    public boolean editMatriculas(@WebParam(name = "id") int id, @WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "idSemestre") int idSemestre, @WebParam(name = "fechaMatricula") String fechaMatricula) {
        Matriculas matricula = new Matriculas();
        matricula.setIDMatricula(id);
        matricula.setIDUsuario(idUsuario);
        matricula.setIDSemestre(idSemestre);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = sdf.parse(fechaMatricula);
        } catch (ParseException e) {
            e.printStackTrace(); // Manejo de la excepción, dependiendo de tu implementación
            return false; // Opcional: si la conversión falla, puedes retornar false
        }
        matricula.setFechaMatricula(fecha);
        // Aquí debes convertir la fecha de String a Date, dependiendo de tu implementación

        matriculasDAO.actualizar(matricula);

        return true;
    }

    @WebMethod(operationName = "deleteMatriculas")
    public boolean deleteMatriculas(@WebParam(name = "id") int id) {
        matriculasDAO.eliminar(id);

        return true;
    }
    
    @WebMethod(operationName = "listMatriculasPorCedula")
    public List<MatriculaInfo> listMatriculasPorCedula(@WebParam(name = "cedula") String cedula) {
        return matriculasDAO.obtenerMatriculasPorCedula(cedula);
    }

}
