public class SomaVetor {
    public static void main(String[] args) {

        int[] vetor = new int[5];
        int soma = 0;

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i + 1; // Preenche o vetor com valores de 1 a 5
            soma += vetor[i]; // Soma os valores
        }
        System.out.println("Soma dos elementos do vetor: " + soma);
    }
}
