package Controllers;

import Views.Viviendas;
import Models.Conexion;
import models.Vivienda;
import models.MaterialVivienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViviendaController {
    private final Viviendas view;
    private final Conexion conexion;

    public ViviendaController(Viviendas view) {
        this.view = view;
        this.conexion = new Conexion();
    }

    // Método para mostrar la vivienda en la vista
    public void mostrarVivienda(int idVivienda) {
        try {
            // Establecer conexión
            Connection con = conexion.getConexion();
            
            // Consulta SQL para obtener la vivienda con la ID especificada
            String query = "SELECT * FROM vivienda WHERE idVivienda = ?";
            
            // Preparar la sentencia SQL
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, idVivienda);
                
                // Ejecutar la consulta
                try (ResultSet rs = pstmt.executeQuery()) {
                    // Verificar si se encontró la vivienda
                    if (rs.next()) {
                        // Obtener el ID del material de la vivienda
                        int idMaterialVivienda = rs.getInt("idMatViv");
                        
                        // Crear un objeto MaterialVivienda con los datos de la consulta
                        MaterialVivienda materialVivienda = obtenerMaterialVivienda(idMaterialVivienda);
                        
                        // Crear un objeto Vivienda con los datos de la consulta
                        Vivienda vivienda = new Vivienda(
                            rs.getInt("idVivienda"),
                            rs.getString("calle"),
                            rs.getString("colonia"),
                            rs.getString("numeroInt"),
                            rs.getString("numeroExt"),
                            rs.getString("codigoPostal"),
                            rs.getString("localidad"),
                            rs.getString("municipio"),
                            materialVivienda,
                            null // Habitantes, aún no disponibles
                        );
                        
                        // Mostrar los datos de la vivienda en la vista
                        view.mostrarDatosVivienda(vivienda);
                    } else {
                        view.mostrarMensajeError("No se encontró la vivienda con la ID especificada.");
                    }
                }
            }
            
            // Cerrar la conexión
            conexion.cerrarConexion();
        } catch (SQLException e) {
            view.mostrarMensajeError("Error al obtener la vivienda: " + e.getMessage());
        }
    }
    
    private MaterialVivienda obtenerMaterialVivienda(int idMaterialVivienda) throws SQLException {
    // Establecer conexión
    Connection con = conexion.getConexion();
    
    // Consulta SQL para obtener el material de la vivienda con el ID especificado
    String query = "SELECT * FROM materialvivienda WHERE idMatViv = ?";
    
    // Preparar la sentencia SQL
    try (PreparedStatement pstmt = con.prepareStatement(query)) {
        pstmt.setInt(1, idMaterialVivienda);
        
        // Ejecutar la consulta
        try (ResultSet rs = pstmt.executeQuery()) {
            // Verificar si se encontró el material de la vivienda
            if (rs.next()) {
                // Crear y devolver un objeto MaterialVivienda con los datos de la consulta
                return new MaterialVivienda(
                    rs.getInt("idMatViv"),
                    rs.getString("tipoMaterial")
                );
            } else {
                throw new SQLException("No se encontró el material de la vivienda con el ID especificado.");
            }
        }
    }
}
    
    public boolean modificarVivienda(int idVivienda, String calle, String colonia, String numeroExt, String numeroInt, String codigoPostal, String localidad, String municipio) {
    try {
        // Establecer conexión
        Connection con = conexion.getConexion();
        
        // Consulta SQL para actualizar los datos de la vivienda
        String query = "UPDATE vivienda SET calle=?, colonia=?, numeroExt=?, numeroInt=?, codigoPostal=?, localidad=?, municipio=? WHERE idVivienda=?";
        
        // Preparar la sentencia SQL
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, calle);
            pstmt.setString(2, colonia);
            pstmt.setString(3, numeroExt);
            pstmt.setString(4, numeroInt);
            pstmt.setString(5, codigoPostal);
            pstmt.setString(6, localidad);
            pstmt.setString(7, municipio);
            pstmt.setInt(9, idVivienda);
            
            // Ejecutar la consulta
            int rowsAffected = pstmt.executeUpdate();
            
            // Verificar si la modificación fue exitosa
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        }
    } catch (SQLException e) {
        view.mostrarMensajeError("Error al modificar la vivienda: " + e.getMessage());
        return false;
    }
}

    
    public void eliminarVivienda(int idVivienda) {
    try {
        // Establecer conexión
        Connection con = conexion.getConexion();
        
        // Consulta SQL para eliminar la vivienda con la ID especificada
        String query = "DELETE FROM vivienda WHERE idVivienda = ?";
        
        // Preparar la sentencia SQL
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, idVivienda);
        
        // Ejecutar la consulta
        int rowsAffected = pstmt.executeUpdate();
        
        if (rowsAffected > 0) {
            view.mostrarMensaje("La vivienda ha sido eliminada exitosamente.");
        } else {
            view.mostrarMensajeError("No se pudo eliminar la vivienda.");
        }
        
        // Cerrar recursos
        pstmt.close();
        conexion.cerrarConexion(); // Cerrar la conexión
    } catch (SQLException e) {
        view.mostrarMensajeError("Error al eliminar la vivienda: " + e.getMessage());
    }
}

}