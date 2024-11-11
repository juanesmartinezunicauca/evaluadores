import co.unicauca.evaluadores.asignacionevaluadores.domain.Articulo;
import co.unicauca.evaluadores.asignacionevaluadores.domain.AsignacionPorEstado;
import co.unicauca.evaluadores.asignacionevaluadores.domain.Evaluador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AsignacionEvaluadores {
    public static void main(String[] args) {
                // Crear listas de artículos y evaluadores
        List<Articulo> articulos = new ArrayList<>();
        List<Evaluador> evaluadores = new ArrayList<>();

        // Datos de prueba
        articulos.add(new Articulo("Artículo 1", List.of("tema1", "tema2")));
        articulos.add(new Articulo("Artículo 2", List.of("tema2", "tema3")));

        evaluadores.add(new Evaluador("Evaluador 1", List.of("tema1"), "Institución A"));
        evaluadores.add(new Evaluador("Evaluador 2", List.of("tema2", "tema3"), "Institución B"));
        evaluadores.add(new Evaluador("Evaluador 3", List.of("tema1", "tema3"), "Institución C"));


        // Reemplazar 'var' con tipo explícito
        AsignacionPorEstado asignacion = new AsignacionPorEstado();
        Map<Articulo, List<Evaluador>> resultado = asignacion.asignarEvaluadores(articulos, evaluadores);

        // Imprimir resultados
        for (Map.Entry<Articulo, List<Evaluador>> entry : resultado.entrySet()) {
            System.out.println("Artículo: " + entry.getKey().getTitulo());
            for (Evaluador evaluador : entry.getValue()) {
                System.out.println("  - Evaluador: " + evaluador.getNombre());
            }
        }
    }
}
