package model;

public class Avaliacao {
    private double nota;
    private String descricao;

    public Avaliacao(String descricao, double notaInicial) {
        this.descricao = descricao;
        this.atribuirNota(notaInicial);
    }

    // atribuir/atualizar a Nota (com validação) ---

    public void atribuirNota(double valor) {
        if (valor >= 0.0 && valor <= 10.0) {
            this.nota = valor;
           System.out.println("Nota atribuída com sucesso: " + valor);
        } else {
            System.err.println("Erro de Validação: A nota deve ser um valor entre 0.0 e 10.0. (Valor fornecido: " + valor + ")");
            //mantém a nota anterior em caso de erro
        }
    }
    public double getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Avaliacao [Descrição: " + descricao + ", Nota: " + String.format("%.1f", nota) + "]";
    }
}