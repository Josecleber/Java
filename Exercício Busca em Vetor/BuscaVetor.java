import java.util.Scanner;

public class BuscaVetor {
    public static void main(String[] args) {
        int[] vetor = new int[15];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * 100);
        }

        System.out.println("Vetor gerado:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();

        System.out.println("Digite um número para ser buscado no vetor:");

        Scanner scanner = new Scanner(System.in);
        try {
            int numero = Integer.parseInt(scanner.nextLine());
            boolean encontrado = false;

            for (int i = 0; i < vetor.length; i++) {
                if (vetor[i] == numero) {
                    System.out.println("Número encontrado na posição " + i);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Número não encontrado no vetor.");
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida. Insira um número válido.");
        }
        scanner.close();
    }
}
