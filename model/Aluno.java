package model;

import java.util.HashMap;
import java.util.Map;

public class Aluno extends Usuario implements Autenticavel {
    private String nome;
    private String matricula;
    private String curso;
    private Map<String, Map<String, Avaliacao>> avaliacoesPorTurma;

    public Aluno(String nome, String matricula, String curso, String login, String senha) {
        super(nome, login, senha);
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.avaliacoesPorTurma = new HashMap<>();
    }

    public void adicionarAvaliacao(String codigoTurma, String descricaoAvaliacao, Avaliacao avaliacao) {
        // 1. Verifica se já existe um mapa de avaliações para esta turma.
        avaliacoesPorTurma.putIfAbsent(codigoTurma, new HashMap<>());
        Map<String, Avaliacao> avaliacoesDaTurma = avaliacoesPorTurma.get(codigoTurma);
        avaliacoesDaTurma.put(descricaoAvaliacao, avaliacao);
        System.out.println("Avaliação '" + descricaoAvaliacao + "' para a turma " + codigoTurma + " adicionada a " + this.nome + ".");
    }

    public void mostrarTodasAvaliacoes() {
        System.out.println("Avaliações registradas para " + this.nome + ":");
        if (avaliacoesPorTurma.isEmpty()) {
            System.out.println("Nenhuma avaliação registrada em nenhuma turma.");
            return;
        }

        // Itera sobre as turmas
        for (Map.Entry<String, Map<String, Avaliacao>> entradaTurma : avaliacoesPorTurma.entrySet()) {
            String codigoTurma = entradaTurma.getKey();
            Map<String, Avaliacao> avaliacoes = entradaTurma.getValue();

            System.out.println("\nmodel.Turma: " + codigoTurma + " (" + avaliacoes.size() + " avaliações):");

            // Itera sobre as avaliações dentro de cada turma
            for (Avaliacao aval : avaliacoes.values()) {
                System.out.println("    - " + aval.toString());
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void gerarRelatorio() {
        System.out.println("\nRELATÓRIO DO ALUNO");
        System.out.println("Nome: " + this.nome);
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Curso: " + this.curso);
        System.out.println("Tipo de Usuário: " + this.getTipoUsuario());
    }

    @Override
    public boolean autenticar(String login, String senha) {
        // Validação: o login e senha fornecidos devem ser iguais aos atributos internos
        return this.login.equals(login) && this.senha.equals(senha);
    }

    @Override
    public String getTipoUsuario() {
        return "Aluno";
    }

    @Override
    public String toString() {
        return "model.Aluno [Nome: " + nome + ", Matrícula: " + matricula + ", model.Curso: " + curso + "]";
    }
}

