package repository;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {
    private final List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public List<Aluno> buscarTodos() {
        return new ArrayList<>(this.alunos); // Retorna uma cópia para proteger a lista interna
    }

    // Método de busca simplificado, por exemplo
    public Aluno buscarPorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null; // Não encontrado
    }
}