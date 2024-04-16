package Models;

import java.time.LocalDate;
import models.Ocupacion;

public class Habitante extends Conexion{

    private String curp;
    private String nombreH;
    private String paternoH;
    private String maternoH;
    private LocalDate fechaNacimiento;
    private Ocupacion ocupacion;

    // Constructor
    public Habitante(String curp, String nombreH, String paternoH, String maternoH, LocalDate fechaNacimiento, Ocupacion ocupacion, int idVivienda, int idOcupacion) {
        this.curp = curp;
        this.nombreH = nombreH;
        this.paternoH = paternoH;
        this.maternoH = maternoH;
        this.fechaNacimiento = fechaNacimiento;
        this.ocupacion = ocupacion;
    }

    // Getter y Setter para la CURP
    public String getCurp() {
        return curp;
    }

    // Setter para la CURP con validación
    public void setCurp(String curp) {
        // Validar longitud de la CURP
        if (curp.length() == 18) {
            this.curp = curp;
        } else {
            throw new IllegalArgumentException("La CURP debe tener 18 caracteres");
        }
    }

    // Getters y Setters para nombre, apellido paterno y apellido materno
    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }

    public String getPaternoH() {
        return paternoH;
    }

    public void setPaternoH(String paternoH) {
        this.paternoH = paternoH;
    }

    public String getMaternoH() {
        return maternoH;
    }

    public void setMaternoH(String maternoH) {
        this.maternoH = maternoH;
    }

    // Getter y Setter para la fecha de nacimiento
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    // Setter para la fecha de nacimiento con validación
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        // Verificar si la fecha de nacimiento es nula o es en el futuro
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        } else if (fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede estar en el futuro");
        } else {
            this.fechaNacimiento = fechaNacimiento;
        }
    }

    // Getter y Setter para la ocupación
    public Ocupacion getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(Ocupacion ocupacion) {
        this.ocupacion = ocupacion;
    }

    // Método toString para obtener una representación de cadena del objeto Habitante
    @Override
    public String toString() {
        return "Habitante{" +
                "curp='" + curp + '\'' +
                ", nombreH='" + nombreH + '\'' +
                ", paternoH='" + paternoH + '\'' +
                ", maternoH='" + maternoH + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", ocupacion=" + ocupacion +
                '}';
    }
}
