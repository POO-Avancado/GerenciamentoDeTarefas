package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TarefaRepositorio {
    private HashMap<String, List<Tarefa>> tarefas;

    public TarefaRepositorio() {
        this.tarefas = new HashMap<>();
    }

    public void adicionarTarefa(String usuario, Tarefa tarefa) {
        if (!tarefas.containsKey(usuario)) {
            tarefas.put(usuario, new ArrayList<>());
        }
        tarefas.get(usuario).add(tarefa);
    }

    public List<Tarefa> getTarefas(String usuario) {
        return tarefas.getOrDefault(usuario, new ArrayList<>());
    }
}
