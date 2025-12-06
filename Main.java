// Importa todas as classes necessárias
import model.*;
import repository.*;
import service.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Declaração dos Componentes do Sistema (Camadas)
    private static AlunoRepository alunoRepository;
    private static ProfessorRepository professorRepository;
    private static CursoRepository cursoRepository;
    private static TurmaRepository turmaRepository;
    private static AutenticacaoService AutenticacaoService;
    private static MatriculaService matriculaService;

    private static Scanner scanner;

    /**
     * Inicializa todas as instâncias do sistema e injeta dependências.
     */
    public static void inicializarSistema() {
        // Inicializa Repository
        alunoRepository = new AlunoRepository();
        professorRepository = new ProfessorRepository();
        cursoRepository = new CursoRepository();
        turmaRepository = new TurmaRepository();

        // Inicializa Services
        AutenticacaoService = new AutenticacaoService();
        matriculaService = new MatriculaService(alunoRepository, turmaRepository);

        scanner = new Scanner(System.in);

    }

    // Métodos do Menu interativo

    private static void cadastrarAluno() {
        System.out.println("\n--- Cadastro de Aluno ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Aluno aluno = new Aluno(nome, login, senha, matricula, curso);
        alunoRepository.salvar(aluno);
    }

    private static void cadastrarProfessor() {
        System.out.println("\n--- Cadastro de Professor ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Registro: ");
        String registro = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Professor professor = new Professor(nome, login, senha, especialidade, registro);
        professorRepository.salvar(professor); // Salva no Repository
    }

    private static void cadastrarCurso() {
        System.out.println("\n--- Cadastro de Curso ---");
        System.out.print("Nome do Curso: ");
        String nome = scanner.nextLine();
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Carga Horária (h): ");
        int cargaHoraria = Integer.parseInt(scanner.nextLine());
        System.out.print("Tipo (P=Presencial, E=EAD): ");
        String tipo = scanner.nextLine().toUpperCase();

        if (tipo.equals("P")) {
            System.out.print("Sala de Aula: ");
            String sala = scanner.nextLine();
            cursoPresencial cp = new cursoPresencial(nome, codigo, cargaHoraria, sala);
            cursoRepository.salvar(cp);
        } else if (tipo.equals("E")) {
            System.out.print("Plataforma Virtual: ");
            String plataforma = scanner.nextLine();
            cursoEAD ce = new cursoEAD(nome, codigo, cargaHoraria, plataforma);
            cursoRepository.salvar(ce);
        } else {
            System.out.println("Tipo de curso inválido.");
        }
    }

    private static void criarTurma() {
        System.out.println("\n--- Criação de Turma ---");
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();

        System.out.print("Código do Curso (ex: POO101): ");
        String codigoCurso = scanner.nextLine();
        Curso curso = cursoRepository.buscarPorCodigo(codigoCurso);

        System.out.print("Registro do Professor (ex: P55443): ");
        String regProfessor = scanner.nextLine();
        Professor professor = professorRepository.buscarPorRegistro(regProfessor);

        if (curso != null && professor != null) {
            Turma turma = new Turma(codigoTurma, professor, curso);
            turmaRepository.salvar(turma);
            System.out.println("Turma " + codigoTurma + " criada com sucesso.");
        } else {
            System.out.println("Erro: Curso ou Professor não encontrados.");
        }
    }

    private static void associarAlunoTurma() {
        System.out.println("\n--- Associação Aluno-Turma ---");
        System.out.print("Matrícula do Aluno: ");
        String matricula = scanner.nextLine();
        System.out.print("Código da Turma: ");
        String codigoTurma = scanner.nextLine();

        String resultado = matriculaService.matricularAlunoEmTurma(matricula, codigoTurma);
        System.out.println(resultado);
    }

    private static void registrarAvaliacao() {
        System.out.println("\n--- Registro de Avaliação ---");
        System.out.print("Matrícula do Aluno: ");
        String matricula = scanner.nextLine();
        Aluno aluno = alunoRepository.buscarPorMatricula(matricula);

        if (aluno != null) {
            System.out.print("Código da Turma: ");
            String codigoTurma = scanner.nextLine();
            System.out.print("Descrição da Avaliação: ");
            String descricao = scanner.nextLine();
            System.out.print("Nota (0.0 a 10.0): ");
            double nota = Double.parseDouble(scanner.nextLine());

            Avaliacao avaliacao = new Avaliacao(descricao, nota);

            // Aqui você usaria um Service para adicionar a avaliação, mas faremos direto no Model para simplificar a UI
            aluno.adicionarAvaliacao(codigoTurma, descricao, avaliacao);
            System.out.println("Avaliação registrada para " + aluno.getNome());

        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void gerarRelatoriosGerais() {
        System.out.println("\n--- Relatórios Gerais ---");

        // lista completa alunos
        List<Aluno> listaAlunos = alunoRepository.buscarTodos();
        List<Professor> listaProfessores = professorRepository.buscarTodos();
        List<Curso> listaCursos = cursoRepository.buscarTodos();
        List<Turma> listaTurmas = turmaRepository.buscarTodos();

        //relatório de alunos totais
        System.out.println("\n[TOTAIS DO SISTEMA]");
        System.out.println("Total de Alunos Cadastrados: " + listaAlunos.size());
        System.out.println("Total de Professores Cadastrados: " + listaProfessores.size());
        System.out.println("Total de Cursos Cadastrados: " + listaCursos.size());
        System.out.println("Total de Turmas Criadas: " + listaTurmas.size());

        //Relatório Detalhado de Alunos
        System.out.println("\n[RELATÓRIO DETALHADO DE ALUNOS]");
        if (listaAlunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado para exibir detalhes.");
            return;
        }

        // itera sobre todos os alunos e chama o relatório para cada um.
        for (Aluno aluno : listaAlunos) {
            aluno.gerarRelatorio();
            aluno.mostrarTodasAvaliacoes();
        }
    }
    // --- 3. Menu Principal ---

    public static void main(String[] args) {
        inicializarSistema();

        // Dados de teste para cenários de sucesso e falha
        classeTeste.runInitialSetup(alunoRepository, professorRepository, cursoRepository, turmaRepository);

        int opcao;

        do {
            System.out.println("\nMENU PRINCIPAL DO SISTEMA EDUCACIONAL");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Curso");
            System.out.println("4. Criar Turma");
            System.out.println("5. Associar Aluno à Turma (Matricular)");
            System.out.println("6. Registrar Avaliação");
            System.out.println("7. Gerar Relatórios Gerais");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarProfessor();
                    break;
                case 3:
                    cadastrarCurso();
                    break;
                case 4:
                    criarTurma();
                    break;
                case 5:
                    associarAlunoTurma();
                    break;
                case 6:
                    registrarAvaliacao();
                    break;
                case 7:
                    gerarRelatoriosGerais();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }


    static class classeTeste {
        public static void runInitialSetup(AlunoRepository ar, ProfessorRepository pr, CursoRepository cr, TurmaRepository tr) {
            System.out.println("\n--- INICIALIZAÇÃO DE DADOS DE TESTE ---");

            // Setup para Cenários de Sucesso/Falha
            Professor prof = new Professor("Prof. Teste", "teste.p", "123", "Engenhnaria de Software", "P999");
            pr.salvar(prof);

            cursoPresencial curso = new cursoPresencial("POO", "POO101", 80, "200-A");
            cr.salvar(curso);

            Aluno alunoSucesso = new Aluno("Jamal Silva", "24551232-5", "POO", "jamal.s", "12345");
            ar.salvar(alunoSucesso); // Aluno existe

            Turma turmaSucesso = new Turma("POO101", prof, curso);
            tr.salvar(turmaSucesso);

            System.out.println("Dados de teste carregados (Aluno Jamal, Turma POO101).");
        }
    }
}