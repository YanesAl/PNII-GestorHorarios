package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.enums.Escalafon;
import co.edu.unbosque.model.enums.EstadoDocente;
import co.edu.unbosque.model.enums.TipoVinculacion;

public class DocenteDTO extends PersonaDTO {


    private Escalafon escalafon;
    private TipoVinculacion tipoVinculacion;
    private EstadoDocente estadoDocente;


    public Escalafon getEscalafon() {
        return escalafon;
    }

    public void setEscalafon(Escalafon escalafon) {
        this.escalafon = escalafon;
    }

    public TipoVinculacion getTipoVinculacion() {
        return tipoVinculacion;
    }

    public void setTipoVinculacion(TipoVinculacion tipoVinculacion) {
        this.tipoVinculacion = tipoVinculacion;
    }

    public EstadoDocente getEstadoDocente() {
        return estadoDocente;
    }

    public void setEstadoDocente(EstadoDocente estadoDocente) {
        this.estadoDocente = estadoDocente;
    }
}