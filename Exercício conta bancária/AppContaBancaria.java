package conta_bancaria;

public class AppContaBancaria {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(12345);

        conta.depositar(500);
        conta.sacar(200);

        System.out.println("Saldo restante: R$" + conta.getSaldo());
    }
}
