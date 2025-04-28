import java.util.Scanner;

public class EntradaDadosOtimizada {
    public static void main(String[] args) {
        int n;
        float soma = 0;
        Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Dígite um número:");
            n = leitor.nextInt();
            soma = soma + n;
        }
        System.out.println("Média é " + soma/5);
    }
}
