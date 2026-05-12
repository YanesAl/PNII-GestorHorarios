package co.edu.unbosque.service.implementation;

import co.edu.unbosque.model.Seccion;
import co.edu.unbosque.model.dto.SeccionDTO;
import co.edu.unbosque.service.interfaces.IServicioSeccion;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class ServicioSeccion implements IServicioSeccion {

    @PersistenceContext(unitName = "PU-GestorHorarios")
    private EntityManager em;

    @Override
    public void create(SeccionDTO dto) {

        Seccion seccion = convertirAEntidad(dto);
        em.persist(seccion);
    }

    @Override
    public List<SeccionDTO> readAll() {

        return em.createQuery("SELECT s FROM Seccion s", Seccion.class)
                .getResultList()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    public SeccionDTO update(SeccionDTO dto) {

        Seccion seccion = convertirAEntidad(dto);
        seccion = em.merge(seccion);

        return convertirADTO(seccion);
    }

    @Override
    public void delete(Integer id) {

        Seccion seccion = em.find(Seccion.class, id);

        if (seccion != null) {
            em.remove(seccion);
        }
    }

    @Override
    public SeccionDTO read(Integer id) {

        Seccion seccion = em.find(Seccion.class, id);

        if (seccion == null) {
            return null;
        }

        return convertirADTO(seccion);
    }


    private SeccionDTO convertirADTO(Seccion sec) {

        SeccionDTO dto = new SeccionDTO();

        dto.setIdSeccion(sec.getIdSeccion());
        dto.setEstadoSeccion(sec.getEstadoSeccion());

        dto.setIdGrupo(sec.getGrupo() != null ? sec.getGrupo().getIdGrupo() : 0);
        dto.setIdAula(sec.getAula() != null ? sec.getAula().getIdAula() : 0);
        dto.setIdFranjaHoraria(sec.getFranjaHoraria() != null ? sec.getFranjaHoraria().getIdFranja() : 0);

        return dto;
    }

    private Seccion convertirAEntidad(SeccionDTO dto) {

        Seccion sec = new Seccion();

        sec.setIdSeccion(dto.getIdSeccion());
        sec.setEstadoSeccion(dto.getEstadoSeccion());

        if (dto.getIdGrupo() != 0) {
            sec.setGrupo(em.find(co.edu.unbosque.model.Grupo.class, dto.getIdGrupo()));
        }

        if (dto.getIdAula() != 0) {
            sec.setAula(em.find(co.edu.unbosque.model.Aula.class, dto.getIdAula()));
        }

        if (dto.getIdFranjaHoraria() != 0) {
            sec.setFranjaHoraria(em.find(co.edu.unbosque.model.FranjaHoraria.class, dto.getIdFranjaHoraria()));
        }

        return sec;
    }
}