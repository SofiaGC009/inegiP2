package models;

import Models.Conexion;
import Models.Habitante;
import Views.Viviendas;
import java.util.ArrayList;
import java.util.List;

public class Vivienda extends Conexion{

    private int idVivienda;
    private String tipo;
    private String calle;
    private String colonia;
    private String numeroExt;
    private String numeroInt;
    private String codigoPostal;
    private String localidad;
    private String municipio;
    private List<Habitante> habitantes;
    private MaterialVivienda material;

    // Constructor
public Vivienda(int idVivienda, String calle, String colonia, String numeroExt, String numeroInt, String codigoPostal, String localidad, String municipio, MaterialVivienda material, List<Habitante> habitantes) {
    this.idVivienda = idVivienda;
    this.calle = calle;
    this.colonia = colonia;
    this.numeroExt = numeroExt;
    this.numeroInt = numeroInt;
    this.codigoPostal = codigoPostal;
    this.localidad = localidad;
    this.municipio = municipio;
    this.material = material;
    if (habitantes != null) {
        this.habitantes = habitantes;
    } else {
        this.habitantes = new ArrayList<>(); // Inicializar la lista de habitantes como una lista vacía si es nula
    }
}
    
// Getters y Setters
    public int getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumeroExt() {
        return numeroExt;
    }

    public void setNumeroExt(String numeroExt) {
        this.numeroExt = numeroExt;
    }

    public String getNumeroInt() {
        return numeroInt;
    }

    public void setNumeroInt(String numeroInt) {
        this.numeroInt = numeroInt;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public MaterialVivienda getMaterial() {
        return material;
    }

    public void setMaterial(MaterialVivienda material) {
        this.material = material;
    }

    public List<Habitante> getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(List<Habitante> habitantes) {
        this.habitantes = habitantes;
    }

    // Métodos adicionales
    public void agregarHabitante(Habitante habitante) {
        habitantes.add(habitante);
    }

    public void modificarHabitante(int indice, Habitante habitante) {
        habitantes.set(indice, habitante);
    }

    public void mostrarHabitantes() {
        for (Habitante habitante : habitantes) {
            System.out.println(habitante);
        }
    }

    public void eliminarHabitante(int indice) {
        habitantes.remove(indice);
    }

}
