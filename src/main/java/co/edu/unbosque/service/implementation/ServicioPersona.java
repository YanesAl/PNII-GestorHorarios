package co.edu.unbosque.service.implementation;

import co.edu.unbosque.model.Persona;
import co.edu.unbosque.model.dto.PersonaDTO;
import co.edu.unbosque.service.interfaces.IServicioPersona;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class ServicioPersona implements IServicioPersona {

    @PersistenceContext(unitName = "PU-GestorHorarios")
    private EntityManager em;

    @Override
    @Transactional
    public void create(PersonaDTO dto) {
        em.persist(convertirAEntidad(dto));
    }

    @Override
    public List<PersonaDTO> readAll() {
        return em.createQuery("SELECT p FROM Persona p", Persona.class)
                .getResultList()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PersonaDTO update(PersonaDTO dto) {
        Persona persona = em.merge(convertirAEntidad(dto));
        return convertirADTO(persona);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Persona persona = em.find(Persona.class, id);
        if (persona != null) {
            em.remove(em.contains(persona) ? persona : em.merge(persona));
        }
    }

    @Override
    public PersonaDTO read(Integer id) {
        Persona persona = (id == null) ? null : em.find(Persona.class, id);
        return persona == null ? null : convertirADTO(persona);
    }


    private PersonaDTO convertirADTO(Persona persona) {

        PersonaDTO dto = new PersonaDTO();

        dto.setIdPersona(persona.getIdPersona());
        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());

        return dto;
    }

    private Persona convertirAEntidad(PersonaDTO dto) {

        Persona persona = new Persona();

        persona.setIdPersona(dto.getIdPersona());
        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());

        return persona;
    }
}