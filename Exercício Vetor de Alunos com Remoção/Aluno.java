package vetor_lista;

public class Aluno {
    private String nome;
    private Integer pontuacao;

    public Aluno() {
    }
    public Aluno(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getPontuacao() {
        return pontuacao;
    }
    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Aluno)) return false;
        Aluno other = (Aluno) obj;
        return this.nome.equals(other.nome);
    }
}
