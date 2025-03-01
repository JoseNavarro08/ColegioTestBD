package colegio.Controladores;
import colegio.Database.ConexionDB;
import colegio.Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioControlador 
{
    public Usuario validarUsuario(String usuario, String contraseña) {
        Connection conn = ConexionDB.getConnection();
        Usuario user = null;
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contraseña = ?";


        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, contraseña);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new Usuario(
                    rs.getInt("id"),
                    rs.getString("correo"),
                    rs.getString("nombre"),
                    rs.getString("rol") // Profesor o Estudiante
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user; // Devuelve null si no hay coincidencia
    }

    public boolean registrarUsuario(Usuario usuario) {
        Connection conn = ConexionDB.getConnection();
        String query = "INSERT INTO usuarios (usuario, contraseña, nombre, rol) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, usuario.getCorreo());
            stmt.setString(2, usuario.getContraseña());
            stmt.setString(3, usuario.getNombre());
            stmt.setString(4, usuario.getRol());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    } // 🔹 Se cerró correctamente el método

    public Usuario buscarUsuarioPorId(int id) {
        Connection conn = ConexionDB.getConnection();
        Usuario user = null;
        String query = "SELECT * FROM usuarios WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new Usuario(
                    rs.getInt("id"),
                    rs.getString("usuario"),
                    rs.getString("nombre"),
                    rs.getString("rol")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<Usuario> listarUsuarios() {
        Connection conn = ConexionDB.getConnection();
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuarios";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                usuarios.add(new Usuario(
                    rs.getInt("id"),
                    rs.getString("usuario"),
                    rs.getString("nombre"),
                    rs.getString("rol")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
} // 🔹 Se cerró correctamente la clase
