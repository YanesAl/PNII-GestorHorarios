package co.edu.unbosque.bean;

import co.edu.unbosque.model.dto.EstudianteDTO;
import co.edu.unbosque.model.enums.EstadoEstudiante;
import co.edu.unbosque.service.interfaces.IServicioEstudiante;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class EstudianteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IServicioEstudiante servicioEstudiante;

    private EstudianteDTO estudiante;
    private List<EstudianteDTO> listaEstudiantes;

    @PostConstruct
    public void init() {
        nuevoEstudiante();
        cargarDatos();
    }

    public void nuevoEstudiante() {
        estudiante = new EstudianteDTO();
    }

    public void cargarDatos() {
        listaEstudiantes = servicioEstudiante.readAll();
    }

    public String guardar() {

        try {

            if (estudiante.getIdPersona() == 0) {
                servicioEstudiante.create(estudiante);
            } else {
                servicioEstudiante.update(estudiante);
            }

            cargarDatos();
            nuevoEstudiante();

            return "estudiante?faces-redirect=true";

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void editar(EstudianteDTO e) {
        estudiante = e;
    }

    public void eliminar(Integer id) {

        try {

            servicioEstudiante.delete(id);
            cargarDatos();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public EstadoEstudiante[] getEstadosEstudiante() {
        return EstadoEstudiante.values();
    }

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }

    public List<EstudianteDTO> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<EstudianteDTO> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
}