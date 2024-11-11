package co.unicauca.evaluadores.asignacionevaluadores.domain;

import java.util.List;

public class Evaluador{
    private String nombre;
    private List<String> temas;
    private String institucion;

    public Evaluador(String nombre, List<String> temas, String institucion) {
        this.nombre = nombre;
        this.temas = temas;
        this.institucion = institucion;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getTemas() {
        return temas;
    }

    public String getInstitucion() {
        return institucion;
    }
}
