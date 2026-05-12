package co.edu.unbosque.service.implementation;

import co.edu.unbosque.model.Estudiante;
import co.edu.unbosque.model.dto.EstudianteDTO;
import co.edu.unbosque.service.interfaces.IServicioEstudiante;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class ServicioEstudiante implements IServicioEstudiante {

    @PersistenceContext(unitName = "PU-GestorHorarios")
    private EntityManager em;

    @Override
    @Transactional
    public void create(EstudianteDTO dto) {

        Estudiante estudiante = convertirAEntidad(dto);

        em.persist(estudiante);
    }

    @Override
    public List<EstudianteDTO> readAll() {

        List<Estudiante> estudiantes = em
                .createQuery("SELECT e FROM Estudiante e", Estudiante.class)
                .getResultList();

        return estudiantes.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EstudianteDTO update(EstudianteDTO dto) {

        Estudiante estudiante = convertirAEntidad(dto);

        estudiante = em.merge(estudiante);

        return convertirADTO(estudiante);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        Estudiante estudiante = em.find(Estudiante.class, id);

        if (estudiante != null) {
            em.remove(estudiante);
        }
    }

    @Override
    public EstudianteDTO read(Integer id) {

        Estudiante estudiante = em.find(Estudiante.class, id);

        if (estudiante == null) {
            return null;
        }

        return convertirADTO(estudiante);
    }

    private EstudianteDTO convertirADTO(Estudiante estudiante) {

        EstudianteDTO dto = new EstudianteDTO();

        dto.setIdPersona(estudiante.getIdPersona());
        dto.setNombre(estudiante.getNombre());
        dto.setApellido(estudiante.getApellido());
        dto.setCorreo(estudiante.getCorreo());
        dto.setSemestreCursa(estudiante.getSemestreCursa());
        dto.setEstadoEstudiante(estudiante.getEstadoEstudiante());
        dto.setCreditosAprobados(estudiante.getCreditosAprobados());

        return dto;
    }

    private Estudiante convertirAEntidad(EstudianteDTO dto) {

        Estudiante estudiante = new Estudiante();

        estudiante.setIdPersona(dto.getIdPersona());
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellido(dto.getApellido());
        estudiante.setCorreo(dto.getCorreo());
        estudiante.setSemestreCursa(dto.getSemestreCursa());
        estudiante.setEstadoEstudiante(dto.getEstadoEstudiante());
        estudiante.setCreditosAprobados(dto.getCreditosAprobados());

        return estudiante;
    }
}