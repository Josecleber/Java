public class VetorImpressao {
    public static void main(String[] args) {

        int[] vetor = new int[10];

        // Preenche o vetor com os números de 1 a 10
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i + 1;
        }

        // Imprime todos os elementos do vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Elemento na posição " + i + ": " + vetor[i]);
        }
    }
}
