public class MediaVetor {
    public static void main(String[] args) {

        double[] vetor = new double[7];
        double soma = 0;
        
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i + 1;  // Preenche o vetor com valores 1, 2, 3, ..., 7
            soma += vetor[i]; // Soma todos os elementos
        }
        
        double media = soma / vetor.length;
        System.out.println("Média dos elementos: " + media);
    }
}
