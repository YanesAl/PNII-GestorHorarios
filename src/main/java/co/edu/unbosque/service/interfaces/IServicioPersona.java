package co.edu.unbosque.service.interfaces;

import co.edu.unbosque.model.dto.PersonaDTO;
import java.util.List;

public interface IServicioPersona {
    void create(PersonaDTO persona);
    List<PersonaDTO> readAll();
    PersonaDTO update(PersonaDTO persona);
    void delete(Integer id);
    PersonaDTO read(Integer id);
}
