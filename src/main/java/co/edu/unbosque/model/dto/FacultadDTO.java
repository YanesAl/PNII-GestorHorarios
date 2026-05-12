package co.edu.unbosque.model.dto;
import java.util.List;

public class FacultadDTO{

    private int idFacultad;
    private String nombreFacultad;
    private List<Integer> idCarreras;

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    public List<Integer> getIdCarreras() {
        return idCarreras;
    }

    public void setIdCarreras(List<Integer> idCarreras) {
        this.idCarreras = idCarreras;
    }
}