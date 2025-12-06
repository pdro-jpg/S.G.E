package repository;

import model.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    private final List<Professor> professores = new ArrayList<>();

    public void salvar(Professor professor) {
        this.professores.add(professor);
        System.out.println("Repositorio: Professor " + professor.getNome() + " salvo.");
    }

    public List<Professor> buscarTodos() {
        return new ArrayList<>(this.professores);
    }

    /**
     * busca um professor pelo seu registro.
     * parametro - registro O número de registro do professor.
     * retorna o objeto Professor encontrado ou null.
     */
    public Professor buscarPorRegistro(String registro) {
        for (Professor p : professores) {
            if (p.getRegistro().equals(registro)) {
                return p;
            }
        }
        return null;
    }
}