package colegio.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/colegio"; // Asegúrate de que la BD existe
    private static final String USER = "root";
    private static final String PASSWORD = ""; // En XAMPP, la contraseña suele estar vacía

    public static Connection getConnection() { // ✅ Se usa este método en lugar de conectar()
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver de MySQL
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a MySQL.");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: No se encontró el driver de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión a MySQL.");
            e.printStackTrace();
        }
        return conexion;
    }
}
