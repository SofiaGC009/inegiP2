package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Administrador extends Conexion {

    private final String usuario;
    private final String password;

    public Administrador(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public boolean login() {
        try (Connection con = getConexion()) {
            // Realizar una consulta a la base de datos para recuperar el registro del usuario
            String query = "SELECT * FROM administrador WHERE usuario = ? AND password = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, usuario);
                pstmt.setString(2, password);
                try (ResultSet rs = pstmt.executeQuery()) {
                    // Si se encuentra un registro, el inicio de sesión es exitoso
                    return rs.next();
                }
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción que ocurra durante el inicio de sesión
            return false;
        }
    }
}

