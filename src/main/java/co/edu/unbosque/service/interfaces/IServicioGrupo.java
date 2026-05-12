package co.edu.unbosque.service.interfaces;

import co.edu.unbosque.model.dto.GrupoDTO;

import java.util.List;

public interface IServicioGrupo {
    void create(GrupoDTO grupo);
    List<GrupoDTO> readAll();
    GrupoDTO update(GrupoDTO grupo);
    void delete(Integer id);
    GrupoDTO read(Integer id);
}
