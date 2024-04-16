package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date; // Importa java.sql.Date
import java.time.LocalDate; // Importa java.time.LocalDate
import Views.Habitantes;
import Models.Conexion;
import Models.Habitante;
import models.Ocupacion;

public class HabitantesController {
    private final Habitantes view;
    private final Conexion conexion;

    public HabitantesController(Habitantes view) {
        this.view = view;
        this.conexion = new Conexion();
    }

    // Método para mostrar el habitante en la vista
    public void mostrarHabitante(String curp) {
        try {
            // Establecer conexión
            Connection con = conexion.getConexion();
            
            // Consulta SQL para obtener el habitante con la CURP especificada
            String query = "SELECT * FROM habitante WHERE CURP = ?";
            
            // Preparar la sentencia SQL
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, curp);
                
                // Ejecutar la consulta
                try (ResultSet rs = pstmt.executeQuery()) {
                    // Verificar si se encontró el habitante
                    if (rs.next()) {
                        // Obtener la fecha de nacimiento como java.sql.Date
                        Date fechaNacimientoSQL = rs.getDate("FECHANACIMIENTO");
                        
                        // Convertir java.sql.Date a LocalDate
                        LocalDate fechaNacimiento = fechaNacimientoSQL.toLocalDate();
                        
                        // Crear un objeto Ocupacion con los datos de la consulta
                        Ocupacion ocupacion = new Ocupacion(rs.getInt("IDOCUPACION"), null);
                        
                        // Crear un objeto Habitante con los datos de la consulta
                        Habitante habitante = new Habitante(
                            rs.getString("CURP"),
                            rs.getInt("IDOCUPACION"),
                            rs.getInt("IDVIVIENDA"),
                            rs.getString("NOMBREH"),
                            rs.getString("PATERNOH"),
                            rs.getString("MATERNOH"),
                            fechaNacimiento,
                            ocupacion
                        );
                        
                        // Mostrar los datos del habitante en la vista
                        view.mostrarDatosHabitante(habitante);
                    } else {
                        view.mostrarMensajeError("No se encontró el habitante con la CURP especificada.");
                    }
                }
            }
            
            // Cerrar la conexión
            conexion.cerrarConexion();
        } catch (SQLException e) {
            view.mostrarMensajeError("Error al obtener el habitante: " + e.getMessage());
        }
    }
}

    
    // Método para agregar un nuevo habitante
    public boolean agregarHabitante(String curp, int idOcupacion, int idVivienda, String nombre, String paterno, String materno, Date fechaNacimiento) {
        try {
            // Establecer conexión
            Connection con = conexion.getConexion();
            
            // Consulta SQL para insertar un nuevo habitante
            String query = "INSERT INTO habitante (CURP, IDOCUPACION, IDVIVIENDA, NOMBREH, PATERNOH, MATERNOH, FECHANACIMIENTO) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            // Preparar la sentencia SQL
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, curp);
                pstmt.setInt(2, idOcupacion);
                pstmt.setInt(3, idVivienda);
                pstmt.setString(4, nombre);
                pstmt.setString(5, paterno);
                pstmt.setString(6, materno);
                pstmt.setDate(7, fechaNacimiento);
                
                // Ejecutar la consulta
                int rowsAffected = pstmt.executeUpdate();
                
                // Verificar si la inserción fue exitosa
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            view.mostrarMensajeError("Error al agregar el habitante: " + e.getMessage());
            return false;
        }
    }
    
    // Método para modificar los datos de un habitante
    public boolean modificarHabitante(String curp, int idOcupacion, int idVivienda, String nombre, String paterno, String materno, Date fechaNacimiento) {
        try {
            // Establecer conexión
            Connection con = conexion.getConexion();
            
            // Consulta SQL para actualizar los datos del habitante
            String query = "UPDATE habitante SET IDOCUPACION=?, IDVIVIENDA=?, NOMBREH=?, PATERNOH=?, MATERNOH=?, FECHANACIMIENTO=? WHERE CURP=?";
            
            // Preparar la sentencia SQL
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, idOcupacion);
                pstmt.setInt(2, idVivienda);
                pstmt.setString(3, nombre);
                pstmt.setString(4, paterno);
                pstmt.setString(5, materno);
                pstmt.setDate(6, fechaNacimiento);
                pstmt.setString(7, curp);
                
                // Ejecutar la consulta
                int rowsAffected = pstmt.executeUpdate();
                
                // Verificar si la modificación fue exitosa
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            view.mostrarMensajeError("Error al modificar el habitante: " + e.getMessage());
            return false;
        }
    }
    
    // Método para eliminar un habitante
    public boolean eliminarHabitante(String curp) {
        try {
            // Establecer conexión
            Connection con = conexion.getConexion();
            
            // Consulta SQL para eliminar el habitante con el CURP especificado
            String query = "DELETE FROM habitante WHERE CURP = ?";
            
            // Preparar la sentencia SQL
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, curp);
                
                // Ejecutar la consulta
                int rowsAffected = pstmt.executeUpdate();
                
                // Verificar si la eliminación fue exitosa
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            view.mostrarMensajeError("Error al eliminar el habitante: " + e.getMessage());
            return false;
        }
    }
}


