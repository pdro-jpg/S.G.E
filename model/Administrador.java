package model;

public class Administrador extends Usuario implements Autenticavel {
    private String setor;

    public Administrador(String nome, String login, String senha, String setor) {
        super(nome, login, senha); //construtor de model.Usuario
        this.setor = setor;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        // login e senha fornecidos devem ser iguais aos atributos internos
        return this.login.equals(login) && this.senha.equals(senha);
    }

    @Override
    public String getTipoUsuario() {
        return "Administrador";
    }

    public String getSetor() { return setor; }
}