package loja_simples;

import java.util.Scanner;

public class Loja {
    public static void main(String[] args) {
        Produto[] produtos = new Produto[5];
        Scanner entrada = new Scanner(System.in);

        for (int i = 0; i < produtos.length; i++) {
            produtos[i] = new Produto();

            System.out.print("Informe o nome do produto: ");
            produtos[i].nome = entrada.nextLine();

            System.out.print("Informe o preço do produto: ");
            produtos[i].preco = entrada.nextDouble();

            System.out.print("Informe a quantidade em estoque do produto: ");
            produtos[i].qtdEstoque = entrada.nextInt();

            entrada.nextLine(); // limpar buffer
        }

        System.out.println("\n=== Produtos Cadastrados ===");
        for (Produto p : produtos) {
            System.out.println("Nome: " + p.nome);
            System.out.println("Preço: R$" + p.preco);
            System.out.println("Quantidade em Estoque: " + p.qtdEstoque);
            System.out.println("-------------------------------");
        }
        entrada.close();
    }
}
