package emprestimo;

import conexao.ConexaoBD;
import livro.Livro;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {
    public EmprestimoDAO() throws SQLException {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS emprestimos (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "usuario_id INT, " +
                "livro_id INT, " +
                "data_emprestimo DATE, " +
                "data_devolucao DATE, " +
                "FOREIGN KEY (usuario_id) REFERENCES usuarios(id), " +
                "FOREIGN KEY (livro_id) REFERENCES livros(id));";
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = con.prepareStatement(sqlCreateTable);
        stmt.execute();
    }
    public void registrarEmprestimo(Emprestimo emprestimo) throws SQLException {
        // Verificar se o livro está em estoque
        String verificaEstoque = "SELECT quantidade FROM livros WHERE id = ?";
        Connection conn = ConexaoBD.getConnection();
        PreparedStatement verificaStmt = conn.prepareStatement(verificaEstoque);
        verificaStmt.setInt(1, emprestimo.getLivroId());
        ResultSet rs = verificaStmt.executeQuery();

        if (rs.next()) {
            int quantidade = rs.getInt("quantidade");
            if (quantidade == 0) {
                JOptionPane.showMessageDialog(null, "Sem estoque " );
                return; // Interrompe o registro do empréstimo
            }

            // Registrar o empréstimo
            String sql = "INSERT INTO emprestimos(usuario_id, livro_id, data_emprestimo, data_devolucao) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, emprestimo.getUsuarioId());
            stmt.setInt(2, emprestimo.getLivroId());
            stmt.setDate(3, Date.valueOf(emprestimo.getDataEmprestimo()));
            stmt.setDate(4, Date.valueOf(emprestimo.getDataDevolucao()));
            stmt.executeUpdate();

            // Atualizar a quantidade de livros no estoque
            String atualizaEstoque = "UPDATE livros SET quantidade = quantidade - 1 WHERE id = ?";
            PreparedStatement atualizaStmt = conn.prepareStatement(atualizaEstoque);
            atualizaStmt.setInt(1, emprestimo.getLivroId());
            atualizaStmt.executeUpdate();
        } else {
            System.out.println("Livro não encontrado no sistema.");
        }
    }
    public List<Emprestimo> listarEmprestimos() throws SQLException {
        String sql = "SELECT * FROM emprestimos";
        List<Emprestimo> emprestimos = new ArrayList<>();
        Connection conn = ConexaoBD.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Emprestimo emprestimo = new Emprestimo(
                    rs.getInt("id"),
                    rs.getInt("usuario_id"),
                    rs.getInt("livro_id"),
                    rs.getDate("data_emprestimo").toLocalDate(),
                    rs.getDate("data_devolucao").toLocalDate()
            );
            emprestimos.add(emprestimo);
        }

        return emprestimos;
    }
    public void alterarEmprestimo(Emprestimo emprestimo) throws SQLException {
        String sql = "UPDATE emprestimos SET usuario_id = ?, livro_id = ?, data_emprestimo = ?, data_devolucao = ? WHERE id = ?";
        Connection conn = ConexaoBD.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, emprestimo.getUsuarioId());
        stmt.setInt(2, emprestimo.getLivroId());
        stmt.setDate(3, Date.valueOf(emprestimo.getDataEmprestimo()));
        stmt.setDate(4, Date.valueOf(emprestimo.getDataDevolucao()));
        stmt.setInt(5, emprestimo.getId());
        stmt.executeUpdate();
    }
    public void deletarEmprestimo(int id) throws SQLException {
        String sql = "DELETE FROM emprestimos WHERE id = ?";
        Connection conn = ConexaoBD.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }
}
