package quadrado_area;

public class AppQuadrado {
    public static void main(String[] args) {
        Quadrado quadrado = new Quadrado(5);
        double area = quadrado.calcularArea();
        System.out.println("Área do quadrado: " + area);
    }
}
