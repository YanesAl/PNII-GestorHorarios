package co.edu.unbosque.service.implementation;

import co.edu.unbosque.model.Grupo;
import co.edu.unbosque.model.Curso;
import co.edu.unbosque.model.Docente;
import co.edu.unbosque.model.dto.GrupoDTO;
import co.edu.unbosque.service.interfaces.IServicioGrupo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class ServicioGrupo implements IServicioGrupo {

    @PersistenceContext(unitName = "PU-GestorHorarios")
    private EntityManager em;

    @Override
    public void create(GrupoDTO dto) {
        Grupo grupo = convertirAEntidad(dto);
        em.persist(grupo);
        em.flush();
    }

    @Override
    public List<GrupoDTO> readAll() {
        return em.createQuery("SELECT g FROM Grupo g", Grupo.class)
                .getResultList()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    public GrupoDTO update(GrupoDTO dto) {
        Grupo grupo = convertirAEntidad(dto);
        grupo = em.merge(grupo);
        em.flush();
        return convertirADTO(grupo);
    }

    @Override
    public void delete(Integer id) {
        Grupo g = em.find(Grupo.class, id);
        if (g != null) {
            em.remove(g);
            em.flush();
        }
    }

    @Override
    public GrupoDTO read(Integer id) {
        Grupo g = em.find(Grupo.class, id);
        return (g == null) ? null : convertirADTO(g);
    }

    private GrupoDTO convertirADTO(Grupo grupo) {
        GrupoDTO dto = new GrupoDTO();
        dto.setIdGrupo(grupo.getIdGrupo());
        dto.setEstadoGrupo(grupo.getEstadoGrupo());
        dto.setCupoMaximo(grupo.getCupoMaximo());
        dto.setCupoMinimo(grupo.getCupoMinimo());
        dto.setIdCurso(grupo.getCurso() != null ? grupo.getCurso().getIdCurso() : 0);
        dto.setIdDocente(grupo.getDocente() != null ? grupo.getDocente().getIdPersona() : 0);
        return dto;
    }

    private Grupo convertirAEntidad(GrupoDTO dto) {
        Grupo grupo = new Grupo();
        if (dto.getIdGrupo() != 0) grupo.setIdGrupo(dto.getIdGrupo());
        grupo.setEstadoGrupo(dto.getEstadoGrupo());
        grupo.setCupoMaximo(dto.getCupoMaximo());
        grupo.setCupoMinimo(dto.getCupoMinimo());

        if (dto.getIdCurso() != 0) {
            Curso c = em.find(Curso.class, dto.getIdCurso());
            if (c != null) grupo.setCurso(c);
        }
        if (dto.getIdDocente() != 0) {
            Docente d = em.find(Docente.class, dto.getIdDocente());
            if (d != null) grupo.setDocente(d);
        }
        return grupo;
    }
}