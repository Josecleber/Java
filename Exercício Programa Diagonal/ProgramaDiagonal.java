public class ProgramaDiagonal {
    public static void main(String[] args) {
        int[][] matriz = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = i * 10 + j; 
            }
        }

        System.out.println("Matriz completa:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nDiagonal Principal:");
        for (int i = 0; i < 10; i++) {
            System.out.print(matriz[i][i] + " ");
        }

        System.out.println("\n\nDiagonal Secundária:");
        for (int i = 0; i < 10; i++) {
            System.out.print(matriz[i][9 - i] + " ");
        }
    }
}
