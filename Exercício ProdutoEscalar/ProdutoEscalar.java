import java.util.Scanner;

public class ProdutoEscalar {

    public static int calculaProdEscalar(int[] vetor1, int[] vetor2) {
        int produtoEscalar = 0;

        for (int i = 0; i < vetor1.length; i++) {
            produtoEscalar += vetor1[i] * vetor2[i];
        }

        return produtoEscalar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] vetor1 = new int[5];
        int[] vetor2 = new int[5];

        System.out.println("Digite os 5 elementos do primeiro vetor:");
        for (int i = 0; i < vetor1.length; i++) {
            vetor1[i] = scanner.nextInt();
        }

        System.out.println("Digite os 5 elementos do segundo vetor:");
        for (int i = 0; i < vetor2.length; i++) {
            vetor2[i] = scanner.nextInt();
        }

        int resultado = calculaProdEscalar(vetor1, vetor2);

        System.out.println("O produto escalar entre os dois vetores é: " + resultado);

        scanner.close();
    }
}
