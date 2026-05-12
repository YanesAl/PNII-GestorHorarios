package co.edu.unbosque.bean;

import co.edu.unbosque.model.dto.DocenteDTO;
import co.edu.unbosque.model.enums.Escalafon;
import co.edu.unbosque.model.enums.EstadoDocente;
import co.edu.unbosque.model.enums.TipoVinculacion;
import co.edu.unbosque.service.interfaces.IServicioDocente;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class DocenteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IServicioDocente servicioDocente;

    private DocenteDTO docente;
    private List<DocenteDTO> listaDocentes;

    @PostConstruct
    public void init() {
        nuevoDocente();
        cargarListas();
    }

    public void nuevoDocente() {
        docente = new DocenteDTO();
    }

    public void cargarListas() {
        listaDocentes = servicioDocente.readAll();
    }

    public String guardar() {

        try {

            if (docente.getIdPersona() == 0) {
                servicioDocente.create(docente);
            } else {
                servicioDocente.update(docente);
            }

            cargarListas();
            nuevoDocente();

            return "persona?faces-redirect=true";

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void eliminar(Integer id) {

        try {

            servicioDocente.delete(id);
            cargarListas();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(DocenteDTO d) {
        docente = d;
    }

    public Escalafon[] getEscalafones() {
        return Escalafon.values();
    }

    public TipoVinculacion[] getTiposVinculacion() {
        return TipoVinculacion.values();
    }

    public EstadoDocente[] getEstadosDocente() {
        return EstadoDocente.values();
    }

    public DocenteDTO getDocente() {
        return docente;
    }

    public void setDocente(DocenteDTO docente) {
        this.docente = docente;
    }

    public List<DocenteDTO> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(List<DocenteDTO> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }
}