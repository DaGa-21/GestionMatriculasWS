package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.DetalleMatriculasDAO;
import Modelo.DetalleMatriculas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleMatriculasDAOImpl implements DetalleMatriculasDAO {

    private Connection conexion;

    public DetalleMatriculasDAOImpl() {
        this.conexion = new Conexion().getConnection();
    }

    @Override
    public DetalleMatriculas obtenerPorId(int id) {
        DetalleMatriculas detalleMatricula = null;
        String query = "SELECT * FROM DetalleMatriculas WHERE IDDetalle = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    detalleMatricula = mapearDetalleMatricula(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detalleMatricula;
    }

    @Override
    public List<DetalleMatriculas> obtenerTodos() {
        List<DetalleMatriculas> detalleMatriculas = new ArrayList<>();
        String query = "SELECT * FROM DetalleMatriculas";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                DetalleMatriculas detalleMatricula = mapearDetalleMatricula(resultSet);
                detalleMatriculas.add(detalleMatricula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detalleMatriculas;
    }

    @Override
    public void agregar(DetalleMatriculas detalleMatricula) {
        String query = "INSERT INTO DetalleMatriculas (IDMatricula, IDSemestreMateria) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, detalleMatricula.getIDMatricula());
            preparedStatement.setInt(2, detalleMatricula.getIDSemestreMateria());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(DetalleMatriculas detalleMatricula) {
        String query = "UPDATE DetalleMatriculas SET IDMatricula=?, IDSemestreMateriae=? WHERE IDDetalle=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, detalleMatricula.getIDMatricula());
            preparedStatement.setInt(2, detalleMatricula.getIDSemestreMateria());
            preparedStatement.setInt(3, detalleMatricula.getIDDetalle());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM DetalleMatriculas WHERE IDDetalle=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DetalleMatriculas mapearDetalleMatricula(ResultSet resultSet) throws SQLException {
        DetalleMatriculas detalleMatricula = new DetalleMatriculas();
        detalleMatricula.setIDDetalle(resultSet.getInt("IDDetalle"));
        detalleMatricula.setIDMatricula(resultSet.getInt("IDMatricula"));
        detalleMatricula.setIDSemestreMateria(resultSet.getInt("IDSemestreMateria"));
        return detalleMatricula;
    }
}
