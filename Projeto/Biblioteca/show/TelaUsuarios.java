package show;

import usuario.Usuario;
import usuario.UsuarioDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

class TelaUsuarios {
    public TelaUsuarios() {
        JFrame frame = new JFrame("Gerenciar Usuários");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nome", "Telefone", "Email"}, 0);
        JTable table = new JTable(model);
        atualizarTabela(model);

        JButton btnAdicionar = new JButton("Adicionar Usuário");
        JButton btnAlterar = new JButton("Alterar Usuário");
        JButton btnDeletar = new JButton("Deletar Usuário");

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdicionar);
        buttonPanel.add(btnAlterar);
        buttonPanel.add(btnDeletar);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        btnAdicionar.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog(frame, "Nome do Usuário:");
            String telefone = JOptionPane.showInputDialog(frame, "Telefone do Usuário:");
            String email = JOptionPane.showInputDialog(frame, "Email do Usuário:");

            try {
                UsuarioDAO dao = new UsuarioDAO();
                dao.adicionarUsuario(new Usuario(0, nome, telefone, email));
                atualizarTabela(model);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao adicionar usuário: " + ex.getMessage());
            }
        });
        btnAlterar.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(frame, "Selecione um usuário para alterar!");
                return;
            }

            int id = (int) model.getValueAt(selectedRow, 0);
            String nome = JOptionPane.showInputDialog(frame, "Novo Nome:", model.getValueAt(selectedRow, 1));
            String telefone = JOptionPane.showInputDialog(frame, "Novo Telefone:", model.getValueAt(selectedRow, 2));
            String email = JOptionPane.showInputDialog(frame, "Novo Email:", model.getValueAt(selectedRow, 3));

            try {
                UsuarioDAO dao = new UsuarioDAO();
                dao.alterarUsuario(new Usuario(id, nome, telefone, email));
                atualizarTabela(model);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao alterar usuário: " + ex.getMessage());
            }
        });

        btnDeletar.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(frame, "Selecione um usuário para deletar!");
                return;
            }

            int id = (int) model.getValueAt(selectedRow, 0);
          
            try {
                UsuarioDAO dao = new UsuarioDAO();
                dao.deletarUsuario(id);
                atualizarTabela(model);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Erro ao deletar usuário: " + ex.getMessage());
            }
        });
        frame.setVisible(true);
    }
    private void atualizarTabela(DefaultTableModel model) {
        try {
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> usuarios = dao.listarUsuarios();
            model.setRowCount(0);

            for (Usuario usuario : usuarios) {
                model.addRow(new Object[]{
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getTelefone(),
                        usuario.getEmail()
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar tabela: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
