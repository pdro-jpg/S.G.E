package model;

public class cursoPresencial extends Curso {
    private String salaDeAula;

    public cursoPresencial(String nome, String codigo, int cargaHoraria, String salaDeAula) {
        // Chamada ao construtor da superclasse (model.Curso)
        super(nome, codigo, cargaHoraria);
        this.salaDeAula = salaDeAula;
    }

    // Sobrescrita do método detalharCurso()

    @Override
    public String detalharCurso() {
        // Chama a implementação do pai e adiciona a informação específica
        return super.detalharCurso() +
                " | Tipo: Presencial" +
                " | Local:  " + this.salaDeAula;
    }

    public String getSalaDeAula() {
        return salaDeAula;
    }
}