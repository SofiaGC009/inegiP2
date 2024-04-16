package models;

public class Ocupacion {

    private int idOcupacion;
    private String ocupacion;

    // Constructor
    public Ocupacion(int idOcupacion, String ocupacion) {
        this.idOcupacion = idOcupacion;
        this.ocupacion = ocupacion;
    }

    // Getter y Setter para el ID de la ocupación
    public int getIdOcupacion() {
        return idOcupacion;
    }

    public void setIdOcupacion(int idOcupacion) {
        this.idOcupacion = idOcupacion;
    }

    // Getter y Setter para la descripción de la ocupación
    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    // Método toString para obtener una representación de cadena del objeto Ocupacion
    @Override
    public String toString() {
        return "Ocupacion{" +
                "idOcupacion=" + idOcupacion +
                ", ocupacion='" + ocupacion + '\'' +
                '}';
    }
}

