package banco_loja;

import javax.swing.JOptionPane;

public class AppBanco {
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Digite o seu nome:");
        String email = JOptionPane.showInputDialog("Digite o seu email:");
        String cpf = JOptionPane.showInputDialog("Digite o seu CPF:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a sua idade:"));
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o seu salário:"));

        Cliente c1 = new Cliente(nome, cpf, email, idade, salario);

        Cliente[] clientes = new Cliente[10];
        clientes[0] = c1;

        System.out.println("Nome: " + c1.getNome());
        System.out.println("Email: " + c1.getEmail());
        System.out.println("CPF: " + c1.getCpf());
        System.out.println("Idade: " + c1.getIdade());
        System.out.println("Salário: " + c1.getSalario());
    }
}
