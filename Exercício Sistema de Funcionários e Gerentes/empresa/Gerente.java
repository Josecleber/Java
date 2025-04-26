package empresa;

import java.util.List;

public class Gerente extends Funcionario {
    private String senha;
    private List<Funcionario> funcionariosGerenciados;

    public Gerente(int id, String nome, double salario, String senha, List<Funcionario> funcionarios) {
        super(id, nome, salario);
        this.senha = senha;
        this.funcionariosGerenciados = funcionarios;
    }

    public Gerente() {
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Funcionario> getFuncionariosGerenciados() {
        return funcionariosGerenciados;
    }

    public void setFuncionariosGerenciados(List<Funcionario> funcionariosGerenciados) {
        this.funcionariosGerenciados = funcionariosGerenciados;
    }

    // Sobrescrita do método
    @Override
    public void mostraDados() {
        System.out.println("GERENTE:");
        super.mostraDados();
        System.out.println("SENHA: " + senha);
        System.out.println("----- FUNCIONÁRIOS GERENCIADOS -----");
        for (Funcionario f : funcionariosGerenciados) {
            f.mostraDados();
        }
    }
}
