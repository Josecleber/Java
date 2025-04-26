package vetor_lista;

public class TesteRemovePorPosicao {
    public static void main(String[] args) {
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        a1.setNome("Rafael");
        a2.setNome("Paulo");

        VetorLista lista = new VetorLista();
        lista.adiciona(a1);
        lista.adiciona(a2);

        lista.remove(0); // Remove o primeiro aluno (Rafael)

        System.out.println(lista);
    }
}
