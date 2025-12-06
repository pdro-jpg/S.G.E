package model;

public class Professor extends Usuario implements Autenticavel {
    private String nome;
    private String especialidade;
    private String registro;

    public Professor (String nome,String login, String senha, String especialidade, String registro){
        super(nome, login,senha);
        this.nome = nome;
        this.especialidade = especialidade;
        this.registro = registro;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEspecialidade(){
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public String getRegistro(){
        return registro;
    }
    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public void gerarRelatorio() {
        System.out.println("\nRELATÓRIO DO PROFESSOR");
        System.out.println("Nome: " + this.nome);
        System.out.println("Login: " + this.login);
        System.out.println("Especialidade: " + this.especialidade);
        System.out.println("Registro: " + this.registro);
    }

    @Override
    public boolean autenticar(String login, String senha) {
        // Validação: o login e senha fornecidos devem ser iguais aos atributos internos
        return this.login.equals(login) && this.senha.equals(senha);
    }
    @Override
    public String getTipoUsuario() {
        return "Professor";
    }
    @Override
    public String toString() {
        return "model.Professor [Nome: " + nome + ", Especialidade: " + especialidade + ", Registro: " + registro + "]";
    }

}
