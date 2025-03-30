package service;

import model.Tarefa;
import repository.TarefaRepository;
import java.util.List;

/**
* 
 * Princípios SOLID aplicados:
 * - DIP (Dependency Inversion Principle): A calsse depende de uma abstração (TarefaRepository) ao invés de ter implementação própria na classe.
 */
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService() {
        this.tarefaRepository = new TarefaRepository();
    }

    public void criarTarefa(String descricao, int prioridade) {
        Tarefa tarefa = new Tarefa(descricao, prioridade);
        tarefaRepository.adicionarTarefa(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.listarTarefas();
    }
    
    public String tarefasUsuario(){
    return tarefaRepository.tarefasUsuario();  
    }

    public void concluirTarefa(int idTarefa) {
        Tarefa tarefa = tarefaRepository.listarTarefas().get(idTarefa);
        tarefa.marcarComoConcluida();
    }

    public String filtrarTarefasPorPrioridade(int prioridade) {
        return tarefaRepository.filtrarPorPrioridade(prioridade);
    }
    
    public boolean verificaPrioridade(int prioridade) {
        return tarefaRepository.verificaPrioridade(prioridade);    
    }
    public boolean validaTarefa(int id) {
        return tarefaRepository.validaTarefa(id);    
    }
}
