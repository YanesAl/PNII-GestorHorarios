package co.edu.unbosque.service.interfaces;
import co.edu.unbosque.model.dto.SeccionDTO;

import java.util.List;

public interface IServicioSeccion {
    void create(SeccionDTO seccionDTO);
    List<SeccionDTO> readAll();
    SeccionDTO update(SeccionDTO seccionDTO);
    void delete(Integer id);
    SeccionDTO read(Integer id);
}
