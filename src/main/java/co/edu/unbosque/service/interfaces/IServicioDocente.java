package co.edu.unbosque.service.interfaces;
import co.edu.unbosque.model.dto.DocenteDTO;

import java.util.List;

public interface IServicioDocente {
    void create(DocenteDTO docenteDTO);
    List<DocenteDTO> readAll();
    DocenteDTO update(DocenteDTO docenteDTO);
    void delete(Integer id);
    DocenteDTO read(Integer id);
}
