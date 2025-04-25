import java.util.Scanner;

class Recorde {
    String nome;
    int score;

    public Recorde(String nome, int score) {
        this.nome = nome;
        this.score = score;
    }

    public String toString() {
        return "Nome: " + nome + " | Score: " + score;
    }
}

public class Recordes {
    static Recorde[] recordes = new Recorde[10];
    static int quantidade = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < recordes.length; i++) {
            recordes[i] = new Recorde("Jogador" + (i + 1), (int)(Math.random() * 100));
            quantidade++;
        }

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 – Entrar recorde");
            System.out.println("2 – Ver todos os recordes");
            System.out.println("3 – Ordenar por score (seleção)");
            System.out.println("4 – Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    entrarRecorde(scanner);
                    break;
                case 2:
                    mostrarRecordes();
                    break;
                case 3:
                    ordenarPorSelecao();
                    System.out.println("Recordes ordenados por score.");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 4);

        scanner.close();
    }

    public static void entrarRecorde(Scanner scanner) {
        System.out.print("Digite o nome do jogador: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o score: ");
        int score = scanner.nextInt();
        scanner.nextLine();

        Recorde novo = new Recorde(nome, score);

        if (quantidade == recordes.length) {
            for (int i = recordes.length - 1; i > 0; i--) {
                recordes[i] = recordes[i - 1];
            }
            recordes[0] = novo;
        } else {
            for (int i = quantidade; i > 0; i--) {
                recordes[i] = recordes[i - 1];
            }
            recordes[0] = novo;
            quantidade++;
        }

        System.out.println("Recorde inserido com sucesso.");
    }

    public static void mostrarRecordes() {
        System.out.println("\nRecordes:");
        for (int i = 0; i < quantidade; i++) {
            System.out.println((i + 1) + ". " + recordes[i]);
        }
    }

    public static void ordenarPorSelecao() {
        for (int i = 0; i < quantidade - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < quantidade; j++) {
                if (recordes[j].score < recordes[indiceMenor].score) {
                    indiceMenor = j;
                }
            }

            Recorde temp = recordes[i];
            recordes[i] = recordes[indiceMenor];
            recordes[indiceMenor] = temp;
        }
    }
}
