package vetor_lista;

public class VetorLista {
    private Aluno[] alunos = new Aluno[100];
    private int qtdade = 0;

    public void adiciona(Aluno aluno) {
        alunos[qtdade] = aluno;
        qtdade++;
    }

    public void adiciona(int posicao, Aluno aluno) {
        if (posicao < 0 || posicao > qtdade) {
            throw new RuntimeException("Posição inválida!");
        }
        if (posicao != qtdade) {
            for (int i = qtdade - 1; i >= posicao; i--) {
                alunos[i + 1] = alunos[i];
            }
        }
        alunos[posicao] = aluno;
        qtdade++;  // Aqui seu código tinha um `qtdade--` errado. Corrigi para `qtdade++`
    }

    public Aluno pega(int posicao) {
        if (posicao < 0 || posicao >= qtdade) {
            throw new RuntimeException("Posição inválida!");
        }
        return alunos[posicao];
    }

    public void remove(int posicao) {
        if (posicao < 0 || posicao >= qtdade) {
            throw new RuntimeException("Posição inválida!");
        }
        for (int i = posicao + 1; i < qtdade; i++) {
            alunos[i - 1] = alunos[i];
        }
        qtdade--;
    }

    public boolean contem(Aluno aluno) {
        for (int i = 0; i < qtdade; i++) {
            if (aluno.equals(alunos[i])) {
                return true;
            }
        }
        return false;
    }

    public int tamanho() {
        return qtdade;
    }

    @Override
    public String toString() {
        if (qtdade == 0) return "[]";
        StringBuilder saida = new StringBuilder("[");
        for (int i = 0; i < qtdade - 1; i++) {
            saida.append(alunos[i].toString()).append(", ");
        }
        saida.append(alunos[qtdade - 1]).append("]");
        return saida.toString();
    }
}
