package model;

public abstract class Usuario {
    protected String nome;
    protected String login; //
    protected String senha; // em apps reais usaria hash

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public String getLogin() { return login; }

    public abstract String getTipoUsuario();
}