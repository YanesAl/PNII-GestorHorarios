package co.edu.unbosque.model.dto;
import co.edu.unbosque.model.enums.EstadoAula;
import co.edu.unbosque.model.enums.TipoAula;

public class AulaDTO{


    private int idAula;
    private int capacidad;
    private TipoAula tipoAula;
    private EstadoAula estadoAula;
    private int idBloque;

    public int getIdAula() {

        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public TipoAula getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(TipoAula tipoAula) {
        this.tipoAula = tipoAula;
    }

    public EstadoAula getEstadoAula() {
        return estadoAula;
    }

    public void setEstadoAula(EstadoAula estadoAula) {
        this.estadoAula = estadoAula;
    }

    public int getIdBloque() {
        return idBloque;
    }

    public void setIdBloque(int idBloque) {
        this.idBloque = idBloque;
    }
}