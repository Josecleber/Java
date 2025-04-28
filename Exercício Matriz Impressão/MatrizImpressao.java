import java.util.Scanner;

public class MatrizImpressao {
    public static void main(String[] args) {
        int[][] matriz = new int[3][3];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os valores para preencher a matriz 3x3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("Digite o elemento [%d][%d]: ", i, j);
                matriz[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nMatriz 3x3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + "\t"); 
            }
            System.out.println();
        }
    }
}
