package show;

import emprestimo.Emprestimo;
import emprestimo.EmprestimoDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

class TelaEmprestimos {
    public TelaEmprestimos() {
        JFrame frame = new JFrame("Gerenciar Empréstimos");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Usuário ID", "Livro ID", "Data Empréstimo", "Data Devolução"}, 0);
        JTable table = new JTable(model);
        atualizarTabela(model);

        JButton btnAdicionar = new JButton("Adicionar Empréstimo");
        JButton btnAlterar = new JButton("Alterar Empréstimo");
        JButton btnDeletar = new JButton("Deletar Empréstimo");

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdicionar);
        buttonPanel.add(btnAlterar);
        buttonPanel.add(btnDeletar);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(e -> {
            String usuarioIdStr = JOptionPane.showInputDialog(frame, "ID do Usuário:");
            String livroIdStr = JOptionPane.showInputDialog(frame, "ID do Livro:");
            String dataEmprestimo = JOptionPane.showInputDialog(frame, "Data do Empréstimo (YYYY-MM-DD):");
            String dataDevolucao = JOptionPane.showInputDialog(frame, "Data de Devolução (YYYY-MM-DD):");

            try {
                int usuarioId = Integer.parseInt(usuarioIdStr);
                int livroId = Integer.parseInt(livroIdStr);
                EmprestimoDAO dao = new EmprestimoDAO();
                dao.registrarEmprestimo(new Emprestimo(0, usuarioId, livroId, java.time.LocalDate.parse(dataEmprestimo), java.time.LocalDate.parse(dataDevolucao)));
                atualizarTabela(model);
            } catch (NumberFormatException | SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao adicionar empréstimo: " + ex.getMessage());
            }
        });
        btnAlterar.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(frame, "Selecione um empréstimo para alterar!");
                return;
            }
          
            int id = (int) model.getValueAt(selectedRow, 0);
            String usuarioIdStr = JOptionPane.showInputDialog(frame, "Novo ID do Usuário:", model.getValueAt(selectedRow, 1));
            String livroIdStr = JOptionPane.showInputDialog(frame, "Novo ID do Livro:", model.getValueAt(selectedRow, 2));
            String dataEmprestimo = JOptionPane.showInputDialog(frame, "Nova Data de Empréstimo (YYYY-MM-DD):", model.getValueAt(selectedRow, 3));
            String dataDevolucao = JOptionPane.showInputDialog(frame, "Nova Data de Devolução (YYYY-MM-DD):", model.getValueAt(selectedRow, 4));

            try {
                int usuarioId = Integer.parseInt(usuarioIdStr);
                int livroId = Integer.parseInt(livroIdStr);
                EmprestimoDAO dao = new EmprestimoDAO();
                dao.alterarEmprestimo(new Emprestimo(id, usuarioId, livroId, java.time.LocalDate.parse(dataEmprestimo), java.time.LocalDate.parse(dataDevolucao)));
                atualizarTabela(model);
            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao alterar empréstimo: " + ex.getMessage());
            }
        });
        btnDeletar.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(frame, "Selecione um empréstimo para deletar!");
                return;
            }
            int id = (int) model.getValueAt(selectedRow, 0);
            try {
                EmprestimoDAO dao = new EmprestimoDAO();
                dao.deletarEmprestimo(id);
                atualizarTabela(model);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao deletar empréstimo: " + ex.getMessage());
            }
        });
        frame.setVisible(true);
    }
    private void atualizarTabela(DefaultTableModel model) {
        try {
            EmprestimoDAO dao = new EmprestimoDAO();
            List<Emprestimo> emprestimos = dao.listarEmprestimos();
            model.setRowCount(0);

            for (Emprestimo emprestimo : emprestimos) {
                model.addRow(new Object[]{
                        emprestimo.getId(),
                        emprestimo.getUsuarioId(),
                        emprestimo.getLivroId(),
                        emprestimo.getDataEmprestimo(),
                        emprestimo.getDataDevolucao()
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar tabela: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
