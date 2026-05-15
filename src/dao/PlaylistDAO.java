package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {

    // 1. CRIAR
    public void criarPlaylist(String nome) {
        String sql = "INSERT INTO tbplaylists (nome) VALUES ('" + nome + "')";
        try {
            Connection conn = new Conexao().getConnection();
            conn.createStatement().execute(sql);
        } catch (Exception e) {
            System.out.println("Erro ao criar playlist: " + e.getMessage());
        }
    }

    // 2. LISTAR
    public List<Object[]> listarPlaylists() {
        List<Object[]> lista = new ArrayList<>();
        String sql = "SELECT * FROM tbplaylists";
        try {
            Connection conn = new Conexao().getConnection();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()) {
                lista.add(new Object[]{ rs.getInt("id"), rs.getString("nome") });
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar playlists: " + e.getMessage());
        }
        return lista;
    }

    // 3. EDITAR
    public void editarPlaylist(int id, String novoNome) {
        String sql = "UPDATE tbplaylists SET nome = '" + novoNome + "' WHERE id = " + id;
        try {
            Connection conn = new Conexao().getConnection();
            conn.createStatement().execute(sql);
        } catch (Exception e) {
            System.out.println("Erro ao editar playlist: " + e.getMessage());
        }
    }

    // 4. EXCLUIR
    public void excluirPlaylist(int id) {
        // Primeiro limpamos os vídeos que estavam guardados nessa lista, depois apagamos a lista em si
        String sql1 = "DELETE FROM tb_playlist_video WHERE id_playlist = " + id; 
        String sql2 = "DELETE FROM tbplaylists WHERE id = " + id; 
        try {
            Connection conn = new Conexao().getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute(sql1);
            stmt.execute(sql2);
        } catch (Exception e) {
            System.out.println("Erro ao excluir playlist: " + e.getMessage());
        }
    }
    
    // ================= ADICIONAR E REMOVER VÍDEOS DAS PLAYLISTS =================
    
    public void adicionarVideo(int idPlaylist, int idVideo) {
        String sql = "INSERT INTO tb_playlist_video (id_playlist, id_video) VALUES (" + idPlaylist + ", " + idVideo + ")";
        try {
            Connection conn = new Conexao().getConnection();
            conn.createStatement().execute(sql);
            System.out.println("Vídeo salvo na playlist!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar vídeo na playlist: " + e.getMessage());
        }
    }

    public void removerVideo(int idPlaylist, int idVideo) {
        String sql = "DELETE FROM tb_playlist_video WHERE id_playlist = " + idPlaylist + " AND id_video = " + idVideo;
        try {
            Connection conn = new Conexao().getConnection();
            conn.createStatement().execute(sql);
            System.out.println("Vídeo removido da playlist!");
        } catch (Exception e) {
            System.out.println("Erro ao remover vídeo da playlist: " + e.getMessage());
        }
    }
    
    public java.util.List<Object[]> listarVideosDaPlaylist(int idPlaylist) {
        java.util.List<Object[]> lista = new java.util.ArrayList<>();
        
        // Esse comando SQL "cruza" as tabelas para achar os vídeos da lista certa
        String sql = "SELECT v.* FROM tbvideos v " +
                     "JOIN tb_playlist_video pv ON v.id = pv.id_video " +
                     "WHERE pv.id_playlist = " + idPlaylist;
        
        try {
            java.sql.Connection conn = new dao.Conexao().getConnection();
            java.sql.ResultSet rs = conn.createStatement().executeQuery(sql);
            
            while(rs.next()) {
                lista.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("tipo"),
                    rs.getString("genero")
                });
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar favoritos: " + e.getMessage());
        }
        return lista;
    }
}