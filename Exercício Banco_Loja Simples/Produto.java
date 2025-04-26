package banco_loja;

public class Produto {
    private int codigo;
    private String nome;
    private int quantidade;
    private double preco;

    public Produto() {
        System.out.println("Instância criada!");
    }

    public Produto(String nome) {
        this.nome = nome;
        System.out.println("Instância criada para o produto: " + nome);
    }
}
