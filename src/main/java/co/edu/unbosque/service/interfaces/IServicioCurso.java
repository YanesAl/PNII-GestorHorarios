package co.edu.unbosque.service.interfaces;

import co.edu.unbosque.model.dto.CursoDTO;

import java.util.List;

public interface IServicioCurso {
    void create(CursoDTO curso);
    List<CursoDTO> readAll();
    CursoDTO update(CursoDTO curso);
    void delete(Integer id);
    CursoDTO read(Integer id);

}
