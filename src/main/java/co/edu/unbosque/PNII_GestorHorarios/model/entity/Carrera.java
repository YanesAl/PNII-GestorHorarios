package co.edu.unbosque.PNII_GestorHorarios.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carreras")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Carrera {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarrera;

    @Column(nullable = false, length = 150)
    private String nombreCarrera;

    @Column(nullable = false, unique = true, length = 20)
    private String codigoCarrera;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "carrera_plan",
               joinColumns = @JoinColumn(name = "id_carrera"),
               inverseJoinColumns = @JoinColumn(name = "id_plan"))
    @Builder.Default
    private List<PlanEstudios> planes = new ArrayList<>();

    public void agregarPlan(PlanEstudios plan) { planes.add(plan); }
    public void eliminarPlan(PlanEstudios plan) { planes.remove(plan); }
    public List<PlanEstudios> obtenerPlanes()   { return planes; }
    public boolean tienePlanesActivos()          { return !planes.isEmpty(); }
}
