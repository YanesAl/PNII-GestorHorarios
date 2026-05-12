package co.edu.unbosque.service.implementation;

import co.edu.unbosque.model.Curso;
import co.edu.unbosque.model.dto.CursoDTO;
import co.edu.unbosque.service.interfaces.IServicioCurso;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class ServicioCurso implements IServicioCurso {

    @PersistenceContext(unitName = "PU-GestorHorarios")
    private EntityManager em;

    @Override
    @Transactional
    public void create(CursoDTO dto) {

        Curso curso = convertirAEntidad(dto);

        em.persist(curso);
    }

    @Override
    public List<CursoDTO> readAll() {

        List<Curso> cursos = em
                .createQuery("SELECT c FROM Curso c", Curso.class)
                .getResultList();

        return cursos.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CursoDTO update(CursoDTO dto) {

        Curso curso = convertirAEntidad(dto);

        curso = em.merge(curso);

        return convertirADTO(curso);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        Curso curso = em.find(Curso.class, id);

        if (curso != null) {
            em.remove(curso);
        }
    }

    @Override
    public CursoDTO read(Integer id) {

        Curso curso = em.find(Curso.class, id);

        if (curso == null) {
            return null;
        }

        return convertirADTO(curso);
    }

    private CursoDTO convertirADTO(Curso curso) {

        CursoDTO dto = new CursoDTO();

        dto.setIdCurso(curso.getIdCurso());
        dto.setNombreCurso(curso.getNombreCurso());
        dto.setIntensidadHoraria(curso.getIntensidadHoraria());
        dto.setSemestre(curso.getSemestre());
        dto.setCreditos(curso.getCreditos());
        dto.setAulaRequerida(curso.getAulaRequerida());

        return dto;
    }

    private Curso convertirAEntidad(CursoDTO dto) {

        Curso curso = new Curso();

        curso.setIdCurso(dto.getIdCurso());
        curso.setNombreCurso(dto.getNombreCurso());
        curso.setIntensidadHoraria(dto.getIntensidadHoraria());
        curso.setSemestre(dto.getSemestre());
        curso.setCreditos(dto.getCreditos());
        curso.setAulaRequerida(dto.getAulaRequerida());

        return curso;
    }
}