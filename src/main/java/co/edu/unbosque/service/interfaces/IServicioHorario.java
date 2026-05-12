package co.edu.unbosque.service.interfaces;

import co.edu.unbosque.model.dto.HorarioDTO;

import java.util.List;

public interface IServicioHorario {
    void create(HorarioDTO horario);
    List<HorarioDTO> readAll();
    HorarioDTO read(Integer id);
    HorarioDTO update(HorarioDTO horario);
    void delete(Integer id);
    List<HorarioDTO> generarHorario(HorarioDTO filtro);
}