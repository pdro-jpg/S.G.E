package service;

import model.Aluno;
import model.Turma;
import repository.AlunoRepository;
import repository.TurmaRepository;

public class MatriculaService {

    // dependências (serão injetadas no construtor)
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    // construtor para injeção de dependência (recebe os repositórios que precisa)
    public MatriculaService(AlunoRepository alunoRepository, TurmaRepository turmaRepository) {
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }

    /**
     * Realiza o processo de matrícula de um aluno em uma turma.
     * Demonstra uma regra de negócio que interage com múltiplos repositórios.
     * parametro - matriculaAluno | A matrícula do aluno a ser matriculado.
     * parametro - codigoTurma | O código da turma de destino.
     * retorna Uma mensagem de status da operação.
     */
    public String matricularAlunoEmTurma(String matriculaAluno, String codigoTurma) {
        // 1. Busca as entidades nos repositórios
        Aluno aluno = alunoRepository.buscarPorMatricula(matriculaAluno);
        Turma turma = turmaRepository.buscarPorCodigo(codigoTurma);

        // regras de negócio
        if (aluno == null) {
            return "ERRO: Aluno com matrícula " + matriculaAluno + " não encontrado.";
        }

        if (turma == null) {
            return "ERRO: Turma com código " + codigoTurma + " não encontrada.";
        }

        // executa a ação (Modificação do Model)
        turma.adicionarAluno(aluno);

        return "SUCESSO: Aluno " + aluno.getNome() + " matriculado na turma " + turma.getCodigo() + ".";
    }
}