package conta_bancaria;

public class ContaBancaria {
    private int numero;
    private double saldo;

    public ContaBancaria(int numero) {
        this.numero = numero;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente!");
        }
    }
  
    public double getSaldo() {
        return saldo;
    }
}
