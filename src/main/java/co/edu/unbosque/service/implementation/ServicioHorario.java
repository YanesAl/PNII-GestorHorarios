package co.edu.unbosque.service.implementation;

import co.edu.unbosque.model.Seccion;
import co.edu.unbosque.model.dto.HorarioDTO;
import co.edu.unbosque.service.interfaces.IServicioHorario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class ServicioHorario implements IServicioHorario {

    @PersistenceContext(unitName = "PU-GestorHorarios")
    private EntityManager em;

    @Override
    public void create(HorarioDTO horario) {}

    @Override
    public List<HorarioDTO> readAll() {
        return generarHorario(new HorarioDTO());
    }

    @Override
    public HorarioDTO update(HorarioDTO horario) {
        return horario;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Seccion sec = em.find(Seccion.class, id);
        if (sec != null) {
            em.remove(sec);
        }
    }

    @Override
    public HorarioDTO read(Integer id) {
        return null;
    }

    @Override
    public List<HorarioDTO> generarHorario(HorarioDTO filtro) {
        List<Seccion> secciones = em.createQuery(
                "SELECT s FROM Seccion s " +
                        "JOIN FETCH s.grupo " +
                        "JOIN FETCH s.grupo.curso " +
                        "JOIN FETCH s.grupo.docente " +
                        "JOIN FETCH s.aula " +
                        "JOIN FETCH s.aula.bloque " +
                        "JOIN FETCH s.franjaHoraria",
                Seccion.class
        ).getResultList();

        return secciones.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    private HorarioDTO convertirADTO(Seccion sec) {
        HorarioDTO dto = new HorarioDTO();

        dto.setIdSeccion(sec.getIdSeccion());

        if (sec.getGrupo() != null && sec.getGrupo().getCurso() != null) {
            dto.setNombreCurso(sec.getGrupo().getCurso().getNombreCurso());
        } else {
            dto.setNombreCurso("SIN CURSO");
        }

        if (sec.getGrupo() != null && sec.getGrupo().getDocente() != null) {
            dto.setNombreDocente(
                    sec.getGrupo().getDocente().getNombre() + " " +
                            sec.getGrupo().getDocente().getApellido()
            );
        } else {
            dto.setNombreDocente("SIN DOCENTE");
        }

        if (sec.getAula() != null) {
            dto.setNombreAula("Aula " + sec.getAula().getIdAula() +
                    " (" + sec.getAula().getTipoAula() + ")");
        } else {
            dto.setNombreAula("SIN AULA");
        }

        if (sec.getAula() != null && sec.getAula().getBloque() != null) {
            dto.setNombreBloque(sec.getAula().getBloque().getNombreBloque());
        } else {
            dto.setNombreBloque("SIN BLOQUE");
        }

        if (sec.getFranjaHoraria() != null) {
            dto.setDiaSemana(sec.getFranjaHoraria().getDiaSemana().name());
            dto.setHoraInicio(sec.getFranjaHoraria().getHoraInicio().toString());
            dto.setHoraFin(sec.getFranjaHoraria().getHoraFin().toString());
            dto.setCategoria(sec.getFranjaHoraria().getCategoria().name());
        } else {
            dto.setDiaSemana("SIN DIA");
            dto.setHoraInicio("SIN HORA");
            dto.setHoraFin("SIN HORA");
            dto.setCategoria("SIN CATEGORIA");
        }

        dto.setEstadoSeccion(sec.getEstadoSeccion() != null
                ? sec.getEstadoSeccion().name()
                : "SIN ESTADO");

        return dto;
    }
}