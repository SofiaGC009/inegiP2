package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private Connection con = null;
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/inegidb";
    
    public Connection getConexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (ClassNotFoundException e) {
            // La clase del controlador no se encontró, lanzar una excepción personalizada
            throw new SQLException("Driver JDBC no encontrado", e);
        } catch (SQLException e) {
            // Error al establecer la conexión, lanzar una excepción personalizada
            throw new SQLException("Error al conectar con la base de datos", e);
        }
    }
    
    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (con != null) {
                con.close();
                System.out.println("Conexión cerrada exitosamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

