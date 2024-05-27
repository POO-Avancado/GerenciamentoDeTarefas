package View;

import Model.Autenticacao;
import java.util.Scanner;
import Controller.TarefaController;

public class InterfaceUsuario {
    private Scanner scanner;
    private Autenticacao autenticacao;
    private TarefaController tarefaController;
    private String usuarioAutenticado;

    public InterfaceUsuario(Autenticacao autenticacao, TarefaController tarefaController) {
        this.scanner = new Scanner(System.in);
        this.autenticacao = autenticacao;
        this.tarefaController = tarefaController;
        this.usuarioAutenticado = null;
    }

    public void exibirMenu() {
        boolean running = true;

        while (running) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Login");
            System.out.println("3 - Adicionar Tarefa");
            System.out.println("4 - Exibir Tarefas");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    adicionarTarefa();
                    break;
                case 4:
                    exibirTarefas();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void cadastrarUsuario() {
        System.out.println("Digite o nome de usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        autenticacao.cadastrarUsuario(nomeUsuario, senha);
    }

    private void login() {
        System.out.println("Digite o nome de usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        if (autenticacao.autenticarUsuario(nomeUsuario, senha)) {
            usuarioAutenticado = nomeUsuario;
            System.out.println("Login bem-sucedido. Bem-vindo, " + nomeUsuario + "!");
        } else {
            System.out.println("Usuário ou senha incorreto. Tente novamente.");
        }
    }

    private void adicionarTarefa() {
        if (usuarioAutenticado == null) {
            System.out.println("Você precisa estar logado para adicionar tarefas.");
            return;
        }

        System.out.println("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        tarefaController.adicionarTarefa(usuarioAutenticado, descricao);
    }

    private void exibirTarefas() {
        if (usuarioAutenticado == null) {
            System.out.println("Você precisa estar logado para exibir suas tarefas.");
            return;
        }

        tarefaController.exibirTarefas(usuarioAutenticado);
    }
}
