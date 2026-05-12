package co.edu.unbosque.model.dto;
import java.util.List;

public class CarreraDTO {


    private int idCarrera;
    private String nombreCarrera;
    private int idFacultad;
    private List<Integer> idPlanesEstudios;

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public List<Integer> getIdPlanesEstudios() {
        return idPlanesEstudios;
    }

    public void setIdPlanesEstudios(List<Integer> idPlanesEstudios) {
        this.idPlanesEstudios = idPlanesEstudios;
    }
}