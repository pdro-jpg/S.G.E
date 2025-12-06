package repository;

import model.Turma;
import java.util.ArrayList;
import java.util.List;

public class TurmaRepository {
    private final List<Turma> turmas = new ArrayList<>();

    public void salvar(Turma turma) {
        this.turmas.add(turma);
        System.out.println("Repositorio: Turma " + turma.getCodigo() + " salva.");
    }

    public List<Turma> buscarTodos() {
        return new ArrayList<>(this.turmas);
    }

    /**
     * Busca uma turma pelo seu código.
     * parametro - codigo O código da turma.
     * retorna objeto Turma encontrado ou null.
     */
    public Turma buscarPorCodigo(String codigo) {
        for (Turma t : turmas) {
            if (t.getCodigo().equals(codigo)) {
                return t;
            }
        }
        return null;
    }
}