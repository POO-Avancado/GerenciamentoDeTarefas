package Controller;

import Model.Tarefa;
import Model.TarefaRepositorio;
import Model.Autenticacao;

public class TarefaController {
    private Autenticacao autenticacao;
    private TarefaRepositorio tarefaRepositorio;

    public TarefaController(Autenticacao autenticacao, TarefaRepositorio tarefaRepositorio) {
        this.autenticacao = autenticacao;
        this.tarefaRepositorio = tarefaRepositorio;
    }

    public void adicionarTarefa(String usuario, String descricao) {
        Tarefa tarefa = new Tarefa(descricao);
        tarefaRepositorio.adicionarTarefa(usuario, tarefa);
        System.out.println("Tarefa adicionada com sucesso.");
    }

    public void exibirTarefas(String usuario) {
        System.out.println("Tarefas de " + usuario + ":");
        for (Tarefa tarefa : tarefaRepositorio.getTarefas(usuario)) {
            System.out.println(" - " + tarefa.getDescricao());
        }
    }
}
