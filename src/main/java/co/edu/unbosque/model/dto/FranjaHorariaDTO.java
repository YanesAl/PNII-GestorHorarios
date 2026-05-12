package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.enums.Categoria;
import co.edu.unbosque.model.enums.DiaSemana;
import co.edu.unbosque.model.enums.EstadoFranja;
import java.time.LocalTime;

public class FranjaHorariaDTO{

    private int idFranja;
    private DiaSemana diaSemana;
    private EstadoFranja estadoFranja;
    private Categoria categoria;
    private LocalTime horaInicio;
    private LocalTime horaFin;


    public int getIdFranja() {
        return idFranja;
    }

    public void setIdFranja(int idFranja) {
        this.idFranja = idFranja;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public EstadoFranja getEstadoFranja() {
        return estadoFranja;
    }

    public void setEstadoFranja(EstadoFranja estadoFranja) {
        this.estadoFranja = estadoFranja;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}