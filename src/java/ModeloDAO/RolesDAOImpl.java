package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.RolesDAO;
import Modelo.Roles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolesDAOImpl implements RolesDAO {

    private Connection conexion;

    public RolesDAOImpl() {
        this.conexion = new Conexion().getConnection();
    }

    @Override
    public Roles obtenerPorId(int id) {
        Roles rol = null;
        String query = "SELECT * FROM Roles WHERE IDRol = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    rol = mapearRol(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rol;
    }

    @Override
    public List<Roles> obtenerTodos() {
        List<Roles> roles = new ArrayList<>();
        String query = "SELECT * FROM Roles";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Roles rol = mapearRol(resultSet);
                roles.add(rol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles;
    }

    @Override
    public void agregar(Roles rol) {
        String query = "INSERT INTO Roles (IDRol, Nombre, Departamento) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, rol.getIDRol());
            preparedStatement.setString(2, rol.getNombre());
            preparedStatement.setString(3, rol.getDepartamento());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Roles rol) {
        String query = "UPDATE Roles SET Nombre=?, Departamento=? WHERE IDRol=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, rol.getNombre());
            preparedStatement.setString(2, rol.getDepartamento());
            preparedStatement.setInt(3, rol.getIDRol());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM Roles WHERE IDRol=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Roles mapearRol(ResultSet resultSet) throws SQLException {
        Roles rol = new Roles();
        rol.setIDRol(resultSet.getInt("IDRol"));
        rol.setNombre(resultSet.getString("Nombre"));
        rol.setDepartamento(resultSet.getString("Departamento"));
        return rol;
    }
}
