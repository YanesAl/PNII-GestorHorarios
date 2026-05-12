package co.edu.unbosque.bean;

import co.edu.unbosque.model.dto.PersonaDTO;
import co.edu.unbosque.service.interfaces.IServicioPersona;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PersonaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IServicioPersona servicioPersona;

    private PersonaDTO persona;
    private List<PersonaDTO> listaPersonas;
    private String tipoPersona;

    @PostConstruct
    public void init() {
        nuevaPersona();
        cargarDatos();
    }

    public void cargarDatos() {
        listaPersonas = servicioPersona.readAll();
    }

    public void nuevaPersona() {
        persona = new PersonaDTO();
        tipoPersona = "";
    }

    public String prepararRegistroDetallado() {

        if ("PERSONA".equals(tipoPersona)) {
            guardar();
            return "persona?faces-redirect=true";
        }

        if ("DOCENTE".equals(tipoPersona)) {
            return "docente?faces-redirect=true";
        }

        if ("ESTUDIANTE".equals(tipoPersona)) {
            return "estudiante?faces-redirect=true";
        }

        return null;
    }

    public void guardar() {

        try {

            if (persona.getIdPersona() == 0) {
                servicioPersona.create(persona);
            } else {
                servicioPersona.update(persona);
            }

            cargarDatos();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public List<PersonaDTO> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<PersonaDTO> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
}