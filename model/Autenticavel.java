package model;

public interface Autenticavel {
    /**
     * Tenta autenticar um usuário com base no login e senha fornecidos.
     * login O nome de usuário ou identificador.
     * senha A senha do usuário.
     * return true se a autenticação for bem-sucedida, false caso contrário.
     */
    boolean autenticar(String login, String senha);
}