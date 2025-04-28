package retangulo_perimetro;

public class AppRetangulo {
    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo(4, 6);
        double perimetro = retangulo.calcularPerimetro();
        System.out.println("Perímetro do retângulo: " + perimetro);
    }
}
