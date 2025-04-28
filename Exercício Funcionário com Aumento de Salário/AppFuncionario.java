package funcionario_salario;

public class AppFuncionario {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Carlos", 3000.0, "Analista");

        System.out.println("Antes do aumento:");
        funcionario.exibirInformacoes();

        funcionario.aumentarSalario(10);

        System.out.println("\nDepois do aumento:");
        funcionario.exibirInformacoes();
    }
}
