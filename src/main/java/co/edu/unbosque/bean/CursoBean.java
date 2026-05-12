package co.edu.unbosque.bean;

import co.edu.unbosque.model.dto.CursoDTO;
import co.edu.unbosque.model.enums.TipoAula;
import co.edu.unbosque.service.interfaces.IServicioCurso;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CursoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IServicioCurso servicioCurso;

    private CursoDTO curso;
    private List<CursoDTO> listaCursos;

    @PostConstruct
    public void init() {
        limpiar();
        cargarCursos();
    }

    public void cargarCursos() {
        listaCursos = servicioCurso.readAll();
    }

    public TipoAula[] getTiposAula() {
        return TipoAula.values();
    }

    public void guardarCurso() {
        try {
            if (curso.getIdCurso() == 0) {
                servicioCurso.create(curso);
            } else {
                servicioCurso.update(curso);
            }
            cargarCursos();
            limpiar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarCurso(CursoDTO c) {
        servicioCurso.delete(c.getIdCurso());
        cargarCursos();
    }

    public void editarCurso(CursoDTO c) {
        this.curso = c;
    }

    public void limpiar() {
        this.curso = new CursoDTO();
    }

    public CursoDTO getCurso() {
        return curso;
    }

    public void setCurso(CursoDTO curso) {
        this.curso = curso;
    }

    public List<CursoDTO> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<CursoDTO> listaCursos) {
        this.listaCursos = listaCursos;
    }
}