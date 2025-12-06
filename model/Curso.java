package model;

public class Curso {
    private String nome;
    private String codigo;
    private int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria){
      this.nome = nome;
      this.codigo = codigo;
      this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }


    public void gerarRelatorio() {
        System.out.println("RELATÓRIO DO CURSO");
        System.out.println(this.detalharCurso());
    }


    public String detalharCurso() {
        return "Curso: " + nome +
                " Código: " + codigo +
                " Carga Horária: " + cargaHoraria + "h";
    }

    @Override
    public String toString() {
        return "model.Curso [Nome: " + nome + ", Código: " + codigo + ", Carga Horária: " + cargaHoraria + " horas]";
    }
}
