package model;

public class cursoEAD extends Curso {
    private String plataformaVirtual;

    public cursoEAD(String nome, String codigo, int cargaHoraria, String plataformaVirtual) {
        // Chamada ao construtor da superclasse (model.Curso)
        super(nome, codigo, cargaHoraria);
        this.plataformaVirtual = plataformaVirtual;
    }

    // Sobrescrita do método detalharCurso()
    @Override
    public String detalharCurso() {
        // Chama a implementação do pai e adiciona a informação específica
        return super.detalharCurso() +
                " | Tipo: EAD" +
                " | Plataforma: " + this.plataformaVirtual;
    }

    public String getPlataformaVirtual() {
        return plataformaVirtual;
    }
}