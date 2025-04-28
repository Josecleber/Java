package soma_matriz;

import java.util.Scanner;

public class SomaMatriz {
    public static void main(String[] args) {
        int[][] matriz = new int[2][2];
        Scanner leitor = new Scanner(System.in);
        int soma = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Informe o valor da linha " + i + " na coluna " + j + ":");
                matriz[i][j] = leitor.nextInt();
                soma += matriz[i][j];
            }
        }

        System.out.println("\nMatriz informada:");
        for (int[] linha : matriz) {
            for (int valor : linha) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }

        System.out.println("\nA soma dos elementos da matriz é " + soma);

        leitor.close();
    }
}
