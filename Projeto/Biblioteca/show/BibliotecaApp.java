package show;

import javax.swing.*;
import java.awt.*;

public class BibliotecaApp {
    public static void main(String[] args) {
        // Configuração da janela principal
        JFrame frame = new JFrame("Sistema de Gerenciamento de Biblioteca");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        frame.add(panel);

        // Botões de funcionalidades principais
        JButton btnGerenciarUsuarios = new JButton("Gerenciar Usuários");
        JButton btnGerenciarLivros = new JButton("Gerenciar Livros");
        JButton btnGerenciarEmprestimos = new JButton("Gerenciar Empréstimos");
        panel.add(btnGerenciarUsuarios);
        panel.add(btnGerenciarLivros);
        panel.add(btnGerenciarEmprestimos);

        // Ações dos botões
        btnGerenciarUsuarios.addActionListener(e -> new TelaUsuarios());
        btnGerenciarLivros.addActionListener(e -> new TelaLivros());
        btnGerenciarEmprestimos.addActionListener(e -> new TelaEmprestimos());
        frame.setVisible(true);
    }
}
