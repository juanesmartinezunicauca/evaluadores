package co.unicauca.evaluadores.asignacionevaluadores.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AsignacionPorEstado extends PlantillaAsignacionEvaluadores {

    @Override
    protected Map<Articulo, List<Evaluador>> asignarPorAfinidad(List<Articulo> articulos, List<Evaluador> evaluadores) {
        System.out.println("Asignando evaluadores por afinidad...");
        Map<Articulo, List<Evaluador>> asignaciones = new HashMap<>();

        for (Articulo articulo : articulos) {
            System.out.println("Procesando artículo: " + articulo.getTitulo());
            List<Evaluador> evaluadoresAfines = evaluadores.stream()
                    .filter(ev -> ev.getTemas().stream().anyMatch(articulo.getTemas()::contains))
                    .toList();

            evaluadoresAfines.forEach(ev -> System.out.println("  - Evaluador asignado: " + ev.getNombre()));

            asignaciones.put(articulo, evaluadoresAfines);
        }

        return asignaciones;
    }


    @Override
    protected boolean estaBalanceado(Map<Articulo, List<Evaluador>> balanceados) {
        return balanceados.values().stream().allMatch(lista -> lista.size() <= 3);
    }

    @Override
    protected Map<Articulo, List<Evaluador>> balancearAsignacion(Map<Articulo, List<Evaluador>> balanceados) {
        System.out.println("Balanceando carga...");
        for (Map.Entry<Articulo, List<Evaluador>> entry : balanceados.entrySet()) {
            if (entry.getValue().size() > 3) {
                entry.setValue(entry.getValue().subList(0, 3));
            }
        }
        return balanceados;
    }

        @Override
    protected Map<Articulo, List<Evaluador>> resolverConflictos(Map<Articulo, List<Evaluador>> balanceados) {
        System.out.println("Resolviendo conflictos...");
        Map<Articulo, List<Evaluador>> resultado = new HashMap<>();

        for (Map.Entry<Articulo, List<Evaluador>> entry : balanceados.entrySet()) {
            System.out.println("Procesando artículo: " + entry.getKey().getTitulo());
            List<Evaluador> evaluadoresFiltrados = entry.getValue().stream()
                    .filter(ev -> {
                        // Filtrar evaluadores conflictivos (e.g., institución conflictiva)
                        boolean sinConflicto = !ev.getInstitucion().equals("Institución A");
                        if (!sinConflicto) {
                            System.out.println("  - Eliminando evaluador: " + ev.getNombre() + " por conflicto (Institución A)");
                        }
                        return sinConflicto;
                    })
                    .toList(); // Crear una nueva lista sin los evaluadores conflictivos

            resultado.put(entry.getKey(), evaluadoresFiltrados);

            // Depuración: Imprimir evaluadores restantes
            System.out.println("Evaluadores asignados tras resolver conflictos:");
            evaluadoresFiltrados.forEach(ev -> System.out.println("  - " + ev.getNombre()));
        }

        return resultado;
    }



}
