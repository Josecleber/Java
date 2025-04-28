package pessoa_simples;

public class AppPessoa {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(); // ou Pessoa pessoa = new Pessoa("Ana", 30);

        pessoa.setNome("Ana");
        pessoa.setIdade(30);

        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());
    }
}
