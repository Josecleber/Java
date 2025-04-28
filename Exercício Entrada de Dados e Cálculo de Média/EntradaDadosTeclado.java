package entrada_dados_teclado;

import java.util.Scanner;

public class EntradaDadosTeclado {
    public static void main(String[] args) {
        int n1, n2, n3, n4, n5;
        float media;

        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um número: ");
        n1 = leitor.nextInt();

        System.out.println("Digite um número: ");
        n2 = leitor.nextInt();

        System.out.println("Digite um número: ");
        n3 = leitor.nextInt();

        System.out.println("Digite um número: ");
        n4 = leitor.nextInt();

        System.out.println("Digite um número: ");
        n5 = leitor.nextInt();

        media = (n1 + n2 + n3 + n4 + n5) / 5f;

        System.out.println("Média é " + media);

        leitor.close();
    }
}
