package co.edu.unbosque.model.dto;
import java.util.List;

public class PlanEstudiosDTO{

    private int idPlan;
    private String nombrePlan;
    private Integer idCarrera;
    private List<Integer> idsCursos;

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public List<Integer> getIdsCursos() {
        return idsCursos;
    }

    public void setIdsCursos(List<Integer> idsCursos) {
        this.idsCursos = idsCursos;
    }
}