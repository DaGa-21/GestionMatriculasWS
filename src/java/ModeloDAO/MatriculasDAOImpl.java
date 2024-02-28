package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.MatriculasDAO;
import Modelo.MatriculaInfo;
import Modelo.Matriculas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatriculasDAOImpl implements MatriculasDAO {

    private Connection conexion;

    public MatriculasDAOImpl() {
        this.conexion = new Conexion().getConnection();
    }

    @Override
    public Matriculas obtenerPorId(int id) {
        Matriculas matricula = null;
        String query = "SELECT * FROM Matriculas WHERE IDMatricula = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    matricula = mapearMatricula(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matricula;
    }

    @Override
    public List<Matriculas> obtenerTodos() {
        List<Matriculas> matriculas = new ArrayList<>();
        String query = "SELECT * FROM Matriculas";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Matriculas matricula = mapearMatricula(resultSet);
                matriculas.add(matricula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matriculas;
    }
    /*
    @Override //va void
    public int agregar(Matriculas matricula) {
        String query = "INSERT INTO Matriculas (IDMatricula, IDUsuario, IDSemestre, FechaMatricula) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, matricula.getIDMatricula());
            preparedStatement.setInt(2, matricula.getIDUsuario());
            preparedStatement.setInt(3, matricula.getIDSemestre());
            preparedStatement.setDate(4, new java.sql.Date(matricula.getFechaMatricula().getTime()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return -1;
    }
    */
    @Override
    public int agregar(Matriculas matricula) {
        String query = "INSERT INTO Matriculas (IDUsuario, IDSemestre, FechaMatricula) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, matricula.getIDUsuario());
            preparedStatement.setInt(2, matricula.getIDSemestre());
            preparedStatement.setDate(3, new java.sql.Date(matricula.getFechaMatricula().getTime()));

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1); // Retorna el ID generado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // Retorna -1 si no se pudo obtener el ID generado
    }

    @Override
    public void actualizar(Matriculas matricula) {
        String query = "UPDATE Matriculas SET IDUsuario=?, IDSemestre=?, FechaMatricula=? WHERE IDMatricula=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, matricula.getIDUsuario());
            preparedStatement.setInt(2, matricula.getIDSemestre());
            preparedStatement.setDate(3, new java.sql.Date(matricula.getFechaMatricula().getTime()));
            preparedStatement.setInt(4, matricula.getIDMatricula());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM Matriculas WHERE IDMatricula=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /* Joins */
    
    @Override
    public List<MatriculaInfo> obtenerMatriculasPorCedula(String cedula) {
        List<MatriculaInfo> matriculas = new ArrayList<>();
        String query = "SELECT "
                + "m.IDMatricula, "
                + "m.IDUsuario, "
                + "m.IDSemestre, "
                + "m.FechaMatricula, "
                + "ma.Nombre AS NombreMateria, "
                + "CONCAT(u_profesor.Nombres) AS NombreProfesor, "
                + "s.Descripcion AS DescripcionSemestre, "
                + "u_estudiante.Nombres AS NombreUsuario "
                + "FROM "
                + "Matriculas m "
                + "JOIN Usuarios u_estudiante ON m.IDUsuario = u_estudiante.IDUsuario "
                + "JOIN DetalleMatriculas dm ON m.IDMatricula = dm.IDMatricula "
                + "JOIN SemestreMateria sm ON dm.IDSemestreMateria = sm.IDSemestreMateria "
                + "JOIN Materias ma ON sm.IDMateria = ma.IDMateria "
                + "JOIN Semestres s ON sm.IDSemestre = s.IDSemestre "
                + "JOIN UsuarioRol up_estudiante ON u_estudiante.IDUsuario = up_estudiante.IDUsuario "
                + "JOIN Usuarios u_profesor ON ma.IDUsuario = u_profesor.IDUsuario "
                + "WHERE "
                + "(up_estudiante.IDRol = 1 OR up_estudiante.IDRol = 2) AND u_estudiante.Cedula = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, cedula);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    MatriculaInfo matricula = new MatriculaInfo();
                    matricula.setIDMatricula(resultSet.getInt("IDMatricula"));
                    matricula.setIDUsuario(resultSet.getInt("IDUsuario"));
                    matricula.setIDSemestre(resultSet.getInt("IDSemestre"));
                    matricula.setFechaMatricula(resultSet.getDate("FechaMatricula"));
                    matricula.setNombreMateria(resultSet.getString("NombreMateria"));
                    matricula.setNombreProfesor(resultSet.getString("NombreProfesor"));
                    matricula.setDescripcionSemestre(resultSet.getString("DescripcionSemestre"));
                    matricula.setNombreUsuario(resultSet.getString("NombreUsuario"));
                    matriculas.add(matricula);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matriculas;
    }


    private Matriculas mapearMatricula(ResultSet resultSet) throws SQLException {
        Matriculas matricula = new Matriculas();
        matricula.setIDMatricula(resultSet.getInt("IDMatricula"));
        matricula.setIDUsuario(resultSet.getInt("IDUsuario"));
        matricula.setIDSemestre(resultSet.getInt("IDSemestre"));
        matricula.setFechaMatricula(resultSet.getDate("FechaMatricula"));
        return matricula;
    }
}
