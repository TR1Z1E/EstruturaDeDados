import java.util.Scanner;

public class Armazenamento {
    public static void main(String[] args) {

        Pilha[][] Caixa = new Pilha[3][3];
        int capacidadePilha = 5;
        Scanner scanner = new Scanner(System.in);

        // Inicializando todas as pilhas
        for (int i = 0; i < Caixa.length; i++) {
            for (int j = 0; j < Caixa[i].length; j++) {
                Caixa[i][j] = new Pilha(capacidadePilha);
            }
        }

        int opcao;

        // Menu interativo
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Adicionar medicamento");
            System.out.println("2 - Remover medicamento");
            System.out.println("3 - Visualizar Caixa");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            if (opcao >= 1 && opcao <= 3) {

                // Escolha da caixa
                System.out.print("Escolha a caixa (1, 2 ou 3): ");
                int numeroCaixa = scanner.nextInt();
                int indiceCaixa = numeroCaixa - 1;

                // Escolha do compartimento
                System.out.print("Escolha o compartimento (1, 2 ou 3): ");
                int numeroCompartimento = scanner.nextInt();
                int indiceCompartimento = numeroCompartimento - 1;
                scanner.nextLine();

                // Validação
                if (indiceCaixa < 0 || indiceCaixa >= 3 ||
                    indiceCompartimento < 0 || indiceCompartimento >= 3) {
                    System.out.println("Posição inválida!");
                    continue;
                }

                switch (opcao) {

                    case 1:
                        System.out.print("Nome do medicamento: ");
                        String nome = scanner.nextLine();

                        System.out.print("Data de validade: ");
                        String validade = scanner.nextLine();

                        Medicamento m = new Medicamento(nome, validade);
                        Caixa[indiceCaixa][indiceCompartimento].adicionar(m);
                        break;

                    case 2:
                        Medicamento removido = Caixa[indiceCaixa][indiceCompartimento].remover();
                        if (removido != null) {
                            System.out.println("Removido: " + removido);
                        }
                        break;

                    case 3:
                        Caixa[indiceCaixa][indiceCompartimento].exibir();
                        break;
                }
            }

        } while (opcao != 4);

        // Mostrar estado final
        System.out.println("\n--- CONTEÚDO FINAL DAS CAIXAS ---");
        for (int i = 0; i < Caixa.length; i++) {
            for (int j = 0; j < Caixa[i].length; j++) {
                System.out.println("Caixa " + (i + 1) +
                                   " - Compartimento " + (j + 1) + ":");
                Caixa[i][j].exibir();
                System.out.println();
            }
        }

        System.out.println("Sistema encerrado.");
        scanner.close();
    }
}