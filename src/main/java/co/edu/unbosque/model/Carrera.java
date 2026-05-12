package co.edu.unbosque.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "carrera")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private int idCarrera;

    @Column(name = "nombre_carrera", nullable = false)
    private String nombreCarrera;

    @ManyToOne
    @JoinColumn(name = "id_facultad", nullable = false)
    private Facultad facultad;

    @OneToMany(mappedBy = "carrera")
    private List<PlanEstudios> planesEstudios;

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public List<PlanEstudios> getPlanesEstudios() {
        return planesEstudios;
    }

    public void setPlanesEstudios(List<PlanEstudios> planesEstudios) {
        this.planesEstudios = planesEstudios;
    }
}