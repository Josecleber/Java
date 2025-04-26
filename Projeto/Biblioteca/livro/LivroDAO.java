package livro;

import conexao.ConexaoBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    public LivroDAO() throws SQLException {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS livros (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "titulo VARCHAR(100), " +
                "autor VARCHAR(255), " +
                "genero VARCHAR(255), " +
                "quantidade INT);";
        Connection con = ConexaoBD.getConnection();
        PreparedStatement stmt = con.prepareStatement(sqlCreateTable);
        stmt.execute();
    }
    public void adicionarLivro(Livro livro) throws SQLException {
        String sql = "INSERT INTO livros(titulo, autor, genero, quantidade) VALUES (?, ?, ?, ?)";
        Connection conn = ConexaoBD.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, livro.getTitulo());
        stmt.setString(2, livro.getAutor());
        stmt.setString(3, livro.getGenero());
        stmt.setInt(4, livro.getQuantidade());
        stmt.executeUpdate();
    }
    public List<Livro> listarLivros() throws SQLException {
        String sql = "SELECT * FROM livros";
        List<Livro> livros = new ArrayList<>();
        Connection conn = ConexaoBD.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Livro livro = new Livro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("genero"),
                    rs.getInt("quantidade")
            );
            livros.add(livro);
        }
        return livros;
    }
    public void alterarLivro(Livro livro) throws SQLException {
        String sql = "UPDATE livros SET titulo = ?, autor = ?, genero = ?, quantidade = ? WHERE id = ?";
        Connection conn = ConexaoBD.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, livro.getTitulo());
        stmt.setString(2, livro.getAutor());
        stmt.setString(3, livro.getGenero());
        stmt.setInt(4, livro.getQuantidade());
        stmt.setInt(5, livro.getId());
        stmt.executeUpdate();
    }
    public void deletarLivro(int id) throws SQLException {
        String sql = "DELETE FROM livros WHERE id = ?";
        Connection conn = ConexaoBD.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }
}
