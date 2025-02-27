import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
    private List<Tarefa> aFazer;
    private List<Tarefa> emProgresso;
    private List<Tarefa> concluido;

    public Board() {
        aFazer = new ArrayList<>();
        emProgresso = new ArrayList<>();
        concluido = new ArrayList<>();
    }

    // Adicionar uma nova tarefa ao quadro
    public void adicionarTarefa(Tarefa tarefa) {
        aFazer.add(tarefa);
    }

    // Mover uma tarefa de uma lista para outra
    public void moverTarefa(Tarefa tarefa, String novoStatus) {
        if (aFazer.contains(tarefa)) {
            aFazer.remove(tarefa);
        } else if (emProgresso.contains(tarefa)) {
            emProgresso.remove(tarefa);
        } else if (concluido.contains(tarefa)) {
            concluido.remove(tarefa);
        }

        switch (novoStatus) {
            case "A Fazer":
                aFazer.add(tarefa);
                break;
            case "Em Progresso":
                emProgresso.add(tarefa);
                break;
            case "Concluído":
                concluido.add(tarefa);
                break;
            default:
                System.out.println("Status inválido!");
                return;
        }

        tarefa.setStatus(novoStatus);
    }

    // Remover uma tarefa do quadro
    public void removerTarefa(Tarefa tarefa) {
        if (aFazer.contains(tarefa)) {
            aFazer.remove(tarefa);
        } else if (emProgresso.contains(tarefa)) {
            emProgresso.remove(tarefa);
        } else if (concluido.contains(tarefa)) {
            concluido.remove(tarefa);
        } else {
            System.out.println("Tarefa não encontrada!");
        }
    }

    // Exibir todas as tarefas no quadro
    public void exibirBoard() {
        System.out.println("\n=== A Fazer ===");
        for (Tarefa tarefa : aFazer) {
            System.out.println(tarefa);
        }

        System.out.println("\n=== Em Progresso ===");
        for (Tarefa tarefa : emProgresso) {
            System.out.println(tarefa);
        }

        System.out.println("\n=== Concluído ===");
        for (Tarefa tarefa : concluido) {
            System.out.println(tarefa);
        }
    }

    // Método para buscar uma tarefa pelo título
    public Tarefa buscarTarefaPorTitulo(String titulo) {
        for (Tarefa tarefa : aFazer) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                return tarefa;
            }
        }
        for (Tarefa tarefa : emProgresso) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                return tarefa;
            }
        }
        for (Tarefa tarefa : concluido) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo)) {
                return tarefa;
            }
        }
        return null; // Tarefa não encontrada
    }
}