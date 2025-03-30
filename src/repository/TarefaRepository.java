package repository;

import model.Tarefa;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Princípios SOLID aplicados:
 * - SRP (Single Responsibility Principle): A classe tem uma única responsabilidade: gerenciar as tarefas(adicionar, listar, filtrar e validar tarefas). 
 *   Ela não se preocupa com a lógica de negócios ou com a interação com o usuário. Tudo relacionado ao armazenamento e manipulação de tarefas é feito aqui, tornando a classe focada em uma única tarefa.
 * 
 * - OCP (Open/Closed Principle): A classe está "fechada para modificações", ou seja, suas funcionalidades principais (adicionar, listar e validar tarefas) não precisam ser modificadas quando novas tarefas ou novas funcionalidades forem adicionadas.
 *   No entanto, ela está "aberta para extensão". Por exemplo, se no futuro for necessário implementar um novo tipo de dado (como em um banco de dados ou em um arquivo), a classe pode ser estendida para oferecer suporte a essas novas formas de dados sem alterar o código existente.
 */
public class TarefaRepository {
    private final List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return new ArrayList<>(tarefas);
    }
    
    public String tarefasUsuario(){
    String tarefasUsuario = "";    
    for (int i = 0; i < tarefas.size(); i++) {
        Tarefa t = tarefas.get(i);
        tarefasUsuario += "\nId: " + i + " - Descrição: " + t.getDescricao() + " - Prioridade: " + t.getPrioridade() + " - Concluída: " + t.isConcluida();
    }
    return tarefasUsuario;    
    }

    public String filtrarPorPrioridade(int prioridade) {
    String tarefasListadas = ""; 
    List<Tarefa> tarefasFiltradas = tarefas.stream()
                .filter(t -> t.getPrioridade() == prioridade)
                .collect(Collectors.toList());
        
    for (int i = 0; i < tarefasFiltradas.size(); i++) {
        Tarefa t = tarefasFiltradas.get(i);
        tarefasListadas += "\nId: " + i + " - Descrição: " + t.getDescricao() + " - Prioridade: " + t.getPrioridade() + " - Concluída: " + t.isConcluida();
    }
    return tarefasListadas;  
    }
    
    public boolean verificaPrioridade(int prioridade) {
        if (prioridade != 1 && prioridade != 2 && prioridade != 3) {
            return false;
        } else{
            return true;
        }
    }
    
    public boolean validaTarefa(int id) {
    List<Tarefa> tarefas = listarTarefas();
    
    // Verificando se o índice existe na lista
    if (id >= 0 && id < tarefas.size()) {
        Tarefa t = tarefas.get(id);
        
        if(t.isConcluida() == true){
            return false;
        }else{
        return true;
        }
        
        } else {
        return false;
    }
    }
    
}
