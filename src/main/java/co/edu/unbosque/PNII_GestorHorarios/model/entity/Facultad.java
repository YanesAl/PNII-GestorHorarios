package co.edu.unbosque.PNII_GestorHorarios.model.entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "facultades")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Facultad {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFacultad;

    @Column(nullable = false, unique = true, length = 150)
    private String nombreFacultad;

    @OneToMany(mappedBy = "facultad", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Area> areas = new ArrayList<>();

    public boolean tieneArea(Area area) {
        return areas.contains(area);
    }

    public List<Area> obtenerAreas() {
        return areas;
    }

    public void agregarArea(Area area) {
        area.setFacultad(this);
        areas.add(area);
    }

    public void eliminarArea(Area area) {
        areas.remove(area);
    }
}
