package show;

import livro.LivroDAO;
import livro.Livro;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

class TelaLivros {
    public TelaLivros() {
        JFrame frame = new JFrame("Gerenciar Livros");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Título", "Autor", "Gênero", "Quantidade"}, 0);
        JTable table = new JTable(model);
        atualizarTabela(model);

        JButton btnAdicionar = new JButton("Adicionar Livro");
        JButton btnAlterar = new JButton("Alterar Livro");
        JButton btnDeletar = new JButton("Deletar Livro");

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdicionar);
        buttonPanel.add(btnAlterar);
        buttonPanel.add(btnDeletar);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(e -> {
            String titulo = JOptionPane.showInputDialog(frame, "Título do Livro:");
            String autor = JOptionPane.showInputDialog(frame, "Autor do Livro:");
            String genero = JOptionPane.showInputDialog(frame, "Gênero do Livro:");
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog(frame, "Quantidade do Livro:"));

            try {
                LivroDAO dao = new LivroDAO();
                dao.adicionarLivro(new Livro(0, titulo, autor, genero, quantidade));
                atualizarTabela(model);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao adicionar livro: " + ex.getMessage());
            }
        });

        btnAlterar.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(frame, "Selecione um livro para alterar!");
                return;
            }

            int id = (int) model.getValueAt(selectedRow, 0);
            String titulo = JOptionPane.showInputDialog(frame, "Novo Título:", model.getValueAt(selectedRow, 1));
            String autor = JOptionPane.showInputDialog(frame, "Novo Autor:", model.getValueAt(selectedRow, 2));
            String genero = JOptionPane.showInputDialog(frame, "Novo Gênero:", model.getValueAt(selectedRow, 3));
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog(frame, "Nova Quantidade:", model.getValueAt(selectedRow, 4)));

            try {
                LivroDAO dao = new LivroDAO();
                dao.alterarLivro(new Livro(id, titulo, autor, genero, quantidade));
                atualizarTabela(model);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao alterar livro: " + ex.getMessage());
            }
        });

        btnDeletar.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(frame, "Selecione um livro para deletar!");
                return;
            }

            int id = (int) model.getValueAt(selectedRow, 0);

            try {
                LivroDAO dao = new LivroDAO();
                dao.deletarLivro(id);
                atualizarTabela(model);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao deletar livro: " + ex.getMessage());
            }
        });
        frame.setVisible(true);
    }
    private void atualizarTabela(DefaultTableModel model) {
        try {
            LivroDAO dao = new LivroDAO();
            List<Livro> livros = dao.listarLivros();
            model.setRowCount(0);

            for (Livro livro : livros) {
                model.addRow(new Object[]{
                        livro.getId(),
                        livro.getTitulo(),
                        livro.getAutor(),
                        livro.getGenero(),
                        livro.getQuantidade()
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar tabela: " + ex.getMessage());
            ex.printStackTrace();
        }
    }}
