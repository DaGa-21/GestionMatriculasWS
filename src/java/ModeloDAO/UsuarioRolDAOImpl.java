package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.UsuarioRolDAO;
import Modelo.UsuarioRol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRolDAOImpl implements UsuarioRolDAO {

    private Connection conexion;

    public UsuarioRolDAOImpl() {
        this.conexion = new Conexion().getConnection();
    }

    @Override
    public UsuarioRol obtenerPorId(int id) {
        UsuarioRol usuarioRol = null;
        String query = "SELECT * FROM UsuarioRol WHERE IDUsuarioRol = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    usuarioRol = mapearUsuarioRol(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarioRol;
    }

    @Override
    public List<UsuarioRol> obtenerTodos() {
        List<UsuarioRol> usuarioRoles = new ArrayList<>();
        String query = "SELECT * FROM UsuarioRol";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                UsuarioRol usuarioRol = mapearUsuarioRol(resultSet);
                usuarioRoles.add(usuarioRol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarioRoles;
    }

    @Override
    public void agregar(UsuarioRol usuarioRol) {
        String query = "INSERT INTO UsuarioRol (IDUsuarioRol, IDUsuario, IDRol) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, usuarioRol.getIDUsuarioRol());
            preparedStatement.setInt(2, usuarioRol.getIDUsuario());
            preparedStatement.setInt(3, usuarioRol.getIDRol());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(UsuarioRol usuarioRol) {
        String query = "UPDATE UsuarioRol SET IDUsuario=?, IDRol=? WHERE IDUsuarioRol=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, usuarioRol.getIDUsuario());
            preparedStatement.setInt(2, usuarioRol.getIDRol());
            preparedStatement.setInt(3, usuarioRol.getIDUsuarioRol());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM UsuarioRol WHERE IDUsuarioRol=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private UsuarioRol mapearUsuarioRol(ResultSet resultSet) throws SQLException {
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setIDUsuarioRol(resultSet.getInt("IDUsuarioRol"));
        usuarioRol.setIDUsuario(resultSet.getInt("IDUsuario"));
        usuarioRol.setIDRol(resultSet.getInt("IDRol"));
        return usuarioRol;
    }
}
