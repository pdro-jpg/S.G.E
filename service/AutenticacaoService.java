package service;
import model.Autenticavel;
import model.Aluno;
import model.Professor;

public class AutenticacaoService {

    // Este serviço não precisa de Repository se a autenticação for baseada no objeto Model
    // Mas poderia ter um UsuarioRepository se fosse buscar credenciais em um DB central.

    /**
     * Tenta autenticar um usuário. A lógica de autenticação é delegada
     * ao próprio objeto (Aluno, Professor, Administrador) via polimorfismo.
     * parametro - usuario O objeto que implementa Autenticavel.
     * retorna true se a autenticação for bem-sucedida.
     */
    public boolean autenticar(Autenticavel usuario, String login, String senha) {
        return usuario.autenticar(login, senha);
    }

    /**
     * Realiza a tentativa de login e retorna uma mensagem de status.
     * Demonstra a aplicação de lógica de negócio (retornar feedback de sucesso/falha).
     */
    public String realizarLogin(Autenticavel usuario, String login, String senha) {
        if (usuario == null) {
            return "FALHA: Usuário não encontrado para este login.";
        }

        if (autenticar(usuario, login, senha)) {
            // Usa instanceof para saber o tipo e dar feedback personalizado
            if (usuario instanceof Aluno) {
                return "SUCESSO: Aluno " + ((Aluno) usuario).getNome() + " logado com êxito.";
            } else if (usuario instanceof Professor) {
                return "SUCESSO: Professor(a) " + ((Professor) usuario).getNome() + " logado com êxito.";
            } else {
                return "SUCESSO: Usuário administrativo logado.";
            }
        }
        return "FALHA: Senha inválida.";
    }
}