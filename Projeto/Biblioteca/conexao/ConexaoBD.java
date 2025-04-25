package conexao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoBD {
    private static Connection con = null;
    private static final String URL = "jdbc:h2:mem:BookStore";
    private static final String USER = "sa";
    private static final String PASS = "";


    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
    public static Connection getConnection() throws SQLException {
        if(con == null){
            con = DriverManager.getConnection(URL, USER, PASS);
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!");
        }
        return con;
    }


    public static void closeConnection(PreparedStatement stmt, Connection con) throws SQLException {
        con.close();
        stmt.close();

    }
}
