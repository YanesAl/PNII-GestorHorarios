//http://localhost:8080/PNII-GestorHorarios/
//http://localhost/phpmyadmin/
package co.edu.unbosque.bean;

import co.edu.unbosque.model.dto.GrupoDTO;
import co.edu.unbosque.model.enums.EstadoGrupo;
import co.edu.unbosque.service.interfaces.IServicioGrupo;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class GrupoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IServicioGrupo servicioGrupo;

    private GrupoDTO grupo;
    private GrupoDTO seleccionado;
    private List<GrupoDTO> listaGrupos;

    @PostConstruct
    public void init() {
        nuevo();
        cargarDatos();
    }

    public void cargarDatos() {
        listaGrupos = servicioGrupo.readAll();
    }

    public void nuevo() {
        grupo = new GrupoDTO();
        seleccionado = null;
    }

    public void guardar() {
        if (grupo.getIdGrupo() == 0) {
            servicioGrupo.create(grupo);
        } else {
            servicioGrupo.update(grupo);
        }
        cargarDatos();
        nuevo();
    }

    public void eliminar() {
        if (seleccionado != null) {
            servicioGrupo.delete(seleccionado.getIdGrupo());
            cargarDatos();
            nuevo();
        }
    }

    public void seleccionarFila() {
        if (seleccionado != null) {
            grupo = seleccionado;
        }
    }

    public EstadoGrupo[] getEstadosGrupo() {
        return EstadoGrupo.values();
    }

    public GrupoDTO getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoDTO grupo) {
        this.grupo = grupo;
    }

    public GrupoDTO getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(GrupoDTO seleccionado) {
        this.seleccionado = seleccionado;
    }

    public List<GrupoDTO> getListaGrupos() {
        return listaGrupos;
    }

    public void setListaGrupos(List<GrupoDTO> listaGrupos) {
        this.listaGrupos = listaGrupos;
    }
}