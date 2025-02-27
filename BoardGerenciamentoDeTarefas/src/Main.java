import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Mover Tarefa");
            System.out.println("3. Remover Tarefa");
            System.out.println("4. Exibir Board");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título da tarefa: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    Tarefa novaTarefa = new Tarefa(titulo, descricao);
                    board.adicionarTarefa(novaTarefa);
                    System.out.println("Tarefa adicionada com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o título da tarefa que deseja mover: ");
                    String tituloMover = scanner.nextLine();
                    Tarefa tarefaMover = board.buscarTarefaPorTitulo(tituloMover);
                    if (tarefaMover != null) {
                        System.out.print("Para qual status mover? (A Fazer, Em Progresso, Concluído): ");
                        String novoStatus = scanner.nextLine();
                        board.moverTarefa(tarefaMover, novoStatus);
                        System.out.println("Tarefa movida com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o título da tarefa que deseja remover: ");
                    String tituloRemover = scanner.nextLine();
                    Tarefa tarefaRemover = board.buscarTarefaPorTitulo(tituloRemover);
                    if (tarefaRemover != null) {
                        board.removerTarefa(tarefaRemover);
                        System.out.println("Tarefa removida com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada!");
                    }
                    break;

                case 4:
                    board.exibirBoard();
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}