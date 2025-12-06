package ui;

import model.Aluno;
import model.Professor;
import model.Curso;
import java.util.Scanner;

public class menuRelatorios {

    /**
     * Exibe o menu interativo e processa as opções de relatório.
     * Esta classe NÃO cria os objetos; ela os recebe como argumento.
     * * @param relataveis Um array contendo as instâncias de Aluno, Professor e Cursos.
     * @param a1 Instância do Aluno a ser usada na Opção 1.
     * @param p1 Instância do Professor a ser usada na Opção 2.
     * @param presencial Instância do Curso Presencial a ser usada na Opção 3.
     * @param ead Instância do Curso EAD a ser usada na Opção 3.
     */
    public static void exibirMenu(Object[] relataveis, Aluno a1, Professor p1, Curso presencial, Curso ead) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("MENU DE RELATÓRIOS");
            System.out.println("1. Gerar Relatório de Aluno (Específico)");
            System.out.println("2. Gerar Relatório de Professor (Específico)");
            System.out.println("3. Gerar Relatório de Cursos (Específicos)");
            System.out.println("4. Gerar TODOS os Relatórios (Polimorfismo)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("\nOpção inválida. Digite um número.");
                scanner.nextLine();
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    a1.gerarRelatorio();
                    break;
                case 2:
                    p1.gerarRelatorio();
                    break;
                case 3:
                    // Casting (conversão) é seguro aqui, pois sabemos o tipo das variáveis
                    presencial.gerarRelatorio();
                    ead.gerarRelatorio();
                    break;
                case 4:
                    gerarRelatoriosMultiplos(relataveis);
                    break;
                case 0:
                    System.out.println("Encerrando o programa de relatórios. Até logo!");
                    break;
                default:
                    System.out.println("\nOpção não reconhecida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    /**
     * Método polimórfico que itera sobre o array de Object e chama gerarRelatorio().
     * (Mantido como estava, pois ele é polimórfico)
     */
    public static void gerarRelatoriosMultiplos(Object[] objetos) {

        System.out.println("   GERANDO RELATÓRIOS MÚLTIPLOS (Opção 4)");

        for (Object obj : objetos) {
            // A verificação instanceof é necessária devido ao array de tipo Object
            if (obj instanceof Aluno) {
                ((Aluno) obj).gerarRelatorio();
            } else if (obj instanceof Professor) {
                ((Professor) obj).gerarRelatorio();
            } else if (obj instanceof Curso) {
                ((Curso) obj).gerarRelatorio();
            }
        }
    }

}