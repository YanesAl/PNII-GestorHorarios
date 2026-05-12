package co.edu.unbosque.model.dto;
public class AreaDTO {

    private int idArea;
    private String nombreArea;
    private String descripcion;
    private int idFacultad;

    public AreaDTO() {
    }

    public AreaDTO(int idArea, String nombreArea,
                   String descripcion, int idFacultad) {
        this.idArea = idArea;
        this.nombreArea = nombreArea;
        this.descripcion = descripcion;
        this.idFacultad = idFacultad;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }
}