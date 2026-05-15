package dao;
import java.sql.*;
import java.util.*;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.SQLException;


public class VideoDAO {

    // MÉTODO CADASTRAR (Agora com situação)
    public void cadastrarVideo(String titulo, String tipo, String genero, String situacao) {
        String sql = "INSERT INTO tbvideos (titulo, tipo, genero, situacao) VALUES ('" + titulo + "', '" + tipo + "', '" + genero + "', '" + situacao + "')";
        try {
            Connection conn = new Conexao().getConnection();
            conn.createStatement().execute(sql);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    // MÉTODO LISTAR (Agora busca a situação também)
    public List<Object[]> listarVideos() {
        List<Object[]> lista = new ArrayList<>();
        String sql = "SELECT * FROM tbvideos";
        try {
            ResultSet rs = new Conexao().getConnection().createStatement().executeQuery(sql);
            while(rs.next()) {
Object[] linha = { rs.getInt("id"), rs.getString("titulo"), rs.getString("tipo"), rs.getString("genero"), rs.getString("situacao"), rs.getInt("curtidas"),  rs.getInt("descurtidas")};                lista.add(linha);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return lista;
    }

    // MÉTODO EDITAR (O "U" do CRUD - Update)
    public void editarVideo(int id, String titulo, String tipo, String genero, String situacao) {
        String sql = "UPDATE tbvideos SET titulo='" + titulo + "', tipo='" + tipo + "', genero='" + genero + "', situacao='" + situacao + "' WHERE id = " + id;
        try {
            Connection conn = new Conexao().getConnection();
            conn.createStatement().execute(sql);
        } catch (Exception e) {
            System.out.println("Erro ao editar: " + e.getMessage());
        }
    }
    
    // MÉTODO EXCLUIR (O "D" do CRUD - Delete)
    public void excluirVideo(int id) {
        String sql = "DELETE FROM tbvideos WHERE id = " + id;
        try {
            Connection conn = new Conexao().getConnection();
            conn.createStatement().execute(sql);
        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }
    // ================= MÉTODO BUSCAR POR NOME =================
    public java.util.List<Object[]> buscarVideoPorNome(String nomeBusca) {
        java.util.List<Object[]> lista = new java.util.ArrayList<>();
        
        // O % antes e depois significa que a palavra pode estar no meio do título
        String sql = "SELECT * FROM tbvideos WHERE titulo ILIKE '%" + nomeBusca + "%'";
        
        try {
            Connection conn = new Conexao().getConnection();
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                Object[] linha = {
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("tipo"),
                    rs.getString("genero"),
                    rs.getString("situacao"),
                    rs.getString("curtidas"),
                    rs.getString("descurtidas")
                    
                };
                lista.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        }
        
        return lista;
    }
    
    // ================= MÉTODOS DE CURTIR E DESCURTIR =================
    public void curtirVideo(int id) {
        // O banco de dados pega o valor atual e soma 1
        String sql = "UPDATE tbvideos SET curtidas = curtidas + 1 WHERE id = " + id;
        try {
            java.sql.Connection conn = new Conexao().getConnection();
            conn.createStatement().execute(sql);
        } catch (Exception e) {
            System.out.println("Erro ao curtir: " + e.getMessage());
        }
    }

    public void descurtirVideo(int id) {
        // Agora ele soma 1 na coluna certa (descurtidas)
        String sql = "UPDATE tbvideos SET descurtidas = descurtidas + 1 WHERE id = " + id;
        try {
            java.sql.Connection conn = new Conexao().getConnection();
            conn.createStatement().execute(sql);
        } catch (Exception e) {
            System.out.println("Erro ao descurtir: " + e.getMessage());
        }
    }
}
