package co.edu.unbosque.PNII_GestorHorarios.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "areas")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@ToString(exclude = "facultad")
@EqualsAndHashCode(exclude = "facultad")
public class Area {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArea;

    @Column(nullable = false, length = 150)
    private String nombreArea;

    @Column(length = 300)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_facultad")
    private Facultad facultad;

    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL)
    @Builder.Default
    private List<PlanEstudios> planes = new ArrayList<>();

    public void agregarPlan(PlanEstudios plan) { planes.add(plan); plan.setArea(this); }
    public void removerPlan(PlanEstudios plan)  { planes.remove(plan); }
    public List<PlanEstudios> obtenerPlanes()   { return planes; }
    public Facultad obtenerFacultad()            { return facultad; }
}
