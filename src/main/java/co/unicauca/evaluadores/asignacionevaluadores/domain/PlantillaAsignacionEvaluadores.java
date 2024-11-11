package co.unicauca.evaluadores.asignacionevaluadores.domain;

import java.util.List;
import java.util.Map;

public abstract class PlantillaAsignacionEvaluadores {

    public Map<Articulo, List<Evaluador>> asignarEvaluadores(List<Articulo> articulos, List<Evaluador> evaluadores) {
        Map<Articulo, List<Evaluador>> afines = asignarPorAfinidad(articulos, evaluadores);
        Map<Articulo, List<Evaluador>> balanceados = afines;

        while (!estaBalanceado(balanceados)) {
            balanceados = balancearAsignacion(balanceados);
        }

        return resolverConflictos(balanceados);
    }

    protected abstract Map<Articulo, List<Evaluador>> asignarPorAfinidad(List<Articulo> articulos, List<Evaluador> evaluadores);

    protected abstract boolean estaBalanceado(Map<Articulo, List<Evaluador>> balanceados);

    protected abstract Map<Articulo, List<Evaluador>> balancearAsignacion(Map<Articulo, List<Evaluador>> balanceados);

    protected abstract Map<Articulo, List<Evaluador>> resolverConflictos(Map<Articulo, List<Evaluador>> balanceados);
}
