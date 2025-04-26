package empresa;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Funcionario funcionario1 = new Funcionario(1, "Clênio", 50000);
        Funcionario funcionario2 = new Funcionario(3, "Birtulino", 40000);

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);

        Gerente gerente = new Gerente(2, "Ramon", 80000, "admin", funcionarios);
        System.out.println();
        gerente.mostraDados();
    }
}
