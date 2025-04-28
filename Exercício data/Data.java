package data_vetor;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public void exibirData() {
        System.out.printf("%02d/%02d/%04d%n", dia, mes, ano);
    }
}
