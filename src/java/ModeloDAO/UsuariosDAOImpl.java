package ModeloDAO;

import Configuracion.Conexion;
import Interfaces.UsuariosDAO;
import Modelo.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAOImpl implements UsuariosDAO {

    private Connection conexion;

    public UsuariosDAOImpl() {
        this.conexion = new Conexion().getConnection();
    }

    @Override
    public Usuarios obtenerPorId(int id) {
        Usuarios usuario = null;
        String query = "SELECT * FROM Usuarios WHERE IDUsuario = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    usuario = mapearUsuario(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public List<Usuarios> obtenerTodos() {
        List<Usuarios> usuarios = new ArrayList<>();
        String query = "SELECT * FROM Usuarios";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Usuarios usuario = mapearUsuario(resultSet);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    @Override
    public void agregar(Usuarios usuario) {
        String query = "INSERT INTO Usuarios (IDUsuario, Cedula, Nombres, Edad) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, usuario.getIDUsuario());
            preparedStatement.setString(2, usuario.getCedula());
            preparedStatement.setString(3, usuario.getNombres());
            preparedStatement.setInt(4, usuario.getEdad());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Usuarios usuario) {
        String query = "UPDATE Usuarios SET Cedula=?, Nombres=?, Edad=? WHERE IDUsuario=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setString(1, usuario.getCedula());
            preparedStatement.setString(2, usuario.getNombres());
            preparedStatement.setInt(3, usuario.getEdad());
            preparedStatement.setInt(4, usuario.getIDUsuario());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM Usuarios WHERE IDUsuario=?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Usuarios mapearUsuario(ResultSet resultSet) throws SQLException {
        Usuarios usuario = new Usuarios();
        usuario.setIDUsuario(resultSet.getInt("IDUsuario"));
        usuario.setCedula(resultSet.getString("Cedula"));
        usuario.setNombres(resultSet.getString("Nombres"));
        usuario.setEdad(resultSet.getInt("Edad"));
        return usuario;
    }
}
