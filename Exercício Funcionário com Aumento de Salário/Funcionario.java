package funcionario_salario;

public class Funcionario {
    private String nome;
    private double salario;
    private String cargo;

    public Funcionario(String nome, double salario, String cargo) {
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
    }

    public void aumentarSalario(double porcentagem) {
        salario += salario * (porcentagem / 100);
    }

    public double getSalario() {
        return salario;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.printf("Salário: R$ %.2f%n", salario);
    }
}
