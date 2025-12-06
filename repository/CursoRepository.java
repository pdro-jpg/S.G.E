package repository;
import model.Curso;
import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    private final List<Curso> cursos = new ArrayList<>();

    public void salvar(Curso curso) {
        this.cursos.add(curso);
        System.out.println("Repositorio: Curso " + curso.getNome() + " salvo.");
    }

    public List<Curso> buscarTodos() {
        return new ArrayList<>(this.cursos);
    }

    /**
     * Busca um curso pelo seu código.
     * parametro - codigo O código do curso.
     * retorna - objeto Curso encontrado ou null.
     */
    public Curso buscarPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }
}