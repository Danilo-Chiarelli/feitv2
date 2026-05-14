package controller;

import dao.Conexao;

public class FeiTv2 { 

    public static void main(String[] args) {
        try {
            Conexao conexaoFabrica = new Conexao();
            java.sql.Connection teste = conexaoFabrica.getConnection();
            
            if (teste != null) {
                System.out.println("✅ CONECTADO COM SUCESSO!");
                teste.close();
            }
        } catch (Exception e) {
            System.out.println("❌ ERRO NA CONEXÃO:");
            e.printStackTrace();
        }
    }
    
} 