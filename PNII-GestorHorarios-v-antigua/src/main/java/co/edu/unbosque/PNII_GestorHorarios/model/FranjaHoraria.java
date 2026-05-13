package co.edu.unbosque.PNII_GestorHorarios.model;


import java.time.LocalTime;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.Categoria;
import co.edu.unbosque.PNII_GestorHorarios.model.enums.DiaSemana;
import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoFranja;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Entity
    @Table(name = "franja_horaria")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor


public class FranjaHoraria {

  

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFranja;

    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    @Enumerated(EnumType.STRING)
    private EstadoFranja estadoFranja;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;


    private LocalTime horaInicio;
    private LocalTime horaFin;



    public boolean esBloqueada(){
        if (estadoFranja==EstadoFranja.DISPONIBLE){
            return false;
        }
            return true;
    }


    public boolean estaEnRangoPermitido(){
        if(categoria==null || horaInicio==null || horaFin==null){
            return false;
        }


        
       switch (categoria) {
        case DIA:
            return  !horaInicio.isBefore(LocalTime.of(7,0))&& !horaFin.isAfter(LocalTime.of(12, 0));
       
        case TARDE:
            return !horaInicio.isBefore(LocalTime.of(12, 0))&& !horaFin.isAfter(LocalTime.of(18, 0));
         
        case NOCHE:
            return !horaInicio.isBefore(LocalTime.of(18, 0))&& !horaFin.isAfter(LocalTime.of(22, 0));
          

        default:
            return false;
       }
    }




  public void seCruzaCon( FranjaHoraria otraFranja){
//pendiente
  }

    }
