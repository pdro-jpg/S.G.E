package model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor; // Objeto da classe model.Professor
    private Curso curso;       // Objeto da classe model.Curso
    private List<Aluno> listaAlunos; // Lista de objetos da classe model.Aluno

    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
        this.listaAlunos = new ArrayList<>(); // lista vazia
    }

    // Gerenciamento de lunos
    public void adicionarAluno(Aluno aluno) {
        if (aluno != null) {
            this.listaAlunos.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " matriculado na turma " + this.codigo + ".");
        }
    }

    public boolean removerAluno(String matricula) {
        //encontrar o aluno com a matrícula correspondente
        for (int i = 0; i < listaAlunos.size(); i++) {
            if (listaAlunos.get(i).getMatricula().equals(matricula)) {
                String nomeAlunoRemovido = listaAlunos.get(i).getNome();
                listaAlunos.remove(i);
                System.out.println("Aluno " + nomeAlunoRemovido + " (Matrícula: " + matricula + ") removido da turma " + this.codigo + ".");
                return true;
            }
        }
        System.out.println(" Erro:Aluno com matrícula " + matricula + " não encontrado na turma.");
        return false;
    }

    public void mostrarResumoTurma() {
        System.out.println("Código da Turma: " + this.codigo);
        System.out.println("Curso: " + this.curso.getNome() + " (" + this.curso.getCodigo() + ")");
        System.out.println("Professor: " + this.professor.getNome() + " (Especialidade: " + this.professor.getEspecialidade() + ")");
        System.out.println("Quantidade de Alunos Matriculados: " + this.listaAlunos.size());

        System.out.println("\nLista de Alunos (" + this.listaAlunos.size() + ") ---");
        if (this.listaAlunos.isEmpty()) {
            System.out.println("A turma não possui alunos matriculados.");
        } else {
            for (Aluno aluno : listaAlunos) {
                System.out.println(" > " + aluno.getNome() + " - Matrícula: " + aluno.getMatricula());
            }
        }
    }

    public String getCodigo() {
        return codigo;
    }
}