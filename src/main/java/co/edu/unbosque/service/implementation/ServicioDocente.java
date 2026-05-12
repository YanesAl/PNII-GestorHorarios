package co.edu.unbosque.service.implementation;

import co.edu.unbosque.model.Docente;
import co.edu.unbosque.model.dto.DocenteDTO;
import co.edu.unbosque.service.interfaces.IServicioDocente;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ServicioDocente implements IServicioDocente {

    @PersistenceContext(unitName = "PU-GestorHorarios")
    private EntityManager em;

    @Override
    @Transactional
    public void create(DocenteDTO dto) {

        Docente docente = convertirAEntidad(dto);

        em.persist(docente);
    }

    @Override
    public List<DocenteDTO> readAll() {

        List<Docente> docentes = em
                .createQuery("SELECT d FROM Docente d", Docente.class)
                .getResultList();

        return docentes.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DocenteDTO update(DocenteDTO dto) {

        Docente docente = convertirAEntidad(dto);

        docente = em.merge(docente);

        return convertirADTO(docente);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        Docente docente = em.find(Docente.class, id);

        if (docente != null) {
            em.remove(docente);
        }
    }

    @Override
    public DocenteDTO read(Integer id) {

        Docente docente = em.find(Docente.class, id);

        if (docente == null) {
            return null;
        }

        return convertirADTO(docente);
    }

    private DocenteDTO convertirADTO(Docente docente) {

        DocenteDTO dto = new DocenteDTO();

        dto.setIdPersona(docente.getIdPersona());
        dto.setNombre(docente.getNombre());
        dto.setApellido(docente.getApellido());
        dto.setEscalafon(docente.getEscalafon());
        dto.setTipoVinculacion(docente.getTipoVinculacion());
        dto.setEstadoDocente(docente.getEstadoDocente());

        return dto;
    }

    private Docente convertirAEntidad(DocenteDTO dto) {

        Docente docente = new Docente();

        docente.setIdPersona(dto.getIdPersona());
        docente.setNombre(dto.getNombre());
        docente.setApellido(dto.getApellido());
        docente.setEscalafon(dto.getEscalafon());
        docente.setTipoVinculacion(dto.getTipoVinculacion());
        docente.setEstadoDocente(dto.getEstadoDocente());

        return docente;
    }
}