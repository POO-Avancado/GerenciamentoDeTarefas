package View;

import Model.Autenticacao;
import Model.AutenticacaoHashMap;
import Model.TarefaRepositorio;
import Controller.TarefaController;

public class AutenticacaoTerminal {
    public static void main(String[] args) {
        Autenticacao autenticacao = new AutenticacaoHashMap();
        TarefaRepositorio tarefaRepositorio = new TarefaRepositorio();
        TarefaController tarefaController = new TarefaController(autenticacao, tarefaRepositorio);
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(autenticacao, tarefaController);

        interfaceUsuario.exibirMenu();
    }
}
