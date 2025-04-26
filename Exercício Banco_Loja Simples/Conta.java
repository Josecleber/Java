package banco_loja;

public class Conta {
    private String titular;
    private String numero;
    private double saldo;

    public Conta(String titular) {
        this.titular = titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTitular() {
        return titular;
    }
}
