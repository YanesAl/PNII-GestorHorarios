package co.edu.unbosque.model;

import co.edu.unbosque.model.enums.EstadoAula;
import co.edu.unbosque.model.enums.TipoAula;
import jakarta.persistence.*;

@Entity
@Table(name = "aula")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private int idAula;

    @Column(name = "capacidad", nullable = false)
    private int capacidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_aula")
    private TipoAula tipoAula;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_aula")
    private EstadoAula estadoAula;

    @ManyToOne
    @JoinColumn(name = "id_bloque", nullable = false)
    private Bloque bloque;

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

    public Bloque getBloque() {
        return bloque;
    }

    public void setBloque(Bloque bloque) {
        this.bloque = bloque;
    }
}