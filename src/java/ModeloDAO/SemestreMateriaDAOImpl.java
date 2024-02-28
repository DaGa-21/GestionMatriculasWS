package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.SemestreMateriaDAO;
import Modelo.SemestreMateria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SemestreMateriaDAOImpl implements SemestreMateriaDAO {

    private Connection conexion;

    public SemestreMateriaDAOImpl() {
        this.conexion = new Conexion().getConnection();
    }

    @Override
    public SemestreMateria obtenerPorId(int id) {
        SemestreMateria semestreMateria = null;
        String query = "SELECT * FROM SemestreMateria WHERE IDSemestreMateria = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    semestreMateria = mapearSemestreMateria(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return semestreMateria;
    }

    @Override
    public List<SemestreMateria> obtenerTodos() {
        List<SemestreMateria> semestreMaterias = new ArrayList<>();
        String query = "SELECT * FROM SemestreMateria";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                SemestreMateria semestreMateria = mapearSemestreMateria(resultSet);
                semestreMaterias.add(semestreMateria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return semestreMaterias;
    }

    @Override
    public void agregar(SemestreMateria semestreMateria) {
        String query = "INSERT INTO SemestreMateria (IDSemestreMateria, IDSemestre, IDMateria) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, semestreMateria.getIDSemestreMateria());
            preparedStatement.setInt(2, semestreMateria.getIDSemestre());
            preparedStatement.setInt(3, semestreMateria.getIDMateria());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(SemestreMateria semestreMateria) {
        String query = "UPDATE SemestreMateria SET IDSemestre=?, IDMateria=? WHERE IDSemestreMateria=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, semestreMateria.getIDSemestre());
            preparedStatement.setInt(2, semestreMateria.getIDMateria());
            preparedStatement.setInt(3, semestreMateria.getIDSemestreMateria());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM SemestreMateria WHERE IDSemestreMateria=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private SemestreMateria mapearSemestreMateria(ResultSet resultSet) throws SQLException {
        SemestreMateria semestreMateria = new SemestreMateria();
        semestreMateria.setIDSemestreMateria(resultSet.getInt("IDSemestreMateria"));
        semestreMateria.setIDSemestre(resultSet.getInt("IDSemestre"));
        semestreMateria.setIDMateria(resultSet.getInt("IDMateria"));
        return semestreMateria;
    }
}
