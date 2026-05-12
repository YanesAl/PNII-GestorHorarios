package co.edu.unbosque.bean;

import co.edu.unbosque.model.dto.HorarioDTO;
import co.edu.unbosque.service.interfaces.IServicioHorario;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class HorarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IServicioHorario servicioHorario;

    private List<HorarioDTO> listaHorario;
    private HorarioDTO filtro;
    private HorarioDTO seleccionado;

    @PostConstruct
    public void init() {
        filtro = new HorarioDTO();
        cargarHorario();
    }

    public void cargarHorario() {
        listaHorario = servicioHorario.generarHorario(filtro);
    }

    public void generar() {
        cargarHorario();
    }

    public void limpiar() {
        filtro = new HorarioDTO();
        seleccionado = null;
        cargarHorario();
    }

    public void eliminar() {
        if (seleccionado != null) {
            servicioHorario.delete(seleccionado.getIdSeccion());
            seleccionado = null;
            cargarHorario();
        }
    }

    public void actualizar() {
        if (seleccionado != null) {
            servicioHorario.update(seleccionado);
            cargarHorario();
        }
    }

    public List<HorarioDTO> getListaHorario() { return listaHorario; }
    public void setListaHorario(List<HorarioDTO> listaHorario) { this.listaHorario = listaHorario; }
    public HorarioDTO getFiltro() { return filtro; }
    public void setFiltro(HorarioDTO filtro) { this.filtro = filtro; }
    public HorarioDTO getSeleccionado() { return seleccionado; }
    public void setSeleccionado(HorarioDTO seleccionado) { this.seleccionado = seleccionado; }
}