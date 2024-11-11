package co.unicauca.evaluadores.asignacionevaluadores.domain;

import java.util.List;

public class Articulo {
    private String titulo;
    private List<String> temas;

    public Articulo(String titulo, List<String> temas) {
        this.titulo = titulo;
        this.temas = temas;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<String> getTemas() {
        return temas;
    }
}
