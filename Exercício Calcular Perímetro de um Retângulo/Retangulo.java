package retangulo_perimetro;

public class Retangulo {
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public double calcularPerimetro() {
        return 2 * (largura + altura);
    }
}
