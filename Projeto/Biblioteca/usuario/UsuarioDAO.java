package usuario;

import conexao.ConexaoBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public UsuarioDAO() throws SQLException {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS usuarios (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "nome VARCHAR(100), " +
                "telefone VARCHAR(255), " +
                "email VARCHAR(255));";
         Connection con = ConexaoBD.getConnection();
             PreparedStatement stmt = con.prepareStatement(sqlCreateTable);
            stmt.execute();
        }
    public void adicionarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios(nome, telefone, email) VALUES (?, ?, ?)";
        Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getTelefone());
            stmt.setString(3, usuario.getEmail());
            stmt.executeUpdate();
        }
    public List<Usuario> listarUsuarios() throws SQLException {
        String sql = "SELECT * FROM usuarios";
        List<Usuario> usuarios = new ArrayList<>();
        Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email")
                );
                usuarios.add(usuario);
            }
        return usuarios;
    }
    public void alterarUsuario(Usuario usuario) throws SQLException {

        String sql = "UPDATE usuarios SET nome = ?, telefone = ?, email = ? WHERE id = ?";
        Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getTelefone());
            stmt.setString(3, usuario.getEmail());
            stmt.setInt(4, usuario.getId());
            stmt.executeUpdate();
        }
    public void deletarUsuario(int id) throws SQLException {

        String sql = "DELETE FROM usuarios WHERE id = ?";
        Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
}
