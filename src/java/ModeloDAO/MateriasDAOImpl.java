package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.MateriasDAO;
import Modelo.Materias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriasDAOImpl implements MateriasDAO {

    private Connection conexion;

    public MateriasDAOImpl() {
        this.conexion = new Conexion().getConnection();
    }

    @Override
    public Materias obtenerPorId(int id) {
        Materias materia = null;
        String query = "SELECT * FROM Materias WHERE IDMateria = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    materia = mapearMateria(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return materia;
    }

    @Override
    public List<Materias> obtenerTodos() {
        List<Materias> materias = new ArrayList<>();
        String query = "SELECT * FROM Materias";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Materias materia = mapearMateria(resultSet);
                materias.add(materia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return materias;
    }

    @Override
    public void agregar(Materias materia) {
        String query = "INSERT INTO Materias (IDMateria, Nombre, Abreviatura, IDUsuario) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, materia.getIDMateria());
            preparedStatement.setString(2, materia.getNombre());
            preparedStatement.setString(3, materia.getAbreviatura());
            preparedStatement.setInt(4, materia.getIDUsuario());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Materias materia) {
        String query = "UPDATE Materias SET Nombre=?, Abreviatura=?, IDUsuario=? WHERE IDMateria=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, materia.getNombre());
            preparedStatement.setString(2, materia.getAbreviatura());
            preparedStatement.setInt(3, materia.getIDUsuario());
            preparedStatement.setInt(4, materia.getIDMateria());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM Materias WHERE IDMateria=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Materias mapearMateria(ResultSet resultSet) throws SQLException {
        Materias materia = new Materias();
        materia.setIDMateria(resultSet.getInt("IDMateria"));
        materia.setNombre(resultSet.getString("Nombre"));
        materia.setAbreviatura(resultSet.getString("Abreviatura"));
        materia.setIDUsuario(resultSet.getInt("IDUsuario"));
        return materia;
    }
}
