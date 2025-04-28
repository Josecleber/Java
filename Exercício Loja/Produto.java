package loja_simples;

public class Produto {
    int codigo;
    String nome;
    int qtdEstoque;
    double preco;

    void atualizarPromocao(double porcentagem) {
        preco = preco * (1 + (porcentagem / 100));
    }
}
