# Sistema de Gerenciamento Educacional em Java

Projeto desenvolvido com o objetivo de demonstrar os conceitos de **Programação Orientada a Objetos (POO)** e **Arquitetura em Camadas** (Model, Service, Repository, UI) utilizando a linguagem Java.

## Funcionalidades Principais

O sistema permite a gestão básica de dados acadêmicos através de um menu interativo via console.

* **Cadastro:** Alunos, Professores e Cursos (Presencial/EAD).
* **Gestão de Turmas:** Criação de turmas e associação de alunos/professores.
* **Avaliações:** Registro de notas com validação (0.0 a 10.0).
* **Autenticação:** Interface `Autenticavel` implementada para Alunos, Professores e Administradores.
* **Relatórios:** Geração de relatórios detalhados por entidade.

---

## Conceitos de POO e Arquitetura Aplicados

Este projeto é um exemplo prático dos seguintes conceitos de programação:

### 1. Programação Orientada a Objetos (POO)

| Conceito | Exemplo no Código |
| :--- | :--- |
| **Encapsulamento** | Todos os atributos das classes (`Aluno`, `Professor`, `Curso`, `Avaliacao`) são privados, acessíveis apenas via métodos `getters` e `setters`. |
| **Herança** | `Aluno`, `Professor` e `Administrador` herdam de `Usuario`. `CursoPresencial` e `CursoEAD` herdam de `Curso`. |
| **Polimorfismo** | O método `gerarRelatorio()` é implementado de forma diferente em `Aluno`, `Professor` e `Curso`. |
| **Abstração** | Uso da classe `Usuario` (abstrata) e da interface `Autenticavel` para definir contratos. |

### 2. Arquitetura em Camadas

O projeto está organizado em pacotes para garantir a separação de responsabilidades:

| Pacote | Responsabilidade | Descrição |
| :--- | :--- | :--- |
| `model` | Entidades | Contém a estrutura de dados (`Aluno`, `Curso`, `Avaliacao`, `Turma`). |
| `repository` | Acesso a Dados | Gerencia o armazenamento temporário de coleções de objetos (`AlunoRepository`, `TurmaRepository`). **Simula uma base de dados.** |
| `service` | Regra de Negócio | Contém a lógica complexa (`AutenticacaoService`, `MatriculaService`). Orquestra a interação entre `UI` e `Repository`. |
| `ui` | Interface | Ponto de entrada (`Main.java`) e interação com o usuário (menu). |


---

## Como Rodar o Projeto

### Pré-requisitos

* **Java Development Kit (JDK)**: Versão 17 ou superior.

### Execução via IDE (Recomendado)

1.  Clone o repositório:
    ```bash
    git clone https://github.com/pdro-jpg/S.G.E
    ```
2.  Garanta que a estrutura de pacotes (dentro de `src/`) foi reconhecida.
3.  Execute a classe principal: `Main`.

### Execução via Terminal

1.  Navegue até o diretório raiz do projeto.
2.  Compile todos os arquivos Java:
    ```bash
    javac -d bin src/**/*.java
    ```
3.  Execute a classe principal:
    ```bash
    java -cp bin Main
    ```

---

Desenvolvido por: **[Pedro de Oliveira / pdro-jpg]**
