package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.SemestresDAO;
import Modelo.Semestres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SemestresDAOImpl implements SemestresDAO {

    private Connection conexion;

    public SemestresDAOImpl() {
        this.conexion = new Conexion().getConnection();
    }

    @Override
    public Semestres obtenerPorId(int id) {
        Semestres semestre = null;
        String query = "SELECT * FROM Semestres WHERE IDSemestre = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    semestre = mapearSemestre(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return semestre;
    }

    @Override
    public List<Semestres> obtenerTodos() {
        List<Semestres> semestres = new ArrayList<>();
        String query = "SELECT * FROM Semestres";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Semestres semestre = mapearSemestre(resultSet);
                semestres.add(semestre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return semestres;
    }

    @Override
    public void agregar(Semestres semestre) {
        String query = "INSERT INTO Semestres (IDSemestre, Descripcion, Malla) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, semestre.getIDSemestre());
            preparedStatement.setString(2, semestre.getDescripcion());
            preparedStatement.setString(3, semestre.getMalla());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Semestres semestre) {
        String query = "UPDATE Semestres SET Descripcion=?, Malla=? WHERE IDSemestre=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, semestre.getDescripcion());
            preparedStatement.setString(2, semestre.getMalla());
            preparedStatement.setInt(3, semestre.getIDSemestre());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM Semestres WHERE IDSemestre=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Semestres mapearSemestre(ResultSet resultSet) throws SQLException {
        Semestres semestre = new Semestres();
        semestre.setIDSemestre(resultSet.getInt("IDSemestre"));
        semestre.setDescripcion(resultSet.getString("Descripcion"));
        semestre.setMalla(resultSet.getString("Malla"));
        return semestre;
    }
}
