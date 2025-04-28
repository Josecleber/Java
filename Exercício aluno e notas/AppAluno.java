package aluno_notas;

public class AppAluno {
    public static void main(String[] args) {
        double[] notas = {8.5, 7.0, 9.5, 6.5};

        Aluno aluno = new Aluno("Ana", "2024001", notas);

        aluno.imprimirInformacoes();
    }
}
