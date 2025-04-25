import java.util.Scanner;

public class AcimaDaMedia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int C = scanner.nextInt();

        for (int i = 0; i < C; i++) {
            int N = scanner.nextInt();
            int[] notas = new int[N];
            int soma = 0;

            for (int j = 0; j < N; j++) {
                notas[j] = scanner.nextInt();
                soma += notas[j];
            }

            double media = soma / (double) N;

            int acimaDaMedia = 0;
            for (int j = 0; j < N; j++) {
                if (notas[j] > media) {
                    acimaDaMedia++;
                }
            }

            double percentual = (acimaDaMedia * 100.0) / N;

            System.out.println(acimaDaMedia);
            System.out.printf("%.3f%%\n", percentual);
        }

        scanner.close();
    }
}
