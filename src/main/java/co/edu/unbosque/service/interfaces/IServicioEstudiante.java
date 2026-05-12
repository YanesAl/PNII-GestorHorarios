package co.edu.unbosque.service.interfaces;

import co.edu.unbosque.model.dto.EstudianteDTO;

import java.util.List;

public interface IServicioEstudiante {
    void create(EstudianteDTO estudiante);
    List<EstudianteDTO> readAll();
    EstudianteDTO update(EstudianteDTO estudiante);
    void delete(Integer id);
    EstudianteDTO read(Integer id);
}
