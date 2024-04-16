package models;

public class MaterialVivienda {

    private int idMatVivienda;
    private String tipoMaterial;

    // Constructor
    public MaterialVivienda(int idMatVivienda, String tipoMaterial) {
        this.idMatVivienda = idMatVivienda;
        this.tipoMaterial = tipoMaterial;
    }

    // Getter y Setter para el ID del material de vivienda
    public int getIdMatVivienda() {
        return idMatVivienda;
    }

    public void setIdMatVivienda(int idMatVivienda) {
        this.idMatVivienda = idMatVivienda;
    }

    // Getter y Setter para el tipo de material de vivienda
    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    // Método toString para obtener una representación de cadena del objeto MaterialViviendaModel
    @Override
    public String toString() {
        return "MaterialViviendaModel{" +
                "idMatVivienda=" + idMatVivienda +
                ", tipoMaterial='" + tipoMaterial + '\'' +
                '}';
    }
}

