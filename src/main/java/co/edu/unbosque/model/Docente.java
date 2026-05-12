package co.edu.unbosque.model;

import co.edu.unbosque.model.enums.Escalafon;
import co.edu.unbosque.model.enums.EstadoDocente;
import co.edu.unbosque.model.enums.TipoVinculacion;
import jakarta.persistence.*;



@Entity
@Table(name = "docente")
@PrimaryKeyJoinColumn(name = "id_persona")
public class Docente extends Persona {

    @Enumerated(EnumType.STRING)
    @Column(name = "escalafon")
    private Escalafon escalafon;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_vinculacion")
    private TipoVinculacion tipoVinculacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_docente")
    private EstadoDocente estadoDocente;

    @ManyToMany
    @JoinTable(
            name = "docente_franja",
            joinColumns = @JoinColumn(name = "id_docente"),
            inverseJoinColumns = @JoinColumn(name = "id_franja")
    )

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