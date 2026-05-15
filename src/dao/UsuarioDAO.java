package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    
    public boolean autenticarUsuario(String email, String senha) {
        Conexao conexaoFabrica = new Conexao();
        
        String sql = "SELECT * FROM tbusuarios WHERE email = ? AND senha = ?";
        
        try (Connection conn = conexaoFabrica.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao autenticar: " + e.getMessage());
            return false;
        }
    }
    
    // ================= MÉTODO DE CADASTRAR NOVO USUÁRIO =================
    public void cadastrarUsuario(String email, String senha) {
        
        String sql = "INSERT INTO tbusuarios (email, senha) VALUES ('" + email + "', '" + senha + "')";
        
        try {
            Conexao conexaoFabrica = new Conexao();
            java.sql.Connection conn = conexaoFabrica.getConnection();
            
            java.sql.Statement stmt = conn.createStatement();
            stmt.execute(sql);
            
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }
    
}